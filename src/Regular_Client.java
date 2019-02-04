
public class Regular_Client extends Client {

	public Regular_Client(int clientId, String clientName, float clientBalance) {
		super(clientId, clientName, clientBalance, ((float)0.0300), ((float)0.00100));

		
	}

	@Override
	public String toString() {
		return String.format("Regular Client. \n");
	}

	
}
