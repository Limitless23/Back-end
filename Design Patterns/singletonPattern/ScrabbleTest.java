package singletonPattern;

import java.util.LinkedList;

public class ScrabbleTest {

	public static void main(String[] args) {
		
		Singleton newInstance = Singleton.getInstance();
		System.out.println("Instance 1 ID: " + System.identityHashCode(newInstance));
		
		System.out.println(newInstance.getLetterList());
		
		LinkedList<String> playerOneTiles = newInstance.getTiles(3);
		System.out.println("PLayer 1: "+playerOneTiles);
		
		System.out.println(newInstance.getLetterList());
		
		Singleton instanceTwo = Singleton.getInstance();
		System.out.println("Instance 2 ID: " + System.identityHashCode(instanceTwo));
		System.out.println(instanceTwo.getLetterList());
		LinkedList<String> playerTwoTiles = instanceTwo.getTiles(2);
		System.out.println("PLayer 2: "+playerTwoTiles);
	}

}
