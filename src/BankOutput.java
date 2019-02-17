import java.awt.print.Printable;

import javax.swing.text.StyleContext.SmallAttributeSet;

public class BankOutput {

	public static void main(String[] args) throws WithdrawException {

		Bank bank = Bank.bank();
		
		System.out.println(Bank.bank().getBankName());
		
		
		bank.addClient(143, "loki", 500);
		bank.addClient(145, "thor", 5550);
		bank.getClient(143).addAccount(550, 300);
		bank.getClient(143).addAccount(560, 300);
		
		System.out.println(bank.getClient(143));
		System.out.println(bank.getClient(145));

		

	}

}
