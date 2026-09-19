class Scorecard {
    private final boolean[] answers;
    private int count;

    // Fixed total questions set at creation
    public Scorecard(int totalQuestions) {
        this.answers = new boolean[totalQuestions];
        this.count = 0;
    }

    // Records answer sequentially; rejects extra answers beyond fixed total
    public void recordAnswer(boolean isCorrect) {
        if (count < answers.length) {
            answers[count] = isCorrect;
            count++;
        } else {
            System.out.println("Cannot record: Question limit reached.");
        }
    }

    // Computes total score without exposing raw array
    public int getScore() {
        int score = 0;
        for (int i = 0; i < count; i++) {
            if (answers[i]) {
                score++;
            }
        }
        return score;
    }

    public static void main(String[] args) {
        Scorecard sc = new Scorecard(4);
        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);

        System.out.println("sc.getScore() -> " + sc.getScore());
    }
}