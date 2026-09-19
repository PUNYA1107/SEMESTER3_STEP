class CompanyEmployee {
    private String empName;
    private double salary;
    
    // Shared static variables
    public static String companyName = "Bright Horizon Technologies";
    public static int employeeCount = 0;

    public CompanyEmployee(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++; // Increment static counter on every instantiation
    }

    public static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }

    public static void main(String[] args) {
        CompanyEmployee e1 = new CompanyEmployee("Aisha", 50000.0);
        CompanyEmployee e2 = new CompanyEmployee("Rahul", 60000.0);
        CompanyEmployee e3 = new CompanyEmployee("Karan", 55000.0);

        // Call static method directly using class name
        CompanyEmployee.printCompanyInfo();
    }
}
