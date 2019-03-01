package singletonPattern;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class Singleton {
	
	private static Singleton firstInstance = null;
	
	String[] scrabbleLetters = {"a","n","i","j","f"};
	
	private LinkedList<String> letterList = new LinkedList<String>(Arrays.asList(scrabbleLetters));
	
	//to screw things up
	static boolean firstThread = true;
	public Singleton() {
		// TODO Auto-generated constructor stub
	}
	
	//dont add synchronized here, cos it'll cause EVERY thread to wait its turn. You need to wait only for 1 thread not all
	public static Singleton getInstance() {
		if(firstInstance == null) {
			if(firstThread) {
				firstThread=false;
				Thread.currentThread();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			//This is going to force it to be a synchronized method until the first object is created and does its work
			synchronized(Singleton.class) {
				if(firstInstance == null) {
					firstInstance = new Singleton();
					
					Collections.shuffle(firstInstance.letterList);
					
				}
			}
			
		}
		
		return firstInstance;
	}
	
	public LinkedList<String> getLetterList(){
		return firstInstance.letterList;
	}
	
	public LinkedList<String> getTiles(int howManyTiles){
		LinkedList<String> tilesToSend = new LinkedList<String>();
		
		for(int i=0;i<howManyTiles;i++) {
			tilesToSend.add(firstInstance.letterList.remove(0));
		}
		
		return tilesToSend;
	}

}
