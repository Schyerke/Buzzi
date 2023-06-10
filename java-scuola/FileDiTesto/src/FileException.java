
public class FileException extends Exception{
	private String messaggio;
	public FileException() {
		super("file errore");
	}
	
	public FileException(String messaggio) {
		super(messaggio);
	}
	public String getMessaggio() {
		return this.messaggio;
	}
}
