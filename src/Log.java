
public class Log {
	
	private long timestamp;
	private int clientId;
	private String description;
	
	
	public Log(long timestamp, int clientId , String description) {
		this.timestamp = timestamp;
		this.clientId = clientId;
		this.description = description;
		

	}
	
	public String getData() {
		return String.format(" Time : %s, Client ID : %d, Description : %s .",timestamp, clientId, description);
	}
	


	@Override
	public String toString() {
		return "Log [timestamp=" + timestamp + ", clientId=" + clientId + ", description=" + description + "]";
	}
	
	
	
	

}
