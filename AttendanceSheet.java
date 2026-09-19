class AttendanceSheet {
    private final String[] presentStudents;
    private int count;

    public AttendanceSheet(int maxStudents) {
        this.presentStudents = new String[maxStudents];
        this.count = 0;
    }

    // Checks presence before adding to avoid duplicates
    public void markPresent(String name) {
        if (isPresent(name)) {
            return; // Duplicate ignored
        }
        if (count < presentStudents.length) {
            presentStudents[count] = name;
            count++;
        }
    }

    // Checks if name exists internally
    public boolean isPresent(String name) {
        for (int i = 0; i < count; i++) {
            if (presentStudents[i].equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    public int getPresentCount() {
        return count;
    }

    public static void main(String[] args) {
        AttendanceSheet sheet = new AttendanceSheet(30);
        sheet.markPresent("Ana");
        sheet.markPresent("Ben");
        sheet.markPresent("Ana"); // Duplicate, ignored

        System.out.println("sheet.getPresentCount() -> " + sheet.getPresentCount());
        System.out.println("sheet.isPresent(\"Ben\") -> " + sheet.isPresent("Ben"));
        System.out.println("sheet.isPresent(\"Chen\") -> " + sheet.isPresent("Chen"));
    }
}
