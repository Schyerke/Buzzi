
public class Bevande extends ProdottoMenu{
	
	private final String TIPOLOGIA;
	
	public Bevande(String nome, String descrizione, double prezzo, String tipologia) {
		super(nome, descrizione, prezzo);
		this.TIPOLOGIA = tipologia;
	}

	public String getTIPOLOGIA() {
		return TIPOLOGIA;
	}

	@Override
	public String toString() {
		return "Bevande [TIPOLOGIA=" + TIPOLOGIA + "]";
	}
	

}
