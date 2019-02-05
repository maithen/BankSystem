
public class WithdrawException extends Exception{
	
	
	private int clientId;
	private float currentBalance;
	private float withdrawAmount;
	
	public WithdrawException(String message, int clientId, float currentBalance, float withdrawAmount) {
		setClientId(clientId);
		setCurrentBalance(currentBalance);
		setWithdrawAmount(withdrawAmount);
		
		
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public float getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(float currentBalance) {
		this.currentBalance = currentBalance;
	}

	public float getWithdrawAmount() {
		return withdrawAmount;
	}

	public void setWithdrawAmount(float withdrawAmount) {
		this.withdrawAmount = withdrawAmount;
	}
	
	
	
}
