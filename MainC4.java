import java.util.*;

abstract class Employee {
    protected String name; protected double sal;
    public Employee(String name, double sal) { this.name = name; this.sal = sal; }
    public String getName() { return name; }
    public abstract double getBonus();
}

class FullTimeEmployee extends Employee {
    public FullTimeEmployee(String n, double s) { super(n, s); }
    public double getBonus() { return sal * 0.10; }
}

class PartTimeEmployee extends Employee {
    public PartTimeEmployee(String n, double s) { super(n, s); }
    public double getBonus() { return sal * 0.05; }
}

class InternEmployee extends Employee {
    public InternEmployee(String n, double s) { super(n, s); }
    public double getBonus() { return 2000.0; }
}

public class MainC4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Employee> list = new ArrayList<>();
        while (n-- > 0) {
            String t = sc.next(), name = sc.next(); double s = sc.nextDouble();
            if (t.equals("FULLTIME")) list.add(new FullTimeEmployee(name, s));
            else if (t.equals("PARTTIME")) list.add(new PartTimeEmployee(name, s));
            else if (t.equals("INTERN")) list.add(new InternEmployee(name, s));
        }
        double total = 0;
        for (Employee e : list) {
            double b = e.getBonus(); total += b;
            System.out.printf("%s: %.2f%n", e.getName(), b);
        }
        System.out.printf("Total Bonus: %.2f%n", total);
    }
}
