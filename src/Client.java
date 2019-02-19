import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Client implements Serializable {
	
	private int cid;
	private String name;
	private float balance;
	protected final float commissionRate;
	protected final float interestRate;
	private List<Account> accounts = new ArrayList();
	
	
	
	public Client(int clientId, String clientName, float clientBalance, float cr, float ir) {
		this.commissionRate = cr;
		this.interestRate = ir;
		setCid(clientId);
		setName(clientName);
		setBalance(clientBalance);
		
	
	}
	

	// Adding an account to a Client(does not allow duplicate IDs)
	public void addAccount(int id, float balance) {
		for(Account e : accounts) {
			if (e!=null && id==e.getId()){
				System.out.printf("Account ID: %d already exists. pick a new ID to create an account. \n", e.getId());
				return;
			}
		}	
	
			
				accounts.add(new Account(id,balance));
				Log log = new Log(System.currentTimeMillis(), getCid(), String.format("Account ID: %d has been added to Client.",id), balance);
				Logger.log(log);
				return;
					}
				
	// Getting all Accounts.
	public String getAccounts(){
		String gA = "";
		for(Account e : accounts) {
				gA +=  String.format("%s, ", e);
			}
	
		
		if(gA!= "") {
		return String.format("%s",gA);
		}else {
			gA = "Client has no accounts";
			return gA;
		}
	}
	
	// Getting Account details by an account ID
	public String getAccount(int accountId) {
		for(Account e : accounts) {		
			if(e!=null && accountId==e.getId()){
				return String.format("%s \n" ,e);
			}
		}	
		return String.format("Account ID: %d does not exist.", accountId);
	}
	
	// Removing an account by an account ID
	public void removeAccount(int accountID) {
		for(Account e : accounts) {
			if(e!=null && e.getId()==accountID){
				balance += e.getBalance();
				Log log = new Log(System.currentTimeMillis(), getCid(), String.format("Client has deleted Account ID: %d", e.getId()), e.getBalance());
				Logger.log(log);
				e=null;
				return;
			}
			}
		System.out.printf("Account: %s does not exist. thus cannot be removed. \n", accountID);
		}
	
	// Making a deposit to a Client.
	public void deposit(float dp) {
		
		balance += dp-(dp*getCommissionRate());
		Bank.updateTotalCommission(dp*getCommissionRate());
		
	}
	
	// Making a withdraw from a Client.
	public void withdraw(float amount) throws WithdrawException{
		
		if((amount+ (amount*getCommissionRate()))> getBalance()) {
			throw new WithdrawException("Cannot withdraw money, insufficient funds", getCid(), getBalance(), amount);
		}else {
		balance -=(amount+(amount*getCommissionRate()));
		Bank.updateTotalCommission(amount*getCommissionRate());
	}
	}
	
	// Auto-updating the amount of interest to add on each Client's accounts
	public void autoUpdateAccounts() {
		for(Account e : accounts) {
			 e.setBalance((e.getBalance()+ (e.getBalance()*getInterestRate())));
		}
		Log log = new Log(System.currentTimeMillis(), getCid(), "Interest added to the Client's Account balance", getInterestRate());
		Logger.log(log);
		}
	
	// Returning the sum of a client balance + total accounts balance.
	public float getFortune() {
		float sum=0;
		for(Account e : accounts) {
			if(e!=null) {
			sum+=e.getBalance();
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
	public float getInterestRate() {
		return interestRate;
	}


	@Override
	public String toString() {
		return String.format(
				"Client [ID=%s, Name=%s, Balance=%s, comissionRate=%s, interestRate=%s,]\n%s's Accounts=%s] \n", cid,
				name, balance, commissionRate, interestRate,name, accounts);
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
