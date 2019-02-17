import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Bank {
	Scanner scanner = new Scanner(System.in);
	private static Bank instance = new Bank("The Big Bank");
	private String bankName;
	private ArrayList<Client> clients = new ArrayList<>();
	private Logger logService;
	private float bBalance;
	private static float totalCommission;
	
			
	
	public static void updateTotalCommission(float UTC) {
			 totalCommission += UTC;
			
	}
			
	// Using the bank instance
	public static Bank bank() {
		return instance;
	}
	
	public void printClientList() {
			System.out.println(clients.toString());
		}
	
	
	//Constructor (empty for now)
	private Bank(String bankName) {
			setBankName(bankName);
	
			
		}

	// Starts the account updater (empty for now)
	public void startAccountUpdater() {}
	
	//Adding a client to the array
	public void addClient(int id, String name, float balance) {
	
		for(Client e : clients) {
			if (e!=null && id==e.getCid()) {
			System.out.printf("Client ID: %d already exists. \n", id);
			return;
			}
		}
		System.out.printf("Enter Client Type: regular, gold, platinum (all lower case) \n");
		String Type = scanner.nextLine();
		if(clients!=null && clients.size() >=0)
	
			if(Type.equals("regular")) {
			clients.add(new Regular_Client(id, name, balance));
			Log log = new Log(System.currentTimeMillis(), id, "Regular Client has been added to the bank.", balance);
			Logger.log(log);
			return;
			}
		
		
		
				if(Type.equals("gold")) {
				clients.add(new Gold_Client( id,  name, balance));
				Log log = new Log(System.currentTimeMillis(), id, "Gold Client has been added to the bank.", balance);
				Logger.log(log);
				return;
				}
			
			
				if(Type.equals("platinum")) {
					clients.add(new Platinum_Client( id,  name, balance));
					Log log = new Log(System.currentTimeMillis(), id, "Platinum Client has been added to the bank.", balance);
					Logger.log(log);
					return;
					}
				}
		
		
	
	
	//removing a client from the array
	public void removeClient(Client client) {
		for(Client e : clients) {
			if(e==client) {
				Log log = new Log(System.currentTimeMillis(), e.getCid(), "Client has been removed.", e.getBalance());
				Logger.log(log);
				e=null;
				return;
			}
		}
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
		float sum = 0;
	for(Client e : clients) {
			if(e!=null) {
				sum +=e.getFortune();
			}
		}
			this.bBalance = sum+getTotalcommission();
	}
	
	// Getting the bank's balance
	public float getBalance() {
		Bank.bank().setBalance();
		return bBalance;
	}
	
	public float getTotalcommission() {
		return totalCommission;
	}
	
	// Supposed to retrieve clients (shows memory allocation for now), 
	//public clients getClients() {
	//		return clients;
	//	}
	
	public Client getClient(int id) {
	
		for(Client e : clients){
			if(id == (int)e.getCid()) {
				 return e;
			
			}
		}
		return null;
		}
	
	public String getBankName() {
		return bankName;
	}

	private void setBankName(String bankName) {
		this.bankName = bankName;
	}
	
	@Override
	public String toString() {
		return String.format("Bank [scanner=%s, bankName=%s, clients=%s, logService=%s, bBalance=%s]", scanner,
				bankName, clients, logService, bBalance);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(bBalance);
		result = prime * result + ((bankName == null) ? 0 : bankName.hashCode());
		result = prime * result + ((clients == null) ? 0 : clients.hashCode());
		result = prime * result + ((logService == null) ? 0 : logService.hashCode());
		result = prime * result + ((scanner == null) ? 0 : scanner.hashCode());
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
		if (Float.floatToIntBits(bBalance) != Float.floatToIntBits(other.bBalance))
			return false;
		if (bankName == null) {
			if (other.bankName != null)
				return false;
		} else if (!bankName.equals(other.bankName))
			return false;
		if (clients == null) {
			if (other.clients != null)
				return false;
		} else if (!clients.equals(other.clients))
			return false;
		if (logService == null) {
			if (other.logService != null)
				return false;
		} else if (!logService.equals(other.logService))
			return false;
		if (scanner == null) {
			if (other.scanner != null)
				return false;
		} else if (!scanner.equals(other.scanner))
			return false;
		return true;
	}
	
	
}


		

	


