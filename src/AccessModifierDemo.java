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

    // Protected method.
    protected void fly() {
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

        ember.showStatus();
        ember.travel();
        ember.rest();

        System.out.println("After travelling:");
        ember.showStatus();
    }
}
