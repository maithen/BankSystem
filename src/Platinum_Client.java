
public class Platinum_Client extends Client {
	

		
	public Platinum_Client(int clientId, String clientName, float clientBalance) {
		super(clientId, clientName, clientBalance, (float)0.001, (float)0.0005);
		

	}



	@Override
	public String toString() {
		return String.format("Platinum Client. \n");
	}
	
	

}
