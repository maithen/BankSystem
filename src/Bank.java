import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Bank {
	
	private static Bank instance = new Bank("The Big Bank");
	private String bankName;
	private Client[] clients;
	private Logger logService;
	private Logger logger = new Logger("DriverName");
	private float bBalance;
	private static float totalCommission;
	
	
	
	
	
			
	public static Bank getInstance() {
		return instance;
	}
	
	public static void updateTotalCommission(float UTC) {
			 totalCommission += UTC;
	}
			
	// Using the bank instance
	public static Bank bank() {
		return instance;
	}
	
	public void printClientList() {
		for(int i=0;i<clients.length;i++) {
			System.out.println(clients[i]);
		}
	}
	
	//Constructor (empty for now)
	private Bank(String bankName) {
			setBankName(bankName);
			clients = new Client[100];
			
		}

	// Starts the account updater (empty for now)
	public void startAccountUpdater() {}
	
	//Adding a client to the array
	public void addClient(int id, String name, float balance) {
		for(int j=0;j<clients.length;j++) {
			if (clients[j]!=null && id==clients[j].getCid()) {
				System.out.printf("Client ID: %d already exists. \n", id);
				return;
			}
		}
		for(int i=0;i<clients.length;i++) {
			if(clients[i]==null) {
			clients[i] = new Regular_Client( id,  name, balance);
			Log log = new Log(System.currentTimeMillis(), clients[i].getCid(), "Client has been added to the bank.", balance);
			logger.log(log);
			return;
			}
		}
		}
	
	
	//removing a client from the array
	public void removeClient(Client client) {
		
		Client.equals(client);
		
	/*	for(int i=0;i<clients.length;i++) {
			if(clients[i]!= null && id == clients[i].getCid()) {
				Log log = new Log(System.currentTimeMillis(), clients[i].getCid(), "Client  has been removed.", clients[i].getBalance());
				logger.log(log);
				clients[i]=null;
				return;
			}	
			}
		System.out.printf("Client ID: %d does not exist. \n", id);*/
		}
	
	// Setting the bank's balance
	public void setBalance() {
		//float sum = 0;
	//	for(int i=0;i<clients.length;i++) {
		//	if(clients[i]!=null) {
			//	sum += clients[i].getFortune();
			//}
		//}
			bBalance = getTC();
	}
	
	// Getting the bank's balance
	public float getBalance() {
	
		return bBalance;
	}
	
	public float getTC() {
		return totalCommission;
	}
	
	// Supposed to retrieve clients (shows memory allocation for now), 
	public Client[] getClients() {
			return clients;
		}
	
	public Client getClient(int id) {
		Client gc = null;
		for(int i=0;i<clients.length;i++){
			if(clients[i]!= null && id == clients[i].getCid()) {
				 return clients[i];
			}
			
		}
				return gc;
		}
	
	public String getBankName() {
		return bankName;
	}

	private void setBankName(String bankName) {
		this.bankName = bankName;
	}
	
	@Override
	public String toString() {
		return String.format("Name : %s , Bank [clients=%s, logService=%s, balance=%s]", getBankName() , Arrays.toString(clients), logService,
				balance);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(balance);
		result = prime * result + Arrays.hashCode(clients);
		result = prime * result + ((logService == null) ? 0 : logService.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bank other = (Bank) obj;
		if (Float.floatToIntBits(balance) != Float.floatToIntBits(other.balance))
			return false;
		if (!Arrays.equals(clients, other.clients))
			return false;
		if (logService == null) {
			if (other.logService != null)
				return false;
		} else if (!logService.equals(other.logService))
			return false;
		return true;
	}
	
	
}


		

	


