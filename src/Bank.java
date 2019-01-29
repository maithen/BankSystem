
public class Bank {
	
	Client[] clients = new Client[100];
	private Logger logService;
	//->Account updater that I'm leaving for later
	private float balance;
	
	
	//Constructor (empty for now)
	public Bank() {
	
			
			
		}
	
	//Adding a client to the array
	public void addClient(int id, String name, float balance) {
		for(int i=0;i<clients.length;i++) {
			if(clients[i]==null) {
				clients[i] = new Client(id, name, balance);
				return;
			}
	}
	}
	
	//removing a client from the array
	public void removeClient(int id) {
		for(int i=0;i<clients.length;i++) {
			if(id==clients[i].getCid()) {
				clients[i]=null;
				Logger logger;
				return;
			}
		}
	}
	
	public float getBalance() {
		int sum=0;
		for(int i=0;i<clients.length;i++) {
			if(clients[i]!=null) {
				sum+= clients[i].getFortune();
			}
		}
		return sum+balance;
	}
	
	public Client[] getClients() {
		return Logger(log);
		
	}
	

}
