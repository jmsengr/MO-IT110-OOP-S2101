package adminDashboard;

import GUI.Employee;
import employeeData.EmployeeRepository;

public class searchResultsFrame extends GUI.EmployeeProfile {

    private static final long serialVersionUID = 1L;

    public searchResultsFrame(Employee employee) {
        super(employee.getEmployeeId(), null);
    }

    public searchResultsFrame(String[] employeeDetails) {
        super(employeeId(employeeDetails), null);
    }

    private static String employeeId(String[] employeeDetails) {
        if (employeeDetails == null || employeeDetails.length != EmployeeRepository.FIELD_COUNT) {
            throw new IllegalArgumentException("A complete employee record is required.");
        }
        return employeeDetails[0];
    }

    public static void main(String[] args) {
        GUI.Login.main(args);
    }
}
