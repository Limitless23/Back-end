package clientserver;

import java.net.InetAddress;
import java.net.Socket;

public class BlockedCheck {
	
	private InetAddress ipAddr = null;
	private String userName = null;
	
	public BlockedCheck(InetAddress clientIP) {
		
		ipAddr = clientIP;
		
	}
	
	public BlockedCheck(String name) {
		userName = name;
		
	}
	
	public boolean blockedUName() {
		//might wanna lock this part
		if(Server.blocked_user_name.containsKey(userName)){
            long time = System.currentTimeMillis() - Server.blocked_user_name.get(userName);

            if(time<Server.servCon.block_duration) // if blocked time not done and they try to login
                return true;
            else //if block period over, remove the ip from the block list
            {
            	Server.blocked_user_name.remove(userName);
            	return false;
            
            }
           }
		else
			return false;
		
	}

	public boolean blockedIP() {
		
		if(Server.blocked_ip.containsKey(ipAddr.toString())){
            long time = System.currentTimeMillis() - Server.blocked_ip.get(ipAddr.toString());

            if(time<Server.servCon.block_duration) // if blocked time not done and they try to login
                return true;
            else //if block period over, remove the ip from the block list
            {
            	Server.blocked_ip.remove(ipAddr.toString());
            	return false;
            
            }
           }
		else
			return false;
		
	}

	
	
	
	
	
}
