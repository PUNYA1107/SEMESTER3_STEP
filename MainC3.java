import java.util.*;

abstract class Room {
    protected int u;
    public Room(int u) { this.u = u; }
    public abstract String getType();
    public abstract double getBill();
}

class SingleRoom extends Room {
    public SingleRoom(int u) { super(u); }
    public String getType() { return "SINGLE"; }
    public double getBill() { return u * 8.0; }
}

class SharedRoom extends Room {
    private int occ;
    public SharedRoom(int u, int occ) { super(u); this.occ = occ; }
    public String getType() { return "SHARED"; }
    public double getBill() { return (u * 6.0) / occ; }
}

class ACRoom extends Room {
    public ACRoom(int u) { super(u); }
    public String getType() { return "AC"; }
    public double getBill() { return u * 10.0 + 200.0; }
}

public class MainC3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Room> list = new ArrayList<>();
        while (n-- > 0) {
            String t = sc.next(); int u = sc.nextInt();
            if (t.equals("SINGLE")) list.add(new SingleRoom(u));
            else if (t.equals("SHARED")) list.add(new SharedRoom(u, sc.nextInt()));
            else if (t.equals("AC")) list.add(new ACRoom(u));
        }
        double total = 0;
        for (Room r : list) {
            double b = r.getBill(); total += b;
            System.out.printf("%s: %.2f%n", r.getType(), b);
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
