
public class DatiCercatiBevanda extends DatiCercatiDalNome{
	
	private String tipologia;
	
	public DatiCercatiBevanda(String nome, String desc, double prezzo, String tipologia) {
		super(nome, desc, prezzo);
		this.tipologia = tipologia;
	}

	public String getTipologia() {
		return tipologia;
	}

	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}

	@Override
	public String toString() {
		String app = super.toString();
		app += "[tipologia=" + tipologia + "]";
		return app;
				
				
	}
	
	
	
	
}
