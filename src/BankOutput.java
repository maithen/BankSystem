import java.awt.print.Printable;

import javax.swing.text.StyleContext.SmallAttributeSet;

public class BankOutput {

	public static void main(String[] args) {

		Bank bank = Bank.bank();
		
		System.out.println(Bank.bank().getBankName());
		
		
		
		Bank.bank().addClient(143, "rich guy #1", 346346364);
		
		bank.getClient(143).addAccount(444, 34634);
		bank.getClient(143).addAccount(4488, 344);
		bank.getClient(143).addAccount(7774, 634);
		
		System.out.println(bank.getClient(143));
		

		
		
		

	}

}
