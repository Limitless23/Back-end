package clientserver;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.locks.ReentrantLock;

public class OfflineMsgs implements OfflineMsgsInterface {

	private ReentrantLock lock;
	private Iterator<String> iterator;
	private ArrayList<String> msg_list;
	private SendRecvMsg msgr;
	String clientName;
	
	public OfflineMsgs(SendRecvMsg msgr, String id) {
		clientName = Server.idToName.get(id);
		iterator = Server.message_buffer.iterator();
		msg_list =  new ArrayList<String>();
		this.msgr = msgr;
		lock = new ReentrantLock();
		
	}
	
	public void showMsgs() {
		
		while(iterator.hasNext()) {
			String message = iterator.next();
			if(message.startsWith(clientName)) {
				msg_list.add(message);
				//should this be recieve??
				msgr.sendMsg(message.substring(clientName.length()+1));
				
			}
		}
		//msgr.closeStreams();
		lock.lock();
		for(int i =0; i<msg_list.size();i++) {
			Server.message_buffer.remove(msg_list.get(i));
		}
		lock.unlock();
	}
	 
     
    
    

}
