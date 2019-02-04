
public class Gold_Client extends Client {



	public Gold_Client(int clientId, String clientName, float clientBalance) {
		super(clientId, clientName, clientBalance, (float)(0.02),(float)(0.003) );

	}

	@Override
	public String toString() {
		return String.format("Gold Client. \n");
	}

	
}
