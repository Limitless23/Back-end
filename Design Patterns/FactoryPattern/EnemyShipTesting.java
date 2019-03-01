package FactoryPattern;

import java.util.Scanner;

public class EnemyShipTesting {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		EnemyShipFactory shipFactory = new EnemyShipFactory();
		EnemyShip theEnemy = null;
		System.out.println("What type ship? U/B/R ");
		if(scan.hasNextLine()) {
			String typeOfShip = scan.nextLine();
			//This is the crux! a different type of object is generated dynamically
			theEnemy = shipFactory.makeEnemyShip(typeOfShip);
		}
		
		if(theEnemy!=null)
		{
		doStuffEnemy(theEnemy);
		}
		else System.out.println("Enter U/R/B only");
	}
	
	public static void doStuffEnemy(EnemyShip anEnemyship) {
		
		anEnemyship.displayEnemyShip();
		anEnemyship.followHeroShip();
		anEnemyship.EnemyShipShoots();
	}
}
