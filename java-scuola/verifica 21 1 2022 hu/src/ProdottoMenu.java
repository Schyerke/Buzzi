
public abstract class ProdottoMenu {
	private String nome;
	private String descrizione;
	private double prezzo;
	
	public ProdottoMenu(String nome, String descrizione, double prezzo) {
		super();
		this.nome = nome;
		this.descrizione = descrizione;
		this.prezzo = prezzo;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	@Override
	public String toString() {
		return "ProdottoMenu [nome=" + nome + ", descrizione=" + descrizione + ", prezzo=" + prezzo + "]";
	}
	
	
	
	
}
