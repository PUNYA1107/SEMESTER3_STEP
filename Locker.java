class Locker {
    private final int lockerNumber;
    private String code; // Private with no getter

    public Locker(int lockerNumber, String initialCode) {
        this.lockerNumber = lockerNumber;
        this.code = initialCode;
    }

    public int getLockerNumber() {
        return lockerNumber;
    }

    // Verification required to update code
    public boolean changeCode(String currentCode, String newCode) {
        if (this.code.equals(currentCode)) {
            this.code = newCode;
            System.out.println("changeCode -> success");
            return true;
        } else {
            System.out.println("changeCode -> rejected, code remains unchanged");
            return false;
        }
    }

    public static void main(String[] args) {
        Locker l = new Locker(101, "1234");
        l.changeCode("1234", "5678");
        l.changeCode("0000", "9999");
    }
}
