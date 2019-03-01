package clientserver;

import java.util.concurrent.locks.ReentrantLock;

public class MessageProcessor {
	
	
	//public String clientame, id;
	private ReentrantLock lock;
	private String id;
	private SendRecvMsg msgr;
	
	public MessageProcessor(String id) {
		this.id = id;
		//clientame = Server.idToName.get(id);
		this.msgr = new SendRecvMsg(id);
		lock = new ReentrantLock();
	}
	
	public  void process(String msg) {
		
		if(msg.startsWith("message")) {
			messagePrivate(msg);
		}
		
	}
	
	
	private  void messagePrivate(String line) {
			
			String clientname = Server.idToName.get(id);
		
			 
            String[] words = line.split("\\s", 3);
            //System.out.println(words[1]);
            int valid=0;
            //check if recipient is valid
            if(Server.online_users.contains(words[1]))
                valid =1;
            else if (Server.userData.user_list.contains(words[1])) {
            	valid = 2;
            }
            
            
            if(valid == 0)
            	msgr.sendMsg(("Message not delivered as the user does not exist."));


            else{
                //MIGHT WANNA CHECK THIS LINE
            	//Server.blocked.
            	if(Server.blocked.get(words[1]).contains(clientname)){
                    msgr.sendMsg((">Your message could not be delivered as the recipient has blocked you."));
                }
                else{
                    {
                        int i;
                        
                        for( i =0;i<Server.threads.length;i++){
                        	//if(Server.threads[i]!=null) {
                        	//	System.out.println("iterating through client: "+Server.threads[i].clientName);
                        	//}
                        	
                            if(Server.threads[i]!=null && Server.idToName.get((Server.threads[i].id)).equals(words[1])){//valid and online
                            	SendRecvMsg tempMsgr = new SendRecvMsg(Server.threads[i].id);
                                tempMsgr.sendMsg((clientname+": "+words[2]));
                                break;
                                }
                        }
                        
                        if ( i==10)//valid but offline
                            Server.message_buffer.add(words[1]+" "+clientname+": "+words[2]);//recipient followed by message

                    }
                }
            }}
		
	}
	

