import java.awt.print.Printable;

import javax.swing.text.StyleContext.SmallAttributeSet;

public class BankOutput {

	public static void main(String[] args) throws WithdrawException {

		Bank bank = Bank.bank();
		
		System.out.println(Bank.bank().getBankName());
		
		
		bank.addClient(143, "loki", 500);
		
		bank.getClient(143).withdraw(500);
System.out.println(bank.getClient(143).getBalance());

		

	}

}
