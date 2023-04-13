package zookeeper;

public class MonsterBat extends Mammals {
	public MonsterBat() { // I can use this one if the variable is protected
		energyLevel = 300;
	}
	public void fly() {
		if (energyLevel > 49) {
			System.out.println("A huge bat is flying!");
			energyLevel -= 50;
			System.out.println("Energy Level after event: " + energyLevel + "/300");
		} else {
			System.out.println("The bat is too tired to fly!");
		}
	}
	public void eatHuman() {
		if (energyLevel <= 275) {
			System.out.println("The huge bat has eaten a human! - Stay inside!");
			energyLevel += 25;
			System.out.println("Energy Level after event: " + energyLevel + "/300");
		} else {
			System.out.println("The huge bat is too full to eat another person, we should be okay for now.");
		}
	}
	public void attackTown() {
		if (energyLevel >= 100) {
			System.out.println("The huge bat has attacked the town! - Stay inside!");
			energyLevel -= 100;
			System.out.println("Energy Level after event: " + energyLevel + "/300");
		} else {
			System.out.println("The huge bat is too tired to attack the town, we should be okay for now.");
		}
	}
}
