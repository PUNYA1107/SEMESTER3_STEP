import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class TravelBooking {
    // Booking fee is defined in one single place
    protected static final double BOOKING_FEE = 50.0;
    protected double distanceKm;

    public TravelBooking(double distanceKm) {
        this.distanceKm = distanceKm;
    }

    public abstract String getMode();
    
    // Abstract method for base fare calculation specific to each travel mode
    public abstract double calculateBaseFare();

    // Final total calculation incorporates the common booking fee
    public double calculateTotalFare() {
        return calculateBaseFare() + BOOKING_FEE;
    }
}

class BusBooking extends TravelBooking {
    public BusBooking(double distanceKm) {
        super(distanceKm);
    }

    @Override
    public String getMode() {
        return "BUS";
    }

    @Override
    public double calculateBaseFare() {
        return distanceKm * 2.0;
    }
}

class TrainBooking extends TravelBooking {
    public TrainBooking(double distanceKm) {
        super(distanceKm);
    }

    @Override
    public String getMode() {
        return "TRAIN";
    }

    @Override
    public double calculateBaseFare() {
        return distanceKm * 1.5;
    }
}

class FlightBooking extends TravelBooking {
    public FlightBooking(double distanceKm) {
        super(distanceKm);
    }

    @Override
    public String getMode() {
        return "FLIGHT";
    }

    @Override
    public double calculateBaseFare() {
        return 2500.0 + (distanceKm * 4.0);
    }
}

public class TravelBookingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;

        int n = sc.nextInt();
        List<TravelBooking> bookings = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String mode = sc.next();
            double distance = sc.nextDouble();

            if (mode.equalsIgnoreCase("BUS")) {
                bookings.add(new BusBooking(distance));
            } else if (mode.equalsIgnoreCase("TRAIN")) {
                bookings.add(new TrainBooking(distance));
            } else if (mode.equalsIgnoreCase("FLIGHT")) {
                bookings.add(new FlightBooking(distance));
            }
        }

        for (TravelBooking booking : bookings) {
            System.out.printf("%s: %.2f%n", booking.getMode(), booking.calculateTotalFare());
        }

        sc.close();
    }
}
