public class GradeAssigner {
    public static void main(String[] args) {
        printGrade(72);
        printGrade(95);
        printGrade(35);
    }
    
    public static void printGrade(int marks) {
        char grade;
        if (marks >= 90) {
            grade = 'A';
        } else if (marks >= 75) {
            grade = 'B';
        } else if (marks >= 60) {
            grade = 'C';
        } else if (marks >= 40) {
            grade = 'D';
        } else {
            grade = 'F';
        }
        System.out.println("Grade " + grade);
    }
}