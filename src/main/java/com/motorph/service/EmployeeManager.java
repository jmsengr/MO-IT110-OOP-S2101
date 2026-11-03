package com.motorph.service;

import com.motorph.data.EmployeeRepository;
import com.motorph.model.Employee;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Optional;

public class EmployeeManager {

    private final EmployeeRepository repository;

    public EmployeeManager() {
        repository = EmployeeRepository.getInstance();
    }

    public List<Employee> findAll() throws IOException {
        List<Employee> employees = new ArrayList<>();
        for (String[] record : repository.findAll()) {
            employees.add(fromRecord(record));
        }
        return employees;
    }

    public Optional<Employee> findById(String employeeId) throws IOException {
        return repository.findById(employeeId).map(EmployeeManager::fromRecord);
    }

    public Optional<Employee> authenticate(String employeeId, String birthday) throws IOException {
        Optional<Employee> employee = findById(employeeId);
        if (employee.isEmpty() || !employee.get().getBirthday().trim().equals(birthday.trim())) {
            return Optional.empty();
        }
        return employee;
    }

    public boolean isHrEmployee(Employee employee) {
        String position = Objects.requireNonNull(employee, "employee").getPosition().trim()
                .toLowerCase(Locale.ROOT);
        return position.equals("hr manager") || position.equals("hr team leader")
                || position.equals("hr rank and file");
    }

    public int getNextEmployeeId() throws IOException {
        return repository.findAll().stream()
                .mapToInt(employee -> {
                    try {
                        return Integer.parseInt(employee[0].trim());
                    } catch (NumberFormatException e) {
                        return 0;
                    }
                })
                .max()
                .orElse(0) + 1;
    }

    public void add(Employee employee) throws IOException {
        repository.add(toRecord(employee));
    }

    public void update(String employeeId, Employee employee) throws IOException {
        repository.update(employeeId, toRecord(employee));
    }

    public boolean delete(String employeeId) throws IOException {
        return repository.delete(employeeId);
    }

    private static Employee fromRecord(String[] record) {
        if (record.length != EmployeeRepository.FIELD_COUNT) {
            throw new IllegalArgumentException(
                    "Employee records must contain exactly " + EmployeeRepository.FIELD_COUNT + " fields.");
        }
        return new Employee(
                record[0], record[1], record[2], record[3], record[4], record[5], record[6],
                record[7], record[8], record[9], record[10], record[11], record[12], record[13],
                record[14], record[15], record[16], record[17], record[18]);
    }

    private static String[] toRecord(Employee employee) {
        Objects.requireNonNull(employee, "employee");
        return new String[] {
                employee.getEmployeeId(), employee.getLastName(), employee.getFirstName(), employee.getBirthday(),
                employee.getAddress(), employee.getPhoneNumber(), employee.getSssNumber(),
                employee.getPhilhealthNumber(), employee.getTin(), employee.getPagibigNumber(),
                employee.getStatus(), employee.getPosition(), employee.getSupervisor(), employee.getBasicSalary(),
                employee.getRiceSubsidy(), employee.getPhoneAllowance(), employee.getClothingAllowance(),
                employee.getGrossSemiMonthlyRate(), employee.getHourlyRate()
        };
    }
}
