
public class Client {
	
	private int id;
	private String name;
	private float balance;
	private float comissionRate=0;
	private float  interestRate=0;
	private Logger logger;
	private Account account;

	
	public Client(int id, String name, float balance) {
		this.id = id;
		this.name = name;
		this.balance = balance;
		logger = 0;
	
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
