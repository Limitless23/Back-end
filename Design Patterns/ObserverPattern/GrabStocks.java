package ObserverPattern;

public class GrabStocks {

	public static void main(String[] args) {
		
		StockGrabber stockGrabber = new StockGrabber();
		StockObserver observer1 = new StockObserver(stockGrabber);
		
		stockGrabber.setAAPLPrice(197.00);
		stockGrabber.setIBMPrice(857.00);
		stockGrabber.setGOOGPrice(518.00);
		
		StockObserver observer2 = new StockObserver(stockGrabber);
		
		stockGrabber.setAAPLPrice(1457.00);
		stockGrabber.setIBMPrice(543.00);
		stockGrabber.setGOOGPrice(333.00);
		
		Runnable getIBM = new GetTheStock(stockGrabber, 2, "IBM", 222.00);
		Runnable getAAPL = new GetTheStock(stockGrabber, 2, "AAPL", 2234.00);
		Runnable getGOOG = new GetTheStock(stockGrabber, 2, "GOOG", 33.00);
		
		new Thread(getIBM).start();
		new Thread(getAAPL).start();
		new Thread(getGOOG).start();
		
	}

}
