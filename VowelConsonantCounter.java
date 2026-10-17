public class VowelConsonantCounter {
    public static void main(String[] args) {
        String word = "Programming".toLowerCase();
        int vowels = 0, consonants = 0;
        
        for (char ch : word.toCharArray()) {
            if ("aeiou".indexOf(ch) != -1) {
                vowels++;
            } else if (Character.isLetter(ch)) {
                consonants++;
            }
        }
        
        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
    }
}