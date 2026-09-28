import java.time.LocalDate;
import java.util.*;

abstract class Subscription {
    protected String name; protected LocalDate start;
    public Subscription(String name, LocalDate start) { this.name = name; this.start = start; }
    public String getName() { return name; }
    public abstract LocalDate getRenewalDate();
}

class BasicPlan extends Subscription {
    public BasicPlan(String n, LocalDate s) { super(n, s); }
    public LocalDate getRenewalDate() { return start.plusDays(30); }
}

class StandardPlan extends Subscription {
    public StandardPlan(String n, LocalDate s) { super(n, s); }
    public LocalDate getRenewalDate() { return start.plusDays(90); }
}

class PremiumPlan extends Subscription {
    public PremiumPlan(String n, LocalDate s) { super(n, s); }
    public LocalDate getRenewalDate() { return start.plusDays(365); }
}

public class MainC5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Subscription> list = new ArrayList<>();
        while (n-- > 0) {
            String t = sc.next(), name = sc.next();
            LocalDate date = LocalDate.parse(sc.next());
            if (t.equals("BASIC")) list.add(new BasicPlan(name, date));
            else if (t.equals("STANDARD")) list.add(new StandardPlan(name, date));
            else if (t.equals("PREMIUM")) list.add(new PremiumPlan(name, date));
        }
        for (Subscription sub : list) {
            System.out.println(sub.getName() + ": " + sub.getRenewalDate());
        }
    }
}
