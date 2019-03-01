package clientserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

public class ServerThread implements Runnable {
	
	public  Socket clientsock;
	public  boolean logged_in = false;
	public  String clientName;
	public SendRecvMsg Tmsg;
	//public  ServerThread thisThread;
	public String id;
	
	public ServerThread(Socket clientsock,String id) {
		this.clientsock = clientsock;
		
		//this.thisThread = Thread.currentThread();
		//this.clientName = null;
		this.id = id;
		try {
			
			Server.IS.put(id, new BufferedReader(new InputStreamReader(clientsock.getInputStream())));
			Server.OS.put(id, new PrintStream(clientsock.getOutputStream()));
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		this.Tmsg = new SendRecvMsg(id);
		
		
	}
	
	//public void setThisThread(ServerThread thisThread) {
	//	this.thisThread = thisThread;
	//}
	
	
	@Override
	public void run() {
		
		BlockedCheck checkIP = new BlockedCheck(clientsock.getInetAddress());
		if(checkIP.blockedIP() == true) {
			
			Tmsg.sendMsg("Your IP address in temporarily blocked. Please try after sometime.");
			
			try {
				clientsock.close();
				return;
			} catch (IOException e) {
				System.out.println("Tried closing cos of blocked ip");
				e.printStackTrace();
			}
		}
		
		AttemptLogin attemptLogin = new AttemptLogin(id,clientsock);
		
		this.clientName = attemptLogin.attempt();
		if(clientName!=null) {
			logged_in=true;
		}
		
		if(logged_in) {
			WelcomeProc welcome = new WelcomeProc(id);
			welcome.welcomeProcedure();
			
		}
		//SendRecvMsg obj1 = new SendRecvMsg();
		StartChat chat = new StartChat(id);
		
		
	}


}
