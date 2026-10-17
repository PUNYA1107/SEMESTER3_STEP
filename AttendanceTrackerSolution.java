public class AttendanceTrackerSolution {
    
    // Function that returns an array containing {total_present_days, longest_streak}
    public static int[] attendanceSummary(int[] days) {
        int totalPresent = 0;
        int currentStreak = 0;
        int longestStreak = 0;
        
        for (int day : days) {
            if (day == 1) {
                totalPresent++;
                currentStreak++;
                if (currentStreak > longestStreak) {
                    longestStreak = currentStreak;
                }
            } else {
                currentStreak = 0; // Reset streak on absence (0)
            }
        }
        
        return new int[] { totalPresent, longestStreak };
    }

    public static void main(String[] args) {
        // Sample 1
        int[] days1 = {1, 1, 0, 1, 1, 1, 0, 1};
        int[] result1 = attendanceSummary(days1);
        System.out.println("Sample 1 Output: Present: " + result1[0] + ", Longest streak: " + result1[1]); // Expected: Present: 6, Longest streak: 3

        // Sample 2
        int[] days2 = {0, 0, 0};
        int[] result2 = attendanceSummary(days2);
        System.out.println("Sample 2 Output: Present: " + result2[0] + ", Longest streak: " + result2[1]); // Expected: Present: 0, Longest streak: 0
    }
}