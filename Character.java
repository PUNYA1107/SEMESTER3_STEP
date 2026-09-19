class Character {
    private final int maxHealth;
    private int currentHealth;

    // Fixed maximum health set at object creation
    public Character(int maxHealth) {
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    // Reduces health, floored at 0
    public void takeDamage(int amount) {
        if (amount > 0) {
            currentHealth = Math.max(0, currentHealth - amount);
            System.out.println("takeDamage(" + amount + ") -> health = " + currentHealth + (currentHealth == 0 ? " (floored)" : ""));
        }
    }

    // Increases health, capped at maxHealth
    public void heal(int amount) {
        if (amount > 0) {
            currentHealth = Math.min(maxHealth, currentHealth + amount);
            System.out.println("heal(" + amount + ") -> health = " + currentHealth + (currentHealth == maxHealth ? " (capped)" : ""));
        }
    }

    public static void main(String[] args) {
        Character c = new Character(100);
        c.takeDamage(30);
        c.heal(50);
        c.takeDamage(150);
    }
}