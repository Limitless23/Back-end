package clientserver;

public class StartChat {
	
	private SendRecvMsg obj;
	private MessageProcessor proc;
	private String id;
	public StartChat(String id) {
		//this.thisThread = thisThread;
		this.id = id;
		this.proc =  new MessageProcessor(id);;
		obj = new SendRecvMsg(id);
		read();
	}
	
	public void read() {
		
		while(Server.online_id.contains(id)) {
			
			String msg = obj.recvMsg();
			 
			proc.process(msg);
			
		}
		
		//obj.closeStreams();
	}
	
	

}
