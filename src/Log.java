import java.util.Date;

public class Log {
	
	
	private Date date;
	private int clientId;
	private String description;
	private float amount;
	
	
	

	public Log(long timestamp, int clientId, String description, float amount) {
		
		this.date = new Date(timestamp);
		this.clientId = clientId;
		this.description = description;
		this.amount = amount;
		
	}
	
	
	// Prints the log
	public String toString() {	
		return  String.format("Time: %s, Client ID: %d, Description: '%s', Amount: %f. ",date, clientId, description, amount);
	}
	

	}
	
	
	
	


