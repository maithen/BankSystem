
public class Account {

	private int id;
	private float balance;
	
	public Account(int id, float balance) {
			super();
			this.id=id;
		setBalance(balance);
	}
	
	public int getId() {
		return id;
	}

	public float getBalance() {
		return balance;
	}
	//unresolved for now, I do not understand.
	public void setBalance(float balance) {
		this.balance=balance;
		Log log = new Log(System.currentTimeMillis(), getId() , "Client set an Account Balance");
		//Logger.log(log);
		
	}

	
	
	@Override
	public String toString() {
		return "Account Id : " + id + ", Balance : " + balance + "";
	}


	
	

}
