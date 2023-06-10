
public abstract class DatiCercatiDalNome {
	
	private String nome;
	private String desc;
	private double prezzo;
	public DatiCercatiDalNome(String nome, String desc, double prezzo) {
		super();
		this.nome = nome;
		this.desc = desc;
		this.prezzo = prezzo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	@Override
	public String toString() {
		return "DatiCercatiDalNome [nome=" + nome + ", desc=" + desc + ", prezzo=" + prezzo + "]";
	}
	
	
	
	
}
