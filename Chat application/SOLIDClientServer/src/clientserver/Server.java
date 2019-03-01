package clientserver;

import java.io.BufferedReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;

public class Server {
	
	
	public static InitializeUserData userData;
	public static HashMap<String,ArrayList<String>> blocked;
	public static ServerThread[] threads = new ServerThread[10];
    public static ArrayList<String> message_buffer = new ArrayList<String>();
    public static HashMap<String,Long> blocked_ip = new HashMap<String,Long>();
    public static HashMap<String,String> idToName = new HashMap<String,String>();
    public static HashMap<String,Long> blocked_user_name = new HashMap<String,Long>();
    public static ServerConfig servCon;
    public static ArrayList<String> online_users = new ArrayList<String>();
    public static ArrayList<String> online_id = new ArrayList<String>();
    public static HashMap<String,Long> last_login = new HashMap<String,Long>();
    public static HashMap<String, BufferedReader> IS = new HashMap<String, BufferedReader>();
    public static HashMap<String, PrintStream> OS = new HashMap<String, PrintStream>();
	
	public static void main(String[] args) {
		
		try {
			System.out.println(InetAddress.getLocalHost().getHostAddress());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
		userData = new InitializeUserData();
		
		blocked = userData.createBlockedList();
		servCon = new ServerConfig(args);
		ConListener listen = new ConListener(servCon.getServerSocket());
		new Thread(listen).start();
		
		
		

	}

}
