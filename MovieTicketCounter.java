import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Abstract class ensures a generic "Ticket" cannot be instantiated directly
abstract class Ticket {
    // Shared constant fee written in one place only
    protected static final double CONVENIENCE_FEE = 20.00;
    protected int count;

    public Ticket(int count) {
        this.count = count;
    }

    public abstract String getSeatType();
    public abstract double getPricePerTicket();

    // Shared calculation logic
    public double calculateTotalAmount() {
        return (getPricePerTicket() + CONVENIENCE_FEE) * count;
    }
}

class RegularTicket extends Ticket {
    public RegularTicket(int count) {
        super(count);
    }

    @Override
    public String getSeatType() {
        return "REGULAR";
    }

    @Override
    public double getPricePerTicket() {
        return 150.00;
    }
}

class PremiumTicket extends Ticket {
    public PremiumTicket(int count) {
        super(count);
    }

    @Override
    public String getSeatType() {
        return "PREMIUM";
    }

    @Override
    public double getPricePerTicket() {
        return 250.00;
    }
}

class ReclinerTicket extends Ticket {
    public ReclinerTicket(int count) {
        super(count);
    }

    @Override
    public String getSeatType() {
        return "RECLINER";
    }

    @Override
    public double getPricePerTicket() {
        return 400.00;
    }
}

public class MovieTicketCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;

        int n = sc.nextInt();
        List<Ticket> bookings = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String seat = sc.next();
            int count = sc.nextInt();

            if (seat.equalsIgnoreCase("REGULAR")) {
                bookings.add(new RegularTicket(count));
            } else if (seat.equalsIgnoreCase("PREMIUM")) {
                bookings.add(new PremiumTicket(count));
            } else if (seat.equalsIgnoreCase("RECLINER")) {
                bookings.add(new ReclinerTicket(count));
            }
        }

        double totalCollected = 0.0;
        for (Ticket ticket : bookings) {
            double amount = ticket.calculateTotalAmount();
            totalCollected += amount;
            System.out.printf("%s: %.2f%n", ticket.getSeatType(), amount);
        }

        System.out.printf("Total: %.2f%n", totalCollected);
        sc.close();
    }
}