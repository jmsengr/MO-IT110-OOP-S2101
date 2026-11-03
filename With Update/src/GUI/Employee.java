package GUI;

public class Employee {

    private String employeeID;
    private String lastName;
    private String firstName;
    private String birthday;
    private String address;
    private String phone;
    private String sss;
    private String philhealth;
    private String tin;
    private String pagibig;
    private String status;
    private String position;
    private String supervisor;
    private double salary;
    private double riceSubsidy;
    private double phoneAllowance;
    private double clothingAllowance;
    private double grossRate;
    private double hourlyRate;

    public Employee(String employeeID, String lastName, String firstName, String birthday, String address, String phone, String sss, String philhealth, String tin, String pagibig, String status, String position, String supervisor, double salary, double riceSubsidy, double phoneAllowance, double clothingAllowance, double grossRate, double hourlyRate) {
        this.employeeID = employeeID;
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthday = birthday;
        this.address = address;
        this.phone = phone;
        this.sss = sss;
        this.philhealth = philhealth;
        this.tin = tin;
        this.pagibig = pagibig;
        this.status = status;
        this.position = position;
        this.supervisor = supervisor;
        this.salary = salary;
        this.riceSubsidy = riceSubsidy;
        this.phoneAllowance = phoneAllowance;
        this.clothingAllowance = clothingAllowance;
        this.grossRate = grossRate;
        this.hourlyRate = hourlyRate;
    }

    public String getEmployeeID() {
        return employeeID;
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

    public String getPhone() {
        return phone;
    }

    public String getSss() {
        return sss;
    }

    public String getPhilhealth() {
        return philhealth;
    }

    public String getTin() {
        return tin;
    }

    public String getPagibig() {
        return pagibig;
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

    public double getSalary() {
        return salary;
    }

    public double getRiceSubsidy() {
        return riceSubsidy;
    }

    public double getPhoneAllowance() {
        return phoneAllowance;
    }

    public double getClothingAllowance() {
        return clothingAllowance;
    }

    public double getGrossRate() {
        return grossRate;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }
}