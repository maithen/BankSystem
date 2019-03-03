import java.util.ArrayList;

public class AutoUpdater implements Runnable{
	boolean flag = true;
	private ArrayList<Client> clientAc;
	
	public AutoUpdater(ArrayList<Client> clients) {
		
		this.clientAc = clients;
		
	}

	@Override
	public void run() {
		while(flag) {
		for(Client e: clientAc) {
			e.autoUpdateAccounts();
			
			
		}
		try {
			Thread.sleep(60*24*24*1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		}
		
		
	}

}
