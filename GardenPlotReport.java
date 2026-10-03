import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Abstract Base Class
abstract class Plot {
    protected String owner;

    public Plot(String owner) {
        this.owner = owner;
    }

    public String getOwner() {
        return owner;
    }

    public abstract String getShapeName();
    public abstract double calculateArea();
}

// Circle Subclass
class CirclePlot extends Plot {
    private double radius;

    public CirclePlot(String owner, double radius) {
        super(owner);
        this.radius = radius;
    }

    @Override
    public String getShapeName() {
        return "CIRCLE";
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

// Rectangle Subclass
class RectanglePlot extends Plot {
    private double length;
    private double width;

    public RectanglePlot(String owner, double length, double width) {
        super(owner);
        this.length = length;
        this.width = width;
    }

    @Override
    public String getShapeName() {
        return "RECTANGLE";
    }

    @Override
    public double calculateArea() {
        return length * width;
    }
}

// Triangle Subclass
class TrianglePlot extends Plot {
    private double base;
    private double height;

    public TrianglePlot(String owner, double base, double height) {
        super(owner);
        this.base = base;
        this.height = height;
    }

    @Override
    public String getShapeName() {
        return "TRIANGLE";
    }

    @Override
    public double calculateArea() {
        return 0.5 * base * height;
    }
}

public class GardenPlotReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;

        int n = sc.nextInt();
        List<Plot> plots = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String shape = sc.next();
            String owner = sc.next();

            if (shape.equalsIgnoreCase("CIRCLE")) {
                double radius = sc.nextDouble();
                plots.add(new CirclePlot(owner, radius));
            } else if (shape.equalsIgnoreCase("RECTANGLE")) {
                double length = sc.nextDouble();
                double width = sc.nextDouble();
                plots.add(new RectanglePlot(owner, length, width));
            } else if (shape.equalsIgnoreCase("TRIANGLE")) {
                double base = sc.nextDouble();
                double height = sc.nextDouble();
                plots.add(new TrianglePlot(owner, base, height));
            }
        }

        double totalArea = 0;
        for (Plot plot : plots) {
            double area = plot.calculateArea();
            totalArea += area;
            System.out.printf("%s (%s): %.2f%n", plot.getOwner(), plot.getShapeName(), area);
        }

        System.out.printf("Total Area: %.2f%n", totalArea);
        sc.close();
    }
}