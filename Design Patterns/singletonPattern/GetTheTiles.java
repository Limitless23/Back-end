package singletonPattern;

import java.util.LinkedList;

public class GetTheTiles implements Runnable{
	public void run() {
		Singleton newInstance = Singleton.getInstance();
		System.out.println("Instance ID: " + System.identityHashCode(newInstance));
		
		System.out.println(newInstance.getLetterList());
		
		LinkedList<String> playerOneTiles = newInstance.getTiles(2);
		System.out.println("PLayer : "+playerOneTiles);
		
		System.out.println("Got Tiles");
	}
}
