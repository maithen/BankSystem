
public class Client {
	
	private int cid;
	private String name;
	private float balance;
	private float comissionRate=0;
	private float  interestRate=0;;
	private Logger logger;
	Account[] account = new Account[5];

	// Adding an account to a Client
	public void addAccount(int id, float balance) {
		for(int i=0;i<account.length;i++) {
			if(account[i]==null) {
			account[i]= new Account(id,balance);
			Logger logger;
			break;
			}
		
	}
	}
	// Getting Account details by an account ID
	public void getAccount(int id) {
		for(int i=0;i<account.length;i++) {
			if(id==account[i].getId()){
			System.out.printf("account id : %s has a balance of %s \n", account[i].getId(),account[i].getBalance());
			return;
			}
			}
			System.out.println("does not exist!");
			return;
		}
	// Removing an account by an account ID
	public void removeAccount(int id) {
		for(int i=0;i<account.length;i++) {
			if(id==account[i].getId()){
				System.out.println("Account Deleted.");
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
	// Auto updating the amount of interest to add on each Client's accounts
	public void autoUpdateAccounts() {
		for(int i=0;i<account.length;i++) {
			account[i].getBalance()  
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
	

	public Client(int id, String name, float balance) {
		setCid(id);
		setName(name);
		setBalance(balance);
		Logger logger;
	
	}
	
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
