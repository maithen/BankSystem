import java.awt.print.Printable;
import java.io.IOException;

import javax.swing.text.StyleContext.SmallAttributeSet;

public class BankOutput {

	public static void main(String[] args) throws WithdrawException, IOException {

		Bank bank = Bank.bank();
		System.out.println(Bank.bank().getBankName());
		System.out.println(bank.getClients());
		System.out.println(bank.getTotalcommission());
		System.out.println(bank.getBalance());
	}

}
