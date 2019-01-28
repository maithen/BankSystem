
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
	
	public void setBalance(float balance) {
		this.balance=balance;
		//Logger logger = new Logger(c:\matan);
		//Log log = new Log(System.currentTimeMillis(), setCid() , "set balance");
		//logger.log(log);
		
	}


	
	

}
