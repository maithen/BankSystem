import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
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
	
	//Constructor 
	private Bank(String bankName) {
			setBankName(bankName);
			load();
	
			
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
			clients.add(new ClientRegular(id, name, balance));
			Log log = new Log(System.currentTimeMillis(), id, "Regular Client has been added to the bank.", balance);
			Logger.log(log);
			return;
			}
		
		
		
				if(Type.equals("gold")) {
				clients.add(new ClientGold( id,  name, balance));
				Log log = new Log(System.currentTimeMillis(), id, "Gold Client has been added to the bank.", balance);
				Logger.log(log);
				return;
				}
			
			
				if(Type.equals("platinum")) {
					clients.add(new ClientPlatinum( id,  name, balance));
					Log log = new Log(System.currentTimeMillis(), id, "Platinum Client has been added to the bank.", balance);
					Logger.log(log);
					return;
					}
				}
		
	public void addClient(Client client) {
		
		for(Client e : clients) {
			if (e!=null && client.getCid()==e.getCid()) {
			System.out.printf("Client ID: %d already exists. \n", client.getCid());
			return;
			}
		}
		
	
			if(client instanceof ClientRegular) {
			clients.add(client);
			Log log = new Log(System.currentTimeMillis(), client.getCid(), "Regular Client has been added to the bank.", client.getBalance());
			Logger.log(log);
			return;
			}
		
		
		
				if(client instanceof ClientGold) {
				clients.add(client);
				Log log = new Log(System.currentTimeMillis(), client.getCid(), "Gold Client has been added to the bank.", client.getBalance());
				Logger.log(log);
				return;
				}
			
			
				if(client instanceof ClientPlatinum) {
					clients.add(client);
					Log log = new Log(System.currentTimeMillis(), client.getCid(), "Platinum Client has been added to the bank.", client.getBalance());
					Logger.log(log);
					return;
					}
				}
	

	public void store() {
		
		ObjectOutputStream out = null;
		try {
			out = new ObjectOutputStream(new FileOutputStream(new File("M:\\Java\\bank.data")));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	
			try {
				out.writeObject(clients);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		try {
			out.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.printf("Clients have been saved. \n");
		
		
	}
	
	@SuppressWarnings("unchecked")
	public void load() {
		
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(new File("M:\\Java\\bank.data")));
			try {
				clients = (ArrayList<Client>) in.readObject();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
			
				sum +=e.getFortune();
			
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
	
	public ArrayList<Client> getClients() {
			return clients;
		}
	
	public Client getClient(int id) {
	
		for(Client e : clients){
			if(id == (int)e.getCid()) {
				 return e;
			
			}
		}
		return null;
		}
	
	public Client getClient(Client client) {
		
		for(Client e : clients){
			if(e.equals(client)) {
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


		

	


