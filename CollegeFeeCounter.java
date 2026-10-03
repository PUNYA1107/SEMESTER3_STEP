import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Interface for transport service usage
interface UsesTransport {
    default double getTransportFee() {
        return 12000.00; // Transport fee written in one place
    }
}

abstract class Student {
    protected String name;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract double calculateTuition();

    public double calculateTotalFee() {
        double total = calculateTuition();
        if (this instanceof UsesTransport) {
            total += ((UsesTransport) this).getTransportFee();
        }
        return total;
    }
}

class DayScholarStudent extends Student implements UsesTransport {
    public DayScholarStudent(String name) {
        super(name);
    }

    @Override
    public double calculateTuition() {
        return 40000.00;
    }
}

class HostellerStudent extends Student {
    public HostellerStudent(String name) {
        super(name);
    }

    @Override
    public double calculateTuition() {
        return 40000.00 + 60000.00; // Tuition + Hostel fee
    }
}

class ScholarStudent extends Student implements UsesTransport {
    public ScholarStudent(String name) {
        super(name);
    }

    @Override
    public double calculateTuition() {
        return 20000.00; // Half tuition
    }
}

public class CollegeFeeCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;

        int n = sc.nextInt();
        List<Student> students = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();

            if (type.equalsIgnoreCase("DAY_SCHOLAR")) {
                students.add(new DayScholarStudent(name));
            } else if (type.equalsIgnoreCase("HOSTELLER")) {
                students.add(new HostellerStudent(name));
            } else if (type.equalsIgnoreCase("SCHOLAR")) {
                students.add(new ScholarStudent(name));
            }
        }

        double totalCollected = 0.0;
        for (Student student : students) {
            double fee = student.calculateTotalFee();
            totalCollected += fee;
            System.out.printf("%s: %.2f%n", student.getName(), fee);
        }

        System.out.printf("Total Collected: %.2f%n", totalCollected);
        sc.close();
    }
}