public class ExamBandSolution {

    // Find the first index where score >= target
    private static int findLowerBound(int[] scores, int target) {
        int low = 0, high = scores.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (scores[mid] >= target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    // Find the first index where score > target
    private static int findUpperBound(int[] scores, int target) {
        int low = 0, high = scores.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (scores[mid] > target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static int countInBand(int[] scores, int low, int high) {
        int startIndex = findLowerBound(scores, low);
        int endIndex = findUpperBound(scores, high);
        return endIndex - startIndex;
    }

    public static void main(String[] args) {
        int[] scores = {35, 42, 42, 50, 58, 58, 58, 63, 71, 88};
        System.out.println(countInBand(scores, 42, 58)); // Expected Output: 6
        System.out.println(countInBand(scores, 90, 100)); // Expected Output: 0
    }
}