import java.awt.print.Printable;

import javax.swing.text.StyleContext.SmallAttributeSet;

public class BankOutput {

	public static void main(String[] args) {

		// Client Moshe = new Client(1545, "Moshe", 345435, 444, 234);
		// System.out.println(Moshe);

		Log l12 = new Log(System.currentTimeMillis(), 1234, "set balance");

		Bank bank = new Bank();
		
		bank.addClient(345, "moshe", 555);
		
		System.out.println(bank.clients[0].getName());
		System.out.println(bank.getBalance());
		
		bank.clients[0].addAccount(333, 444);
		
		System.out.println(bank.clients[0].getName());
		System.out.println("bank fortune is "  +bank.getBalance());
		
		
	
		
		
		System.out.println(bank.getClients());
		
		
		
		
	//	System.out.println(bank.moshe]);
		
		
//		moshe.addAccount(444, 180);
//		System.out.println(moshe.getFortune());
//		moshe.addAccount(333, 120);
//		moshe.removeAccount(333);
//		moshe.getFortune();
//		System.out.println(moshe.getFortune());


	}

}
