import java.io.Serializable;

public class Account implements Serializable {

	private int id;
	private float balance;
	
	
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
		Logger.log(log);
		
	}

	@Override
	public String toString() {
		return String.format("[id=%s, balance=%s]", id, balance);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Account other = (Account) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	

	
	


	
	

}
