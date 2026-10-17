public class DigitProcessor {
    public static void main(String[] args) {
        int num = 4721;
        int sum = 0, rev = 0, temp = num;
        
        while (temp > 0) {
            int digit = temp % 10;
            sum += digit;
            rev = rev * 10 + digit;
            temp /= 10;
        }
        
        System.out.println("Sum of digits: " + sum);
        System.out.println("Reverse: " + rev);
    }
}