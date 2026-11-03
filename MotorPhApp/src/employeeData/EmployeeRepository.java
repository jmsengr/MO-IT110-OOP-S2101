package employeeData;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.AtomicMoveNotSupportedException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public final class EmployeeRepository {

    public static final int FIELD_COUNT = 19;

    private static final String[] HEADER = {
            "Employee #", "Last Name", "First Name", "Birthday", "Address", "Phone Number",
            "SSS #", "Philhealth #", "TIN #", "Pag-ibig #", "Status", "Position",
            "Immediate Supervisor", "Basic Salary", "Rice Subsidy", "Phone Allowance",
            "Clothing Allowance", "Gross Semi-monthly Rate", "Hourly Rate"
    };
    private static final Object LOCK = new Object();
    private static final EmployeeRepository INSTANCE = new EmployeeRepository(resolveDataFile());

    private final Path dataFile;

    private EmployeeRepository(Path dataFile) {
        this.dataFile = dataFile;
    }

    public static EmployeeRepository getInstance() {
        return INSTANCE;
    }

    public static String[] parseCsvLine(String line) throws IOException {
        List<String> fields = new ArrayList<>();
        StringBuilder field = new StringBuilder();
        boolean quoted = false;

        for (int i = 0; i < line.length(); i++) {
            char current = line.charAt(i);
            if (current == '"') {
                if (quoted && i + 1 < line.length() && line.charAt(i + 1) == '"') {
                    field.append('"');
                    i++;
                } else {
                    quoted = !quoted;
                }
            } else if (current == ',' && !quoted) {
                fields.add(field.toString());
                field.setLength(0);
            } else {
                field.append(current);
            }
        }

        if (quoted) {
            throw new IOException("Invalid CSV row: unterminated quoted field.");
        }

        fields.add(field.toString());
        return fields.toArray(new String[0]);
    }

    public List<String[]> findAll() throws IOException {
        synchronized (LOCK) {
            initializeIfNeeded();
            return readRows(dataFile);
        }
    }

    public Optional<String[]> findById(String employeeId) throws IOException {
        String normalizedId = employeeId.trim();
        return findAll().stream()
                .filter(row -> row[0].trim().equals(normalizedId))
                .findFirst();
    }

    public void add(String[] employee) throws IOException {
        validateEmployee(employee);
        synchronized (LOCK) {
            List<String[]> employees = findAll();
            if (employees.stream().anyMatch(row -> row[0].trim().equals(employee[0].trim()))) {
                throw new IOException("An employee with ID " + employee[0].trim() + " already exists.");
            }
            employees.add(employee.clone());
            writeRows(employees);
        }
    }

    public void update(String employeeId, String[] employee) throws IOException {
        validateEmployee(employee);
        String normalizedId = employeeId.trim();
        if (!employee[0].trim().equals(normalizedId)) {
            throw new IOException("An employee ID cannot be changed.");
        }

        synchronized (LOCK) {
            List<String[]> employees = findAll();
            for (int i = 0; i < employees.size(); i++) {
                if (employees.get(i)[0].trim().equals(normalizedId)) {
                    employees.set(i, employee.clone());
                    writeRows(employees);
                    return;
                }
            }
        }
        throw new IOException("Employee ID " + normalizedId + " was not found.");
    }

    public boolean delete(String employeeId) throws IOException {
        String normalizedId = employeeId.trim();
        synchronized (LOCK) {
            List<String[]> employees = findAll();
            boolean removed = employees.removeIf(row -> row[0].trim().equals(normalizedId));
            if (removed) {
                writeRows(employees);
            }
            return removed;
        }
    }

    private static Path resolveDataFile() {
        String configuredPath = System.getProperty("motorph.data.file");
        if (configuredPath != null && !configuredPath.trim().isEmpty()) {
            return Path.of(configuredPath).toAbsolutePath().normalize();
        }
        return Path.of(System.getProperty("user.home"), ".motorph", "employees.csv")
                .toAbsolutePath().normalize();
    }

    private void initializeIfNeeded() throws IOException {
        if (Files.exists(dataFile)) {
            return;
        }

        synchronized (LOCK) {
            if (Files.exists(dataFile)) {
                return;
            }

            Map<String, String[]> employees = new LinkedHashMap<>();
            InputStream seed = EmployeeRepository.class.getResourceAsStream("/data/EmployeeDetails.csv");
            if (seed != null) {
                readRows(seed, employees);
            }

            Path workingDirectory = Path.of(System.getProperty("user.dir"));
            addSeedFile(workingDirectory.resolve(Path.of("MotorPhApp", "src", "EmployeeDetails.csv")), employees);
            addSeedFile(workingDirectory.resolve(Path.of("With Update", "src", "Employee Details.csv")), employees);
            if (employees.isEmpty()) {
                throw new IOException("No employee data was found to initialize " + dataFile + ".");
            }

            Files.createDirectories(dataFile.getParent());
            writeRows(new ArrayList<>(employees.values()));
        }
    }

    private static void addSeedFile(Path seedFile, Map<String, String[]> employees) throws IOException {
        if (!Files.isRegularFile(seedFile)) {
            return;
        }
        try (BufferedReader reader = Files.newBufferedReader(seedFile, StandardCharsets.UTF_8)) {
            readRows(reader, employees);
        }
    }

    private static void readRows(InputStream input, Map<String, String[]> employees) throws IOException {
        try (BufferedReader reader = new BufferedReader(
                new java.io.InputStreamReader(input, StandardCharsets.UTF_8))) {
            readRows(reader, employees);
        }
    }

    private static void readRows(BufferedReader reader, Map<String, String[]> employees) throws IOException {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] row = parseCsvLine(line);
            if (isHeader(row)) {
                continue;
            }
            validateEmployee(row);
            employees.putIfAbsent(row[0].trim(), row);
        }
    }

    private static List<String[]> readRows(Path path) throws IOException {
        List<String[]> employees = new ArrayList<>();
        Set<String> employeeIds = new HashSet<>();
        try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] row = parseCsvLine(line);
                if (isHeader(row)) {
                    continue;
                }
                validateEmployee(row);
                if (!employeeIds.add(row[0].trim())) {
                    throw new IOException("Duplicate employee ID " + row[0].trim() + " in " + path + ".");
                }
                employees.add(row);
            }
        }
        return employees;
    }

    private static boolean isHeader(String[] row) {
        return row.length > 0 && row[0].trim().equalsIgnoreCase(HEADER[0]);
    }

    private void writeRows(List<String[]> employees) throws IOException {
        Path parent = dataFile.getParent();
        Files.createDirectories(parent);
        Path temporaryFile = Files.createTempFile(parent, "employees-", ".csv.tmp");
        try {
            try (BufferedWriter writer = Files.newBufferedWriter(temporaryFile, StandardCharsets.UTF_8)) {
                writer.write(String.join(",", HEADER));
                writer.newLine();
                for (String[] employee : employees) {
                    validateEmployee(employee);
                    for (int i = 0; i < employee.length; i++) {
                        if (i > 0) {
                            writer.write(',');
                        }
                        writer.write(escapeCsv(employee[i]));
                    }
                    writer.newLine();
                }
            }
            try {
                Files.move(temporaryFile, dataFile, StandardCopyOption.ATOMIC_MOVE,
                        StandardCopyOption.REPLACE_EXISTING);
            } catch (AtomicMoveNotSupportedException e) {
                Files.move(temporaryFile, dataFile, StandardCopyOption.REPLACE_EXISTING);
            }
        } finally {
            Files.deleteIfExists(temporaryFile);
        }
    }

    private static String escapeCsv(String value) {
        String safeValue = value == null ? "" : value;
        if (safeValue.contains(",") || safeValue.contains("\"")
                || safeValue.contains("\n") || safeValue.contains("\r")) {
            return "\"" + safeValue.replace("\"", "\"\"") + "\"";
        }
        return safeValue;
    }

    private static void validateEmployee(String[] employee) throws IOException {
        if (employee == null || employee.length != FIELD_COUNT) {
            throw new IOException("Employee records must contain exactly " + FIELD_COUNT + " fields.");
        }
        if (employee[0] == null || employee[0].trim().isEmpty()) {
            throw new IOException("Employee ID cannot be empty.");
        }
        for (String value : employee) {
            if (value != null && (value.contains("\n") || value.contains("\r"))) {
                throw new IOException("Employee fields cannot contain line breaks.");
            }
        }
    }
}
