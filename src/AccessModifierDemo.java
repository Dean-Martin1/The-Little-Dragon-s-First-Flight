import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/*
 * Project: The Little Dragon's First Flight
 *
 * This application demonstrates:
 * 1. Java access modifiers
 * 2. Inheritance
 * 3. Exception handling using try, catch and finally
 * 4. Log4j2 logging to the console and a text file
 */

class GameCharacter {

	// Logger records character activities
	private static final Logger logger = LogManager.getLogger(GameCharacter.class);

	// Public
	public String name;

	// Private
	private int health = 100;

	// Protected
	protected int energy = 50;

	int score = 0;

	public GameCharacter(String name) {
		this.name = name;
		logger.info("Character created: " + name);
	}

	// Public method
	public void showStatus() {
		System.out.println("Name: " + name);
		System.out.println("Health: " + health);
		System.out.println("Energy: " + energy);
		System.out.println("Score: " + score);
		logger.info("Status: " + name + ", Health: " + health + ", Energy: " + energy + ", Score: " + score);
	}

	// Private method
	private void restoreHealth() {
		health = 100;
		logger.info(name + "'s health restored to 100");
	}

	// Protected method
	protected void fly() {

		logger.debug(name + " is attempting to fly");

		// Check whether Ember has enough energy
		if (energy < 10) {

			logger.warn(name + " does not have enough energy to fly");

			// Throw an exception when energy is too low
			throw new IllegalStateException(name + " does not have enough energy to fly.");
		}

		energy = energy - 10;
		score++;

		System.out.println(name + " flies to the next path.");

		logger.info(name + " successfully completed a flight");

		logger.debug("Remaining energy: " + energy);
	}

	// Default access method.
	void collectItem() {
		score = score + 5;

		System.out.println(name + " collects an item.");

		logger.info(name + " collected an item");
	}

	public void rest() {
		restoreHealth();
		System.out.println(name + " rests.");
		logger.info(name + " completed resting");
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
	
	private static final Logger logger = LogManager.getLogger(AccessModifierDemo.class);

	public static void main(String[] args) {
		
		logger.info("The Little Dragon application started");

		Ember ember = new Ember();

		System.out.println("The Little Dragon's First Flight");
		System.out.println("--------------------------------");

		ember.showStatus();

		try {

			// Attempt six flights
			// Ember only has enough energy for five
			for (int i = 1; i <= 6; i++) {

				System.out.println("Flight attempt: " + i);
				logger.debug("Starting flight attempt: " + i);
				ember.travel();
			}

		} catch (IllegalStateException e) {

			// Handle the exception safely
			System.out.println("Error: " + e.getMessage());
			logger.error("Flight failed due to low energy", e);

		} finally {

			// Always executes
			logger.info("Executing finally block");
			ember.rest();

			System.out.println("Final status - testing Git revert");
			ember.showStatus();
			logger.info("The Little Dragon application finished");
		}
	}
}
