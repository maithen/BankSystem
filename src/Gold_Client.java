
public class Gold_Client extends Client {

	public  Gold_Client(int clientId, String clientName, float clientBalance) {
		super(clientId, clientName, clientBalance);
	
		setCommissionRate(2/100);
		setInterestRate(3/1000);
	
		
	}

	@Override
	public String toString() {
		return String.format("Gold Client. \n");
	}

	
}
