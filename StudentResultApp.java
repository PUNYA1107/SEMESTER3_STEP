class StudentRecord {
    String name;
    int[] marks;
    
    public StudentRecord(String name, int[] marks) {
        this.name = name;
        this.marks = marks;
    }
    
    public void printResult() {
        double avg = (marks[0] + marks[1] + marks[2]) / 3.0;
        char grade;
        
        if (avg >= 75) {
            grade = 'B';
        } else if (avg >= 40) {
            grade = 'D';
        } else {
            grade = 'C';
        }
        
        System.out.printf("%s: Average %.1f, Grade %c\n", name.toUpperCase(), avg, grade);
    }
}

public class StudentResultApp {
    public static void main(String[] args) {
        StudentRecord s1 = new StudentRecord("Asha", new int[]{80, 90, 70});
        StudentRecord s2 = new StudentRecord("Ravi", new int[]{60, 55, 50});
        
        s1.printResult();
        s2.printResult();
    }
}