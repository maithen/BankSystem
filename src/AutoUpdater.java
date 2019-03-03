import java.util.ArrayList;

public class AutoUpdater implements Runnable{
	
	private ArrayList<Client> clientAc;
	
	public AutoUpdater(ArrayList<Client> clients) {
		
		this.clientAc = clients;
		
	}

	@Override
	public void run() {
		for(Client e: clientAc) {
			e.autoUpdateAccounts();
			
			
		}
		
	}

}
