
public class Account {

	private int id;
	private float balance;
	private Logger logger;
	
	public Account(int id, float balance) {
			this.id=id;
		this.balance=balance;
	}
	
	public int getId() {
		return id;
	}

	public float getBalance() {
		return balance;
	}
	
	public void setBalance(float balance) {
		this.balance=balance;
		Log log = new Log(System.currentTimeMillis(), getId() , "Client set an Account Balance", balance);
		logger.log(log);
		
	}

	@Override
	public String toString() {
		return String.format("Account [id=%s, balance=%s]", id, balance);
	}

	
	


	
	

}
