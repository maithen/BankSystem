import java.awt.print.Printable;

import javax.swing.text.StyleContext.SmallAttributeSet;

public class BankOutput {

	public static void main(String[] args) {

		Bank bank = Bank.bank();
		
		System.out.println(Bank.bank().getBankName());
		
		
		bank.addClient(143, "loki", 1000);
		bank.getClient(143).withdraw(200);
		bank.getClients();
		
		System.out.println(bank.getClient(143).getFortune());
		System.out.println(bank.getTC());
		System.out.println(bank.getTC());
		System.out.println(bank.getBalance());
		

		

	}

}
