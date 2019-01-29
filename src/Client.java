
public class Client {
	
	private int cid;
	private String name;
	private float balance;
	private float comissionRate=0;
	private float  interestRate=0;;
	private Logger logger;
	Account[] account = new Account[5];
	
	// Constructor
	public Client(int clientId, String clientName, float clientBalance) {
		setCid(clientId);
		setName(clientName);
		setBalance(clientBalance);
		logger = new Logger("matan");
	
	}
	// Adding an account to a Client(does not allow duplicate ID's)
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
				Logger logger;
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
			if(accountId==account[i].getId()){
				return String.format("%s \n" ,account[i]);
			}
		}	
		return "hehe";
	}
	// Removing an account by an account ID
	public void removeAccount(int id) {
		for(int i=0;i<account.length;i++) {
			if(id==account[i].getId()){
				balance += account[i].getBalance();
				logger = new Logger("");
				Log log = new Log(System.currentTimeMillis(), getCid(), "customer has deleted account id:" + account[i].getId());
				account[i]=null;
				return;
			}
			}

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
			Logger logger;
		}
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
	
	

}
