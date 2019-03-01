package clientserver;

import java.util.concurrent.locks.ReentrantLock;

public class WelcomeProc implements MsgBroadcast {
	private ReentrantLock lock;
	private SendRecvMsg msg;
	private OfflineMsgs offlinemsgs;
	private String id;
	//private ServerThread thisThread;
	public WelcomeProc(String id) {
		this.id = id;
		//this.thisThread = thisThread;
		msg = new SendRecvMsg(id);
	}
	
	public void welcomeProcedure() {
		
		msg.sendMsg("Welcome "+Server.idToName.get(id) );
		lock = new ReentrantLock();
		offlinemsgs = new OfflineMsgs(msg, id); // check here
		offlinemsgs.showMsgs();
		BroadCastMsg();
		//msg.closeStreams();
		
	}
	
	@Override
	public void BroadCastMsg() {
		lock.lock();
		for(int i=0;i<Server.threads.length;i++) {
			
			if(Server.threads[i]!=null && !Server.threads[i].id.equals(id) && !Server.blocked.get(Server.idToName.get(id)).contains(Server.idToName.get(Server.threads[i].id)) ) {
				msg = new SendRecvMsg(Server.threads[i].id);
				msg.sendMsg(Server.idToName.get(id)+" is online");
			}
		}
		lock.unlock();
		
	}

}
