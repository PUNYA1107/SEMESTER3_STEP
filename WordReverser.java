public class WordReverser {
    public static void main(String[] args) {
        String word = "level";
        String rev = new StringBuilder(word).reverse().toString();
        
        if (word.equals(rev)) {
            System.out.println(word + " - palindrome");
        } else {
            System.out.println(word + " - not a palindrome");
        }
    }
}