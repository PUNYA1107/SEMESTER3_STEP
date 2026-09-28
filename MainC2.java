import java.util.*;

abstract class Vehicle {
    protected int hrs;
    public Vehicle(int hrs) { this.hrs = hrs; }
    public abstract String getType();
    public abstract double getCharge();
}

class Bike extends Vehicle {
    public Bike(int hrs) { super(hrs); }
    public String getType() { return "BIKE"; }
    public double getCharge() { return hrs * 10.0; }
}

class Car extends Vehicle {
    public Car(int hrs) { super(hrs); }
    public String getType() { return "CAR"; }
    public double getCharge() { return hrs <= 1 ? 30.0 : 30.0 + (hrs - 1) * 20.0; }
}

class Truck extends Vehicle {
    public Truck(int hrs) { super(hrs); }
    public String getType() { return "TRUCK"; }
    public double getCharge() { return Math.max(hrs * 50.0, 100.0); }
}

public class MainC2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Vehicle> list = new ArrayList<>();
        while (n-- > 0) {
            String t = sc.next(); int h = sc.nextInt();
            if (t.equals("BIKE")) list.add(new Bike(h));
            else if (t.equals("CAR")) list.add(new Car(h));
            else if (t.equals("TRUCK")) list.add(new Truck(h));
        }
        double total = 0;
        for (Vehicle v : list) {
            double c = v.getCharge(); total += c;
            System.out.printf("%s: %.2f%n", v.getType(), c);
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
