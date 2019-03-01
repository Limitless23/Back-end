package clientserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.*;
public class CreateConnection  implements createConnectionInterface {

	private int port ;
	private InetAddress host;
	private Socket socket ;
	PrintStream os ;
	static BufferedReader is;
	BufferedReader inputline;
	private boolean validFlag = true;
	public CreateConnection(String[] args)  {
		
		if(args.length<2){
			System.out.println("Using default ip and port");
			try {
					host = InetAddress.getByName("localhost") ;
				} 
			catch (UnknownHostException e) {
					validFlag = false;
					System.out.println("Issue with local host");
					e.printStackTrace();
				}
			
		}
		else
		{
			try {
					host = InetAddress.getByName(args[0]);
					port = Integer.parseInt(args[1]);
				} 
			catch (UnknownHostException e) {
					validFlag = false;
					System.out.println("Issue with host");
					e.printStackTrace();
				}
			
			
		}
		
		if(validFlag) {
			connect();
		}
		
	}
	
	public void connect()   {
		try {
			socket = new Socket(host,port);
			inputline = new BufferedReader(new InputStreamReader(System.in));
			os = new PrintStream(socket.getOutputStream());
			is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			} 
		catch (IOException e) {
			System.out.println(e);
			}
		
	}
		
	public void closeConnection() {
		
		
		try {
			os.close();
			is.close();
			socket.close();
			}
		catch (IOException e) {
			
			e.printStackTrace();
			}
	}
	
	public boolean isConnected() {
		if(socket.isClosed())
			return false;
		else return true;
	}
		
	public boolean readyToRead() {
		
		if(socket != null && os != null && is != null) {
			return true;
		}
		
		else return false;
		
		
	}
		
	
		
	
	
	
	
}
