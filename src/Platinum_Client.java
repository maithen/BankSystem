
public class Platinum_Client extends Client {
	

		
	public Platinum_Client(int clientId, String clientName, float clientBalance) {
		super(clientId, clientName, clientBalance, (1/100), (5/1000));
		

	}



	@Override
	public String toString() {
		return String.format("Platinum Client. \n");
	}
	
	

}
