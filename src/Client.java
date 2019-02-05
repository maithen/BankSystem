import java.util.Arrays;

public abstract class Client {
	
	private int cid;
	private String name;
	private float balance;
	protected final float commissionRate;
	protected final float interestRate;
	private Account[] account = new Account[5];
	private int counter=0;
	
	
	public Client(int clientId, String clientName, float clientBalance, float cr, float ir) {
		this.commissionRate = cr;
		this.interestRate = ir;
		setCid(clientId);
		setName(clientName);
		setBalance(clientBalance);
		
	
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
				Logger.log(log);
				return;
					}
				}


			}		
	
	// Getting all Accounts.
	public String getAccounts(){
		String gA = "";
		for(int i=0;i<account.length;i++) {
			if(account[i]!=null) {
				gA +=  String.format("%s ,", account[i]);
			}
	
		}
		if(gA!= "") {
		return String.format("Client ID: %d Accounts: %s", getCid(),gA);
		}else {
			return null;
		}
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
	public void removeAccount(Account acc) {
		for(int i=0;i<account.length;i++) {
			if(account[i]!=null && account[i].equals(acc)){
				balance += account[i].getBalance();
				Log log = new Log(System.currentTimeMillis(), getCid(), String.format("Client has deleted Account ID: %d", account[i].getId()), account[i].getBalance());
				Logger.log(log);
				account[i]=null;
				return;
			}
			}
		System.out.printf("Account: %s does not exist. thus cannot be removed. \n", acc);
		}
	
	// Making a deposit to a Client.
	public void deposit(float dp) {
		
		balance += dp-getCommissionRate();
		
	}
	
	// Making a withdraw from a Client.
	public void withdraw(float amount) throws WithdrawException{
		if(amount> getBalance()) {
			Exception WithdrawException;
		}
		balance -= amount+(amount*getCommissionRate());
		Bank.updateTotalCommission(amount*getCommissionRate());
	}
	
	// Auto-updating the amount of interest to add on each Client's accounts
	public void autoUpdateAccounts() {
		for(int i=0;i<account.length;i++) {
			if(account[i]!=null)
			 account[i].setBalance((account[i].getBalance()+ getInterestRate()));
		}
		Log log = new Log(System.currentTimeMillis(), getCid(), "Interest added to the Client's Account balance", getInterestRate());
		Logger.log(log);
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
	public float getCommissionRate() {
		return commissionRate;
	}
	//public void setCommissionRate(float commissionRate) {
		
		//this.commissionRate = commissionRate;
		
	//}
	public float getInterestRate() {
		return interestRate;
	}

	public int getCounter() {
		return counter;
	}

	@Override
	public String toString() {
		return String.format(
				"Client [ID=%s, Name=%s, Balance=%s, comissionRate=%s, interestRate=%s,]\n%s's Accounts=%s] ", cid,
				name, balance, commissionRate, interestRate,name, Arrays.toString(account));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cid;
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
		if (cid != other.cid)
			return false;
		return true;
	}
	
	

}
