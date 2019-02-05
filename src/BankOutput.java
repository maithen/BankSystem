import java.awt.print.Printable;

import javax.swing.text.StyleContext.SmallAttributeSet;

public class BankOutput {

	public static void main(String[] args) throws WithdrawException {

		Bank bank = Bank.bank();
		
		System.out.println(Bank.bank().getBankName());
		
		
		bank.addClient(143, "loki", 500);
		bank.addClient(143, "shimi", 500);
		bank.getClient(143).withdraw(600);
		System.out.println();
		System.out.println("client fortune " +bank.getClient(143).getFortune());
		System.out.println(bank.getTotalcommission());
		System.out.println("banks balance " +bank.getBalance());
		System.out.println(bank.getClient(143));
		

		bank.getClient(143).addAccount(444,500);
		bank.getClient(143).addAccount(466,500);

		System.out.printf("\n%s", bank.getClient(143).getAccounts());
		System.out.println("client balance is " + bank.getClient(143).getFortune());
		System.out.println("bank balance is " +bank.getBalance());

		try {
		System.out.printf("%s \n", bank.getClient(165).getAccounts());
		}catch (Exception e) {
			System.out.println("client does not exist");
		}
		


		

	}

}
