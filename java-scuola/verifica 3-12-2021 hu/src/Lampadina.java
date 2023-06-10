
public class Lampadina {
	private double quantitaLuceEmessaLm;
	private double potenzaAssorbitaWatt;
	
	private static final int MAX_CLICK = 6;
	private int contatoreClick;
	
	
	//tipologia o "led" o "tradizionale"
	private String tipologia;
	
	//dato dal rapporto lumen e potenza
	private double efficenzaLampada;
	
	
	//puo essere rotto, spento, o acceso. Inizalizzato a spento
	
	private String stato = StatiLamp.SPENTA;
	


	public Lampadina(double quantitaLuceEmessaLm, double potenzaAssorbitaWatt, String tipologia) {
		this.quantitaLuceEmessaLm = quantitaLuceEmessaLm;
		this.potenzaAssorbitaWatt = potenzaAssorbitaWatt;
		this.tipologia = tipologia;
	}
	
	
	//metodo click, return -1 se rotto, 0 se spento, 1 se acceso
	public int click() {
		contatoreClick++;
		if(contatoreClick >= MAX_CLICK) {
			//la lampada e' rotta
			stato = StatiLamp.ROTTA;
			return -1;
		}
		if(stato.equalsIgnoreCase(StatiLamp.ACCESA)) {
			stato = StatiLamp.SPENTA;
			return 0;
		}
		
		//altrimenti e' spenta, dunque lo si accende
		stato = StatiLamp.ACCESA;
		return 1;
		
	}
	
	
	//metodo per calcolare la efficenza della lampadina
	public double calcoloEfficenza(double quantitaLuceEmessaLm, double potenzaAssorbitaWatt) {
		this.efficenzaLampada = quantitaLuceEmessaLm / potenzaAssorbitaWatt;
		return efficenzaLampada; 
	}


	public double getQuantitaLuceEmessaLm() {
		return quantitaLuceEmessaLm;
	}


	public void setQuantitaLuceEmessaLm(double quantitaLuceEmessaLm) {
		this.quantitaLuceEmessaLm = quantitaLuceEmessaLm;
	}


	public double getPotenzaAssorbitaWatt() {
		return potenzaAssorbitaWatt;
	}


	public void setPotenzaAssorbitaWatt(double potenzaAssorbitaWatt) {
		this.potenzaAssorbitaWatt = potenzaAssorbitaWatt;
	}


	public int getContatoreClick() {
		return contatoreClick;
	}


	public void setContatoreClick(int contatoreClick) {
		this.contatoreClick = contatoreClick;
	}


	public String getTipologia() {
		return tipologia;
	}


	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}


	public double getEfficenzaLampada() {
		return efficenzaLampada;
	}


	public void setEfficenzaLampada(double efficenzaLampada) {
		this.efficenzaLampada = efficenzaLampada;
	}


	public String getStato() {
		return stato;
	}


	public void setStato(String stato) {
		this.stato = stato;
	}


	public static int getMaxClick() {
		return MAX_CLICK;
	}


	@Override
	public String toString() {
		return "Lampadina [quantitaLuceEmessaLm=" + quantitaLuceEmessaLm + ", potenzaAssorbitaWatt="
				+ potenzaAssorbitaWatt + ", contatoreClick=" + contatoreClick + ", tipologia=" + tipologia
				+ ", efficenzaLampada=" + efficenzaLampada + ", stato=" + stato + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
}
