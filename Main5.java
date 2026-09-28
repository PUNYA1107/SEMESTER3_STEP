import java.util.*;

abstract class Transport {
    protected double d;
    public Transport(double d) { this.d = d; }
    public abstract String getType();
    public abstract double getFare();
}

class BusTransport extends Transport {
    public BusTransport(double d) { super(d); }
    public String getType() { return "BUS"; }
    public double getFare() { return Math.min(2.0 + 0.10 * d, 10.0); }
}

class TrainTransport extends Transport {
    public TrainTransport(double d) { super(d); }
    public String getType() { return "TRAIN"; }
    public double getFare() { return 3.0 + 0.15 * d; }
}

class MetroTransport extends Transport {
    private double pf;
    public MetroTransport(double d, double pf) { super(d); this.pf = pf; }
    public String getType() { return "METRO"; }
    public double getFare() { return (1.50 + 0.20 * d) * pf; }
}

public class Main5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Transport> list = new ArrayList<>();
        while (n-- > 0) {
            String t = sc.next(); double d = sc.nextDouble();
            if (t.equals("BUS")) list.add(new BusTransport(d));
            else if (t.equals("TRAIN")) list.add(new TrainTransport(d));
            else if (t.equals("METRO")) list.add(new MetroTransport(d, sc.nextDouble()));
        }
        double total = 0;
        for (Transport tr : list) {
            double f = tr.getFare(); total += f;
            System.out.printf("%s: %.2f%n", tr.getType(), f);
        }
        System.out.printf("Total: %.2f%n", total);
    }
}