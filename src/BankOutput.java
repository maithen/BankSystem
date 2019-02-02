import java.awt.print.Printable;

import javax.swing.text.StyleContext.SmallAttributeSet;

public class BankOutput {

	public static void main(String[] args) {

		Bank bank = Bank.bank();
		
		System.out.println(Bank.bank().getBankName());
		
		
		bank.addClient(143, "loki", 40);
		bank.getClient(143).withdraw(500);
	
		
		bank.getClient(143).addAccount(444, 34634);
		bank.getClient(143).addAccount(4488, 344);
		bank.getClient(143).addAccount(7774, 634);
		
		System.out.println(bank.getClient(143));
		System.out.println(bank.getClients());
		
		bank.addClient(405, "ama", 294);
		
		System.out.println(bank.getClient(405));
		

	}

}
