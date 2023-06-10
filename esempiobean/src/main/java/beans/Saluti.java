package beans;

import java.io.Serializable;
import java.util.GregorianCalendar;

public class Saluti implements Serializable {
	private String message;
	
	public Saluti() {
		
	}
	
	public Saluti(String message) { 
		this.message = message;
	}
	
	public String getMessage() {
		GregorianCalendar dataAttuale = new GregorianCalendar();
		int ore = dataAttuale.get(GregorianCalendar.HOUR_OF_DAY);
		if(ore < 12) {
			message = "Buongiorno e' mattina";
		} else if (ore < 17) {
			message = "Buon pomeriggio";
		} else {
			message = "Buona serata";
		}
		return this.message;
	}
	
	public void setMessage(String message) { 
		this.message = message;
	}
	
	
}
