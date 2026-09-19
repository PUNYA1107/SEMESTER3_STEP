class Employee1 {
    private String empName;
    private double salary;
    
    // Shared static variables
    public static String companyName = "Bright Horizon Technologies";
    public static int employeeCount = 0;

    public Employee1(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++; // Increment static counter on every instantiation
    }

    public static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }

    public static void main(String[] args) {
        Employee1 e1 = new Employee1("Aisha", 50000.0);
        Employee1 e2 = new Employee1("Rahul", 60000.0);
        Employee1 e3 = new Employee1("Karan", 55000.0);

        // Call static method directly using class name
        Employee1.printCompanyInfo();
    }
}
