package clientserver;

import java.io.IOException;

public class Client {
	//public static boolean closed = false;
	public static void main(String[] args)  {
		
		CreateConnection con = new CreateConnection(args);
		
		if(con.readyToRead()){
			try{
				
				new Thread(new ClientThread(con.is)).start();
				
				//this will cause issues
				while(con.isConnected()){
					con.os.println(con.inputline.readLine().trim());
				}
				con.closeConnection();
			}
			catch(IOException e){
				System.out.println(e);
			}
		}
	}

}
