import java.util.Arrays;
import java.util.List;

public class EvenOddCounter {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(3, 8, 12, 5, 7, 10);
        int evenCount = 0, oddCount = 0;
        
        for (int n : list) {
            if (n % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }
        
        System.out.println("Even: " + evenCount);
        System.out.println("Odd: " + oddCount);
    }
}