import java.util.*;

abstract class Delivery {
    protected double w, d;
    public Delivery(double w, double d) { this.w = w; this.d = d; }
    public abstract String getType();
    public abstract double calculateFee();
}

class StandardDelivery extends Delivery {
    public StandardDelivery(double w, double d) { super(w, d); }
    public String getType() { return "STANDARD"; }
    public double calculateFee() { return 5 + 0.5 * w + 0.1 * d; }
}

class ExpressDelivery extends Delivery {
    public ExpressDelivery(double w, double d) { super(w, d); }
    public String getType() { return "EXPRESS"; }
    public double calculateFee() { return 15 + 1.0 * w + 0.2 * d; }
}

class InternationalDelivery extends Delivery {
    private double c;
    public InternationalDelivery(double w, double d, double c) { super(w, d); this.c = c; }
    public String getType() { return "INTERNATIONAL"; }
    public double calculateFee() { return 25 + 2.0 * w + 0.5 * d + c; }
}

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Delivery> list = new ArrayList<>();
        while (n-- > 0) {
            String t = sc.next(); double w = sc.nextDouble(), d = sc.nextDouble();
            if (t.equals("STANDARD")) list.add(new StandardDelivery(w, d));
            else if (t.equals("EXPRESS")) list.add(new ExpressDelivery(w, d));
            else if (t.equals("INTERNATIONAL")) list.add(new InternationalDelivery(w, d, sc.nextDouble()));
        }
        double total = 0;
        for (Delivery del : list) {
            double fee = del.calculateFee();
            total += fee;
            System.out.printf("%s: %.2f%n", del.getType(), fee);
        }
        System.out.printf("Total: %.2f%n", total);
    }
}