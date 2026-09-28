import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Base class
abstract class LibraryItem {
    protected String title;
    protected static final LocalDate CURRENT_DATE = LocalDate.of(2023, 10, 26);

    public LibraryItem(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    // Polymorphic method to calculate due date
    public abstract LocalDate calculateDueDate();
}

// Derived Class 1: Book
class Book extends LibraryItem {
    public Book(String title) {
        super(title);
    }

    @Override
    public LocalDate calculateDueDate() {
        return CURRENT_DATE.plusDays(14);
    }
}

// Derived Class 2: DVD
class DVD extends LibraryItem {
    public DVD(String title) {
        super(title);
    }

    @Override
    public LocalDate calculateDueDate() {
        return CURRENT_DATE.plusDays(7);
    }
}

// Derived Class 3: Magazine
class Magazine extends LibraryItem {
    public Magazine(String title) {
        super(title);
    }

    @Override
    public LocalDate calculateDueDate() {
        return CURRENT_DATE.plusDays(3);
    }
}

public class Solution2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;

        int n = Integer.parseInt(scanner.nextLine().trim());
        List<LibraryItem> items = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // Regex to parse: ItemType "ItemTitle"
        Pattern pattern = Pattern.compile("^(\\S+)\\s+\"(.*)\"$");

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine().trim();
            Matcher matcher = pattern.matcher(line);
            if (matcher.find()) {
                String type = matcher.group(1);
                String title = matcher.group(2);

                switch (type) {
                    case "BOOK":
                        items.add(new Book(title));
                        break;
                    case "DVD":
                        items.add(new DVD(title));
                        break;
                    case "MAGAZINE":
                        items.add(new Magazine(title));
                        break;
                }
            }
        }

        // Processing items uniformly
        for (LibraryItem item : items) {
            LocalDate dueDate = item.calculateDueDate();
            System.out.println(item.getTitle() + ": " + dueDate.format(formatter));
        }

        scanner.close();
    }
}