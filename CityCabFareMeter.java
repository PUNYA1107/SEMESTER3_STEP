import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Interface for Night Service capability
interface NightServiceable {
    default double applyNightSurcharge(double baseFare) {
        return baseFare * 1.20;
    }
}

abstract class Cab {
    protected double km;

    public Cab(double km) {
        this.km = km;
    }

    public abstract String getCabType();
    public abstract double getRatePerKm();

    public double calculateBaseFare() {
        double fare = km * getRatePerKm();
        return Math.max(fare, 100.00); // Minimum fare rule shared in abstract class
    }
}

class MiniCab extends Cab {
    public MiniCab(double km) {
        super(km);
    }

    @Override
    public String getCabType() {
        return "MINI";
    }

    @Override
    public double getRatePerKm() {
        return 10.00;
    }
}

class SedanCab extends Cab implements NightServiceable {
    public SedanCab(double km) {
        super(km);
    }

    @Override
    public String getCabType() {
        return "SEDAN";
    }

    @Override
    public double getRatePerKm() {
        return 14.00;
    }
}

class SUVCab extends Cab implements NightServiceable {
    public SUVCab(double km) {
        super(km);
    }

    @Override
    public String getCabType() {
        return "SUV";
    }

    @Override
    public double getRatePerKm() {
        return 18.00;
    }
}

public class CityCabFareMeter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;

        int n = sc.nextInt();
        double grandTotal = 0.0;

        for (int i = 0; i < n; i++) {
            String cabType = sc.next();
            double km = sc.nextDouble();
            String time = sc.next();

            Cab cab = null;
            if (cabType.equalsIgnoreCase("MINI")) {
                cab = new MiniCab(km);
            } else if (cabType.equalsIgnoreCase("SEDAN")) {
                cab = new SedanCab(km);
            } else if (cabType.equalsIgnoreCase("SUV")) {
                cab = new SUVCab(km);
            }

            if (cab != null) {
                if (time.equalsIgnoreCase("NIGHT")) {
                    if (cab instanceof NightServiceable) {
                        double fare = ((NightServiceable) cab).applyNightSurcharge(cab.calculateBaseFare());
                        grandTotal += fare;
                        System.out.printf("%s: %.2f%n", cab.getCabType(), fare);
                    } else {
                        System.out.printf("%s: night service not available%n", cab.getCabType());
                    }
                } else {
                    double fare = cab.calculateBaseFare();
                    grandTotal += fare;
                    System.out.printf("%s: %.2f%n", cab.getCabType(), fare);
                }
            }
        }

        System.out.printf("Total: %.2f%n", grandTotal);
        sc.close();
    }
}
