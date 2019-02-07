package factoryPattern;

public class FactoryMethodTest {

	public static void main(String[] args) {
		EnemyShip ship = EnemyFactory.makeShip('S');
		doStuff(ship);
		
	}
	
	public static void doStuff(EnemyShip ship) {
		ship.show();
	}
}

