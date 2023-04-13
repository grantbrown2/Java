package zookeeper;

public class Gorilla extends Mammals {
	private int energy = checkEnergy();
	public int getEnergy() { // using getters and setters if the variable is private
		return energy;
	}
	public void setEnergy(int energy) {
		this.energy = energy;
	}
	
	public void throwSomething() {
		if (getEnergy() > 4) { 
			System.out.println("A gorilla has thrown an object at someone!");
			setEnergy(getEnergy() - 5);
			System.out.println("Energy Level After Event: " + getEnergy() + "/100");
		} else {
			System.out.println("Gorilla does not have enough energy for this action!");	
		}
	}
	public void eatBananas() {
		if (getEnergy() >= 91) {
			System.out.println("Gorilla is too full!");
		} else {
			setEnergy(getEnergy() + 10);
			System.out.println("A gorilla has eaten a banana.");
			System.out.println("Energy Level After Event: " + getEnergy() + "/100");
		}
	}
	public void climb() {
		if (getEnergy() > 9) {
			setEnergy(getEnergy() - 10);
			System.out.println("A gorilla is climbing a tree!");
			System.out.println("Energy Level After Event: " + getEnergy() + "/100");
		} else {
			System.out.println("Gorilla does not have enough energy for this action!");
		}
	}
}
