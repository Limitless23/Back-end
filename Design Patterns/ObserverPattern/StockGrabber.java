package ObserverPattern;

import java.util.ArrayList;

public class StockGrabber implements Subject {
	
	private ArrayList<Observer> observers;
	private double ibmPrice;
	private double aaplPrice;
	private double googPrice;
	
	public  StockGrabber() {
		// 
		observers = new ArrayList<Observer>();
	}   
	@Override
	public void register(Observer o) {
		
		observers.add(o);
		
	}

	@Override
	public void unregister(Observer o) {
		
		int index = observers.indexOf(o);
		System.out.println("Observer "+index+1+" has been deleted.");
		observers.remove(index);
		
	}

	@Override
	public void notifyObserver() {
		
		for(Observer observer : observers) {
			observer.update(ibmPrice, aaplPrice, googPrice);
		}
		
	}
	
	public void setIBMPrice(double newIBMPrice) {
		this.ibmPrice = newIBMPrice;
		notifyObserver();
	}
	public void setAAPLPrice(double newAAPLPrice) {
		this.aaplPrice = newAAPLPrice;
		notifyObserver();
	}
	public void setGOOGPrice(double newGOOGPrice) {
		this.googPrice = newGOOGPrice;
		notifyObserver();
	}
	
}
