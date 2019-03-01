package clientserver;

import java.net.Socket;

public class AttemptLogin {

	private int attempts = 3;
	private LoginUSer login;
	private String id;
	private Socket clientsock;
	public AttemptLogin(String id, Socket clientsock) {
		
		this.id = id;
		this.clientsock = clientsock;
	}
	
	public String attempt() {
		while(attempts>0) {
			login = new LoginUSer(id, clientsock);
			if(!login.loginUser()) {
				attempts--;
			}
			else break;
		}
		
		if(attempts==0) {
			
			SendRecvMsg msg = new SendRecvMsg(id);
			msg.sendMsg("You have been blocked as you have tried to login incorrectly 3 times. ");
			//msg.closeStreams();
			
			Server.blocked_ip.put(clientsock.getInetAddress().toString(), System.currentTimeMillis());
			if(Server.userData.user_list.contains(login.uName)) {
				Server.blocked_user_name.put(login.uName, System.currentTimeMillis());
			}
			
			return null;
		}
		
		else return login.uName;
	}

}
