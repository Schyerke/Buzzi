
public class BevandaNonEsistente extends Exception{
	
	public BevandaNonEsistente(String msg) {
		super(msg);
	}
	
	public BevandaNonEsistente() {
		super("Bevanda non esistente");
	}
	
	
}
