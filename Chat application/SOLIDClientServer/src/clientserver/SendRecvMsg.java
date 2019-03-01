package clientserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class SendRecvMsg {
	
	
	private BufferedReader is = null;
    private PrintStream os = null;
    
	public SendRecvMsg(String id) {
		
		is = Server.IS.get(id); 
		os = Server.OS.get(id);
        
		
	}
	
	public void sendMsg(String msg) {
		os.println(msg);
	}
	
	public String recvMsg() {
		String msg = null;
		try {
			
			msg = is.readLine().trim();
			
			
		} catch (IOException e) {
			System.out.println("Connection closed due to inactivity");
			//e.printStackTrace();
		}
		
		return msg;
	}
	
	public void closeStreams() {
		try {
			is.close();
			os.close();
		} catch (IOException e) {
			System.out.println("Closing streams issue");
			e.printStackTrace();
		}
		
	}

}
