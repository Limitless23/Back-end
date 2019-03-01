package clientserver;

import java.io.IOException;
import java.net.ServerSocket;
//object of this class will need to be available to every other thread
public class ServerConfig {
	
	private static ServerSocket serversock;
	public static int timeout,block_duration;
	public int port;
	
	
	public ServerConfig(String[] args) {
		
        port=Integer.parseInt(args[0]);
        block_duration = Integer.parseInt(args[1]) * 1000;
        timeout = Integer.parseInt(args[2]) * 1000;
        try {

            serversock = new ServerSocket(port);
            
        } catch (IOException e) {
        	System.out.println("issue with server socket");
            System.out.println(e);
        }
		
	}
	
	public ServerSocket getServerSocket() {
		 return serversock;
	}

}
