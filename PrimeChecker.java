public class PrimeChecker {
    public static void main(String[] args) {
        checkPrime(29);
        checkPrime(21);
    }
    
    public static void checkPrime(int n) {
        boolean isPrime = n > 1;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                isPrime = false;
                break;
            }
        }
        if (isPrime) {
            System.out.println(n + " is prime");
        } else {
            System.out.println(n + " is not prime");
        }
    }
}