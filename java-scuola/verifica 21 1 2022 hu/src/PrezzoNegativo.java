
public class PrezzoNegativo extends Exception{
	
	public PrezzoNegativo(String msg) {
		super(msg);
	}
	
	public PrezzoNegativo() {
		super("Prezzo negativo, non valida");
	}
}
