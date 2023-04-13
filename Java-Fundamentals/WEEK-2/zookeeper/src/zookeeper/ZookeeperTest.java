package zookeeper;

public class ZookeeperTest {

	public static void main(String[] args) {
		Gorilla gorilla = new Gorilla();
		gorilla.throwSomething();
		gorilla.throwSomething();
		gorilla.throwSomething();
		gorilla.eatBananas();
		gorilla.eatBananas();
		gorilla.climb();
		System.out.println("=====================================================================");
		MonsterBat bat = new MonsterBat();
		bat.attackTown();
		bat.attackTown();
		bat.attackTown();
		bat.eatHuman();
		bat.eatHuman();
		bat.fly();
		bat.fly();
	}

}
