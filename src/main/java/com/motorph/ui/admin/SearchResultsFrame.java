package com.motorph.ui.admin;

import com.motorph.data.EmployeeRepository;
import com.motorph.model.Employee;
import com.motorph.ui.EmployeeProfile;
import com.motorph.ui.Login;

public class SearchResultsFrame extends EmployeeProfile {

    private static final long serialVersionUID = 1L;

    public SearchResultsFrame(Employee employee) {
        super(employee.getEmployeeId(), null);
    }

    public SearchResultsFrame(String[] employeeDetails) {
        super(employeeId(employeeDetails), null);
    }

    private static String employeeId(String[] employeeDetails) {
        if (employeeDetails == null || employeeDetails.length != EmployeeRepository.FIELD_COUNT) {
            throw new IllegalArgumentException("A complete employee record is required.");
        }
        return employeeDetails[0];
    }

    public static void main(String[] args) {
        Login.main(args);
    }
}
