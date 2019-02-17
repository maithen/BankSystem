
public class Gold_Client extends Client {



	public Gold_Client(int clientId, String clientName, float clientBalance) {
		super(clientId, clientName, clientBalance, (float)(0.02),(float)(0.003) );

	}

	@Override
	public String toString() {
		return String.format(
				"Gold Client [Accounts=%s], Fortune=%s, Client ID=%s, Client's Name=%s, Client's Balance=%s, Client's CommissionRate=%s, Client's InterestRate=%s]",
				getAccounts(), getFortune(), getCid(), getName(), getBalance(), getCommissionRate(), getInterestRate());
	}

	
}
