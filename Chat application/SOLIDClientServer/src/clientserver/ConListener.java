package clientserver;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ConListener implements Runnable {
	
	private  Socket clientsock;
	private ServerSocket serversoc;
	private int id;
	public ConListener(ServerSocket serversoc) {
		
		this.serversoc = serversoc;
		id = 0;
	}
	
	public void run() {
		
		while(true) {
			
			try {
				
				clientsock = serversoc.accept();
				id++;
				for(int i=0;i<10;i++){
                    if (Server.threads[i] == null){
                    	
                        Server.threads[i]= new ServerThread(clientsock,String.valueOf(id));
                        //Server.threads[i].setThisThread(Server.threads[i]);
                        new Thread(Server.threads[i]).start();
                        //Server.idToName.put(String.valueOf(id), null);
                        
                        break;
                    }
                }
				
			} 
			catch (IOException e) {
				System.out.println("Trouble getting the connection maybe?");
				e.printStackTrace();
			}
			
			
			
		}
		

	}

}
