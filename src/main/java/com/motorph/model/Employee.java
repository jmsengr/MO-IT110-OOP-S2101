package com.motorph.model;

public class Employee {

    private final String employeeId;
    private final String lastName;
    private final String firstName;
    private final String birthday;
    private final String address;
    private final String phoneNumber;
    private final String sssNumber;
    private final String philhealthNumber;
    private final String tin;
    private final String pagibigNumber;
    private final String status;
    private final String position;
    private final String supervisor;
    private final String basicSalary;
    private final String riceSubsidy;
    private final String phoneAllowance;
    private final String clothingAllowance;
    private final String grossSemiMonthlyRate;
    private final String hourlyRate;

    public Employee(String employeeId, String lastName, String firstName, String birthday, String address,
                    String phoneNumber, String sssNumber, String philhealthNumber, String tin,
                    String pagibigNumber, String status, String position, String supervisor,
                    String basicSalary, String riceSubsidy, String phoneAllowance, String clothingAllowance,
                    String grossSemiMonthlyRate, String hourlyRate) {
        this.employeeId = employeeId;
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthday = birthday;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.sssNumber = sssNumber;
        this.philhealthNumber = philhealthNumber;
        this.tin = tin;
        this.pagibigNumber = pagibigNumber;
        this.status = status;
        this.position = position;
        this.supervisor = supervisor;
        this.basicSalary = basicSalary;
        this.riceSubsidy = riceSubsidy;
        this.phoneAllowance = phoneAllowance;
        this.clothingAllowance = clothingAllowance;
        this.grossSemiMonthlyRate = grossSemiMonthlyRate;
        this.hourlyRate = hourlyRate;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getSssNumber() {
        return sssNumber;
    }

    public String getPhilhealthNumber() {
        return philhealthNumber;
    }

    public String getTin() {
        return tin;
    }

    public String getPagibigNumber() {
        return pagibigNumber;
    }

    public String getStatus() {
        return status;
    }

    public String getPosition() {
        return position;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public String getBasicSalary() {
        return basicSalary;
    }

    public String getRiceSubsidy() {
        return riceSubsidy;
    }

    public String getPhoneAllowance() {
        return phoneAllowance;
    }

    public String getClothingAllowance() {
        return clothingAllowance;
    }

    public String getGrossSemiMonthlyRate() {
        return grossSemiMonthlyRate;
    }

    public String getHourlyRate() {
        return hourlyRate;
    }
}
