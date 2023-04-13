package zookeeper;

public class Mammals {
	protected int energyLevel = 100;
	public int checkEnergy() {
		System.out.println("Current Energy Level: " + energyLevel + "/100");
		return energyLevel;
	}
	
}
