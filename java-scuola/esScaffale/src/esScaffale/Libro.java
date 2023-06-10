package esScaffale;

public class Libro {
	
	private String titolo;
	private String autore;
	private int numeroPagine;
	private double costoPagina = 0.05;
	private final double COSTO_FISSO = 5.5;
	
	//costruttore vuoto
	public Libro() {
		
	}

	//costruttore con gli attributi
	public Libro(String titolo, String autore, int numeroPagine, double costoPagina) {
		this.titolo = titolo;
		this.autore = autore;
		this.numeroPagine = numeroPagine;
		this.costoPagina = costoPagina;
	}
	
	//costruttore per solo il libro (gia fatto)
	public Libro(Libro libro) {
		
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getAutore() {
		return autore;
	}

	public void setAutore(String autore) {
		this.autore = autore;
	}

	public int getNumeroPagine() {
		return numeroPagine;
	}

	public void setNumeroPagine(int numeroPagine) {
		this.numeroPagine = numeroPagine;
	}

	public double getCostoPagina() {
		return costoPagina;
	}

	public void setCostoPagina(double costoPagina) {
		this.costoPagina = costoPagina;
	}

	public double getCOSTO_FISSO() {
		return COSTO_FISSO;
	}

	@Override
	public String toString() {
		return "Libro [titolo=" + titolo + ", autore=" + autore + ", numeroPagine=" + numeroPagine + ", costoPagina="
				+ costoPagina + ", COSTO_FISSO=" + COSTO_FISSO + "]";
	}
	
	
	
	
	
	
	
	
}
