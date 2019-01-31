

public class Log {
	
	private long timestamp;
	private int clientId;
	private String description;
	private float amount;
	
	
	

	public Log(long timestamp, int clientId, String description, float amount) {
		
		this.timestamp = timestamp;
		this.clientId = clientId;
		this.description = description;
		this.amount = amount;
	}
	
	// Prints the log
	public String getData() {
		return  String.format("Time: %s, Client ID: %d, Description: '%s', Amount: %f. ",timestamp, clientId, description, amount);
	}
	
	@Override
	public String toString() {
		return String.format("Log [timestamp=%s, clientId=%s, description=%s, amount=%s]", timestamp, clientId,
				description, amount);
	}
	
	
	
	

}
