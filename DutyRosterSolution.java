import java.util.Arrays;

public class DutyRosterSolution {
    
    public static String[] rotateRoster(String[] names, int k) {
        int n = names.length;
        // Use k % n to remove full turns
        int effectiveK = k % n;
        String[] rotated = new String[n];
        
        for (int i = 0; i < n; i++) {
            int newIndex = (i + effectiveK) % n;
            rotated[newIndex] = names[i];
        }
        
        return rotated;
    }

    public static void main(String[] args) {
        String[] names = {"A", "B", "C", "D", "E"};
        int k = 2;
        String[] result = rotateRoster(names, k);
        System.out.println(Arrays.toString(result)); // Expected: [D, E, A, B, C]
    }
}
