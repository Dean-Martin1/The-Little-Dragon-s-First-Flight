class GameCharacter {

    // Public
    public String name;

    // Private
    private int health = 100;

    // Protected
    protected int energy = 50;

    int score = 0;

    public GameCharacter(String name) {
        this.name = name;
    }

    // Public method
    public void showStatus() {
        System.out.println("Name: " + name);
        System.out.println("Health: " + health);
        System.out.println("Energy: " + energy);
        System.out.println("Score: " + score);
    }

    // Private method
    private void restoreHealth() {
        health = 100;
    }

    // Protected method
    protected void fly() {

        // Check whether Ember has enough energy
        if (energy < 10) {

            // Throw an exception when energy is too low
            throw new IllegalStateException(
                name + " does not have enough energy to fly."
            );
        }

        energy = energy - 10;
        score++;

        System.out.println(name + " flies to the next path.");
    }
    
    // Default access method.
    void collectItem() {
        score = score + 5;

        System.out.println(name + " collects an item.");
    }

    public void rest() {
        restoreHealth();
        System.out.println(name + " rests.");
    }
}

// Ember is a subclass of GameCharacter
class Ember extends GameCharacter {

    public Ember() {
        super("Ember");
    }

    public void travel() {
        fly();
        collectItem();
    }
}

public class AccessModifierDemo {

    public static void main(String[] args) {

    	Ember ember = new Ember();

        System.out.println("The Little Dragon's First Flight");
        System.out.println("--------------------------------");

        ember.showStatus();

        try {

            // Attempt six flights
            // Ember only has enough energy for five
            for (int i = 1; i <= 6; i++) {

                System.out.println("Flight attempt: " + i);
                ember.travel();
            }

        } catch (IllegalStateException e) {

            // Handle the exception safely
            System.out.println("Error: " + e.getMessage());

        } finally {

            // Always executes
            ember.rest();

            System.out.println("Final status:");
            ember.showStatus();
        }
    }
}
