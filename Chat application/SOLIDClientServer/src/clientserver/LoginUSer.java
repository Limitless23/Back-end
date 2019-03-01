package clientserver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.Scanner;

public class LoginUSer implements LoginUserInterface {
	
	private String path, pwd;
	public String uName;
	private SendRecvMsg obj;
	private boolean found = false;
	private BlockedCheck blockedUname;
	private String id;
	private Socket clientsock;
	
	public LoginUSer(String id, Socket clientsock) {
		this.clientsock = clientsock;
		obj =   new SendRecvMsg(id);
		obj.sendMsg("User name: ");
		uName = obj.recvMsg().trim();
		obj.sendMsg("Password: ");
		this.id = id;
		pwd = obj.recvMsg().trim();
		//obj.closeStreams();
		path = System.getProperty("user.dir");
	}

	@Override
	public boolean loginUser() {
		
		 
			try(Scanner in = new Scanner(new FileReader(path+File.separator+"credentials.txt"));) {
				while(in.hasNextLine()){
		            String[] line = in.nextLine().split(" ");
		            
		            blockedUname = new BlockedCheck(line[0]);
		            if(blockedUname.blockedUName()) {
		            	return false;
		            }
		            
		            if(line[0].equals(uName) && line[1].equals(pwd)) {
		            	found = true;
		            	
		            	//May eliminate the online users and online id as if they are online, they will be in id to name
		            	Server.idToName.put(id, uName);
		            //	ServerThread.this.thisThread.clientName = uName;
		            	//ServerThread.thisThread.clientName = uName;
		            	Server.online_users.add(uName);
		            	Server.online_id.add(id);
		            	Server.last_login.put(uName, System.currentTimeMillis());
		            	
		            	try {
							clientsock.setSoTimeout(Server.servCon.timeout);
						} catch (SocketException e) {
							obj.sendMsg(("You have been logged out due to inactivity"));
							//e.printStackTrace();
						}
		            	return found;
		            	
		            }
 
		            
		        
			}
				
				
				
			} catch (FileNotFoundException e) {
				System.out.println("Invalid credentials");
				e.printStackTrace();
			}
			
			return found;
		

	}

}
