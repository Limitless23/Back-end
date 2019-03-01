package clientserver;

import java.io.BufferedReader;
import java.io.IOException;

public class ClientThread implements Runnable {
	BufferedReader iss;
	 public ClientThread(BufferedReader r) {
		iss = r;
	}

	@Override
	public void run() {
		String response;
		try{
			//System.out.println("Trying..");
			while((response = CreateConnection.is.readLine()) != null){
				//System.out.println("response??");
				System.out.println(response);
				if(response.indexOf("Bye") != -1)
					break;
			}
			System.out.println("guess nothing..");
			//Client.closed = true;
		}
		catch(IOException e){
			System.err.println(e);
		}

	}

}
