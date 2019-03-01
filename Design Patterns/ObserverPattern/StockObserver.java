package ObserverPattern;

public class StockObserver implements Observer {
	
	private double ibmPrice;
	private double aaplPrice;
	private double googPrice;
	
	private static int observerIDTracker = 0;
	private int observerID;
	
	private Subject stockGrabber;
	
	public StockObserver(Subject stockGrabber) {
		this.stockGrabber = stockGrabber;
		this.observerID = ++observerIDTracker;
		System.out.println("New observer "+observerID+" created");
		stockGrabber.register(this);
	}
	

	@Override
	public void update(double ibmPrice, double aaplPrice, double googPrice) {
		this.aaplPrice=aaplPrice;
		this.ibmPrice=ibmPrice;
		this.googPrice=googPrice;
		printThePrices();

	}

	public void printThePrices() {
		System.out.println(observerID+"\nIBM: "+ibmPrice+"\nAAPL: "+aaplPrice+"\nGOOG: "+googPrice+"\n");
	}
}
