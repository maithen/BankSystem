import java.util.Arrays;

public class Client {
	
	private int cid;
	private String name;
	private float balance;
	private float comissionRate=0;
	private float  interestRate=0;;
	private Account[] account = new Account[5];
	private Logger logger = new Logger("drivername");
	
	
	// Constructor
	public Client(int clientId, String clientName, float clientBalance) {
		setCid(clientId);
		setName(clientName);
		setBalance(clientBalance);
		logger = new Logger("matanzo");
	
	}
	
	// Adding an account to a Client(does not allow duplicate IDs)
	public void addAccount(int id, float balance) {
		for(int j=0;j<account.length;j++) {
			if (account[j]!=null && id==account[j].getId()){
				System.out.printf("Account ID: %d already exists. pick a new ID to create an account. \n", account[j].getId());
				return;
			}
		}	
		for(int i=0;i<account.length;i++) {
			if(account[i]==null) {
				account[i]= new Account(id,balance);
				Log log = new Log(System.currentTimeMillis(), getCid(), String.format("Account ID: %d has been added to Client.",account[i].getId()), balance);
				logger.log(log);
				return;
					}
				}
			}		
	
	// Getting all Accounts.
	public String getAccounts(){
		String gA = "";
		for(int i=0;i<account.length;i++) {
			if(account[i]!=null) {
				gA +=  String.format("%s \n", account[i]);
			}
		}
		return gA;
	}
	
	// Getting Account details by an account ID
	public String getAccount(int accountId) {
		for(int i=0;i<account.length;i++) {		
			if(account[i]!=null && accountId==account[i].getId()){
				return String.format("%s \n" ,account[i]);
			}
		}	
		return String.format("Account ID: %d does not exist.", accountId);
	}
	
	// Removing an account by an account ID
	public void removeAccount(int id) {
		for(int i=0;i<account.length;i++) {
			if(account[i]!=null && id==account[i].getId()){
				balance += account[i].getBalance();
				Log log = new Log(System.currentTimeMillis(), getCid(), String.format("Client has deleted Account ID: %d", account[i].getId()), account[i].getBalance());
				logger.log(log);
				account[i]=null;
				return;
			}
			}
		System.out.printf("Account ID: %d does not exist. thus cannot be removed. \n",id);
		}
	
	// Making a deposit to a Client.
	public void deposit(float dp) {
		
		balance += dp-comissionRate;
	}
	
	// Making a withdraw from a Client.
	public void withdraw(float wd) {
		balance -= wd+comissionRate;
	}
	
	// Auto-updating the amount of interest to add on each Client's accounts
	public void autoUpdateAccounts() {
		for(int i=0;i<account.length;i++) {
			if(account[i]!=null)
			 account[i].setBalance((account[i].getBalance()+ getInterestRate()));
		}
		Log log = new Log(System.currentTimeMillis(), getCid(), "Interest added to the Client's Account balance", getInterestRate());
		logger.log(log);
		}
	
	// Returning the sum of a client balance + total accounts balance.
	public float getFortune() {
		float sum=0;
		for(int i=0;i<account.length;i++) {
			if(account[i]!=null) {
			sum+=account[i].getBalance();
		}
		}
		return sum+balance;
	}
	


	//Getters/Setters
	public int getCid() {
		return cid;
	}
	public void setCid(int id) {
		this.cid = id;
		}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	public float getComissionRate() {
		return comissionRate;
	}
	public void setComissionRate(float comissionRate) {
		this.comissionRate = comissionRate;
	}
	public float getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(float interestRate) {
		this.interestRate = interestRate;
	}
	

	



	

	@Override
	public String toString() {
		return String.format(
				"Client [ID=%s, Name=%s, Balance=%s, comissionRate=%s, interestRate=%s, logger=%s, \n Accounts=%s] \n", cid,
				name, balance, comissionRate, interestRate, logger, Arrays.toString(account));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(account);
		result = prime * result + Float.floatToIntBits(balance);
		result = prime * result + cid;
		result = prime * result + Float.floatToIntBits(comissionRate);
		result = prime * result + Float.floatToIntBits(interestRate);
		result = prime * result + ((logger == null) ? 0 : logger.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Client other = (Client) obj;
		if (!Arrays.equals(account, other.account))
			return false;
		if (Float.floatToIntBits(balance) != Float.floatToIntBits(other.balance))
			return false;
		if (cid != other.cid)
			return false;
		if (Float.floatToIntBits(comissionRate) != Float.floatToIntBits(other.comissionRate))
			return false;
		if (Float.floatToIntBits(interestRate) != Float.floatToIntBits(other.interestRate))
			return false;
		if (logger == null) {
			if (other.logger != null)
				return false;
		} else if (!logger.equals(other.logger))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	

}
