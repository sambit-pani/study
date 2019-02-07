package factoryPattern;

public class EnemyFactory {

	public static EnemyShip makeShip(char ship) {
		if(ship == 'U')
			return new UfoEnemyShip();
		else if(ship == 'R') {
			return new RocketEnemyShip();
		}else {
			throw new IllegalArgumentException("Invalid Input");
		}
	}
}
