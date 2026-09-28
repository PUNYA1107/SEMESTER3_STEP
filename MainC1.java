import java.util.*;

abstract class Bill {
    protected double amt;
    public Bill(double amt) { this.amt = amt; }
    public abstract String getType();
    public abstract double getFinalAmt();
}

class StudentBill extends Bill {
    public StudentBill(double amt) { super(amt); }
    public String getType() { return "STUDENT"; }
    public double getFinalAmt() { return amt * 0.90; }
}

class StaffBill extends Bill {
    public StaffBill(double amt) { super(amt); }
    public String getType() { return "STAFF"; }
    public double getFinalAmt() { return amt * 0.95; }
}

class GuestBill extends Bill {
    public GuestBill(double amt) { super(amt); }
    public String getType() { return "GUEST"; }
    public double getFinalAmt() { return amt + 10.0; }
}

public class MainC1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Bill> list = new ArrayList<>();
        while (n-- > 0) {
            String t = sc.next(); double a = sc.nextDouble();
            if (t.equals("STUDENT")) list.add(new StudentBill(a));
            else if (t.equals("STAFF")) list.add(new StaffBill(a));
            else if (t.equals("GUEST")) list.add(new GuestBill(a));
        }
        double total = 0;
        for (Bill b : list) {
            double fa = b.getFinalAmt(); total += fa;
            System.out.printf("%s: %.2f%n", b.getType(), fa);
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
