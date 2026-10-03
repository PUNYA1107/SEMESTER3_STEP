import java.util.Scanner;

// Interface for Saver Mode capability
interface SaverModeSupported {
}

abstract class Appliance {
    protected double hours;

    public Appliance(double hours) {
        this.hours = hours;
    }

    public abstract String getName();
    public abstract double getPowerWatts();

    public boolean supportsSaverMode() {
        return this instanceof SaverModeSupported;
    }

    public double calculateUnits(boolean isSaverMode) {
        double units = (getPowerWatts() * hours) / 1000.0;
        if (isSaverMode && supportsSaverMode()) {
            units *= 0.75; // 25% energy reduction
        }
        return units;
    }

    public double calculateCost(double units) {
        return units * 8.00;
    }
}

class Fridge extends Appliance {
    public Fridge(double hours) { super(hours); }

    @Override
    public String getName() { return "FRIDGE"; }

    @Override
    public double getPowerWatts() { return 150.0; }
}

class AirConditioner extends Appliance implements SaverModeSupported {
    public AirConditioner(double hours) { super(hours); }

    @Override
    public String getName() { return "AC"; }

    @Override
    public double getPowerWatts() { return 1500.0; }
}

class TV extends Appliance {
    public TV(double hours) { super(hours); }

    @Override
    public String getName() { return "TV"; }

    @Override
    public double getPowerWatts() { return 100.0; }
}

class WashingMachine extends Appliance implements SaverModeSupported {
    public WashingMachine(double hours) { super(hours); }

    @Override
    public String getName() { return "WASHER"; }

    @Override
    public double getPowerWatts() { return 500.0; }
}

public class HomeApplianceEnergyReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;

        int n = Integer.parseInt(sc.nextLine().trim());
        double totalCost = 0.0;

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) continue;

            String[] parts = line.split("\\s+");
            String applianceType = parts[0];
            double hours = Double.parseDouble(parts[1]);
            boolean isSaverRequested = parts.length > 2 && parts[2].equalsIgnoreCase("SAVER");

            Appliance appliance = null;
            if (applianceType.equalsIgnoreCase("FRIDGE")) {
                appliance = new Fridge(hours);
            } else if (applianceType.equalsIgnoreCase("AC")) {
                appliance = new AirConditioner(hours);
            } else if (applianceType.equalsIgnoreCase("TV")) {
                appliance = new TV(hours);
            } else if (applianceType.equalsIgnoreCase("WASHER")) {
                appliance = new WashingMachine(hours);
            }

            if (appliance != null) {
                if (isSaverRequested && !appliance.supportsSaverMode()) {
                    System.out.printf("%s: saver mode not supported%n", appliance.getName());
                } else {
                    double units = appliance.calculateUnits(isSaverRequested);
                    double cost = appliance.calculateCost(units);
                    totalCost += cost;
                    System.out.printf("%s: Units=%.2f Cost=%.2f%n", appliance.getName(), units, cost);
                }
            }
        }

        System.out.printf("Total Cost: %.2f%n", totalCost);
        sc.close();
    }
}