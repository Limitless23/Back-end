package FactoryPattern;

//All the decision making is moved into this class
//this allows reusability and promotes encapsulation
//it also lets you modify things in one place
public class EnemyShipFactory {
	
	public EnemyShip makeEnemyShip(String newShipType) {
		
		EnemyShip newShip = null;
		
		if(newShipType.equalsIgnoreCase("U")) {
			return new UFOEnemyShip();
		}
		else if(newShipType.equalsIgnoreCase("R")) {
			return new RocketEnemyShip();
		}
		else if((newShipType).equalsIgnoreCase("B")){
			return new BigUFOEnemyShip();
		}
		else return null;
	}

}
