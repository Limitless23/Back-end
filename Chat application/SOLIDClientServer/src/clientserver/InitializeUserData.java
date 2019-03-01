package clientserver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class InitializeUserData implements getUserData {
	
	
	public  ArrayList<String> user_list;
	private String path;
	public  HashMap<String,ArrayList<String>> blocked;
	public InitializeUserData() {
		
		user_list =  new ArrayList<String>();
		
		path = System.getProperty("user.dir");
		blocked = new HashMap<String,ArrayList<String>>();
		getUserList();
	
	}
	
	//this access modifier shouldn't be public
	public void getUserList() {
		
		
        Scanner in;
		try {
			in = new Scanner(new FileReader(path+File.separator+"credentials.txt"));
			while(in.hasNextLine()){
	            String[] line = in.nextLine().split(" ");
	            user_list.add(line[0]);
	            
	            
		}
			
			in.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("credentials file not found in "+path.toString());
			e.printStackTrace();
		}
		
		
        
     }

	public HashMap<String,ArrayList<String>> createBlockedList() {
		
		for(int i = 0;i<user_list.size();i++){
            ArrayList<String> list = new ArrayList<String>();

            blocked.put(user_list.get(i), list);
        }
		
		return blocked;
		
		
	}
		
	

	

}
