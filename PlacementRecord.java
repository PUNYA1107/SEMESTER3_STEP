class PlacementRecord {
    String studentName;
    String company;
    double packageLpa;

    // Constructor to initialize all fields
    public PlacementRecord(String studentName, String company, double packageLpa) {
        this.studentName = studentName;
        this.company = company;
        this.packageLpa = packageLpa;
    }

    // Method to print formatted record line
    public void printRecord() {
        System.out.println(studentName + " -> " + company + " @ " + packageLpa + " LPA");
    }

    public static void main(String[] args) {
        // Creating an array of PlacementRecord objects
        PlacementRecord[] records = new PlacementRecord[3];
        records[0] = new PlacementRecord("Ravi", "TCS", 4.5);
        records[1] = new PlacementRecord("Anitha", "Zoho", 6.2);
        records[2] = new PlacementRecord("Karthik", "Infosys", 4.0);

        // Printing each record using a loop
        for (PlacementRecord record : records) {
            record.printRecord();
        }
    }
}