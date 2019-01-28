
public class Logger {
	
	private String driverName;

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public Logger(String driverName) {
		this.driverName = driverName;
	}
	
	public void log (Log log) { 

		System.out.println(log.getData());
		
	}
	
	

}
