import java.util.*;

abstract class Question {
    protected String ca, sa; double pts;
    public Question(String ca, String sa, double pts) { this.ca = ca; this.sa = sa; this.pts = pts; }
    public abstract String getType();
    public abstract double getScore();
}

class MCQQuestion extends Question {
    public MCQQuestion(String ca, String sa, double pts) { super(ca, sa, pts); }
    public String getType() { return "MCQ"; }
    public double getScore() { return sa.equalsIgnoreCase(ca) ? pts : 0; }
}

class TFQuestion extends Question {
    public TFQuestion(String ca, String sa, double pts) { super(ca, sa, pts); }
    public String getType() { return "TF"; }
    public double getScore() { return sa.equalsIgnoreCase(ca) ? pts : 0; }
}

class EssayQuestion extends Question {
    public EssayQuestion(String ca, String sa, double pts) { super(ca, sa, pts); }
    public String getType() { return "ESSAY"; }
    public double getScore() {
        int m = 0;
        for (String k : ca.split(",")) if (sa.toLowerCase().contains(k.trim().toLowerCase())) m++;
        return m >= 2 ? pts * 0.75 : (m == 1 ? pts * 0.5 : 0);
    }
}

public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        List<Question> list = new ArrayList<>();
        while (n-- > 0) {
            String line = sc.nextLine().trim();
            List<String> parts = new ArrayList<>();
            int i = 0;
            while (i < line.length()) {
                if (line.charAt(i) == '"') {
                    int j = line.indexOf('"', i + 1);
                    parts.add(line.substring(i + 1, j)); i = j + 2;
                } else if (line.charAt(i) != ' ') {
                    int j = line.indexOf(' ', i); if (j == -1) j = line.length();
                    parts.add(line.substring(i, j)); i = j + 1;
                } else i++;
            }
            String t = parts.get(0), ca = parts.get(2), sa = parts.get(3);
            double pts = Double.parseDouble(parts.get(4));
            if (t.equals("MCQ")) list.add(new MCQQuestion(ca, sa, pts));
            else if (t.equals("TF")) list.add(new TFQuestion(ca, sa, pts));
            else if (t.equals("ESSAY")) list.add(new EssayQuestion(ca, sa, pts));
        }
        double total = 0;
        for (Question q : list) {
            double s = q.getScore(); total += s;
            System.out.printf("%s: %.2f%n", q.getType(), s);
        }
        System.out.printf("Total Score: %.2f%n", total);
    }
}
