import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Base class
abstract class Payment {
    protected double amount;

    public Payment(double amount) {
        this.amount = amount;
    }

    // Polymorphic method to calculate adjusted amount
    public abstract double getAdjustedAmount();
    public abstract String getPaymentType();
}

// Derived Class 1: Card
class CardPayment extends Payment {
    public CardPayment(double amount) {
        super(amount);
    }

    @Override
    public double getAdjustedAmount() {
        return amount * 1.02; // 2% fee
    }

    @Override
    public String getPaymentType() {
        return "CARD";
    }
}

// Derived Class 2: Wallet
class WalletPayment extends Payment {
    public WalletPayment(double amount) {
        super(amount);
    }

    @Override
    public double getAdjustedAmount() {
        return amount * 1.01; // 1% fee
    }

    @Override
    public String getPaymentType() {
        return "WALLET";
    }
}

// Derived Class 3: Bank Transfer
class BankTransferPayment extends Payment {
    public BankTransferPayment(double amount) {
        super(amount);
    }

    @Override
    public double getAdjustedAmount() {
        return amount; // 0% fee
    }

    @Override
    public String getPaymentType() {
        return "BANKTRANSFER";
    }
}

public class Solution1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;

        int n = scanner.nextInt();
        List<Payment> payments = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double amount = scanner.nextDouble();

            switch (type) {
                case "CARD":
                    payments.add(new CardPayment(amount));
                    break;
                case "WALLET":
                    payments.add(new WalletPayment(amount));
                    break;
                case "BANKTRANSFER":
                    payments.add(new BankTransferPayment(amount));
                    break;
            }
        }

        double grandTotal = 0.0;
        // Uniform processing using Polymorphism
        for (Payment payment : payments) {
            double adjusted = payment.getAdjustedAmount();
            grandTotal += adjusted;
            System.out.printf("%s: %.2f%n", payment.getPaymentType(), adjusted);
        }

        System.out.printf("Total: %.2f%n", grandTotal);
        scanner.close();
    }
}
