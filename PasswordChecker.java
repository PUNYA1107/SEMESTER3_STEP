class PasswordChecker {
    private final String password; // Read-only, private, no getter

    public PasswordChecker(String password) {
        this.password = password;
    }

    // Returns strength label based on length evaluation
    public String getStrength() {
        int length = password.length();
        if (length < 6) {
            return "Weak";
        } else if (length <= 9) {
            return "Medium";
        } else {
            return "Strong";
        }
    }

    public static void main(String[] args) {
        PasswordChecker pc1 = new PasswordChecker("abcd");
        System.out.println("pc1.getStrength() -> " + pc1.getStrength());

        PasswordChecker pc2 = new PasswordChecker("abcdefghij");
        System.out.println("pc2.getStrength() -> " + pc2.getStrength());
    }
}