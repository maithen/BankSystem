
public class Regular_Client extends Client {

	public Regular_Client(int clientId, String clientName, float clientBalance) {
		super(clientId, clientName, clientBalance);
		
		setCommissionRate(2/100);
		setInterestRate(3/1000);
	}

	@Override
	public String toString() {
		return String.format("Regular []");
	}

	
}
