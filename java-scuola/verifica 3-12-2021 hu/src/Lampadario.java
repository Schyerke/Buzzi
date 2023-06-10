import java.util.Arrays;

public class Lampadario {
	private final int MIN_NUM_LAMPADINE = 1;
	private final int MAX_NUM_LAMPADINE = 5;
	private final String tipologiaLampadario;
	
	private Lampadina[] lampadine;
	private int numeroLampadine;
	
	//stato del lampadario, spenta di default
	private String statoLampadario = StatiLamp.SPENTA;
	
	
	
	public Lampadario(int numeroLampadine, String tipologiaLampadario) {
		this.numeroLampadine = numeroLampadine;
		lampadine = new Lampadina[numeroLampadine];
		this.tipologiaLampadario = tipologiaLampadario;
	}
	
	
	
	
	//metodo click per cambiare di stato alla lampadario (alle lampadine quindi)
	public void click() {
		for (int i = 0; i < lampadine.length; i++) {
			
			
			
			int risultatoClick = lampadine[i].click();
			
			if(this.tipologiaLampadario.equals(TipologiaLampadario.PARALLELA)) {
				if(risultatoClick == -1) {
					this.statoLampadario = StatiLamp.ROTTA;
				}
			} 
			
			//altrimenti e' serie
			
			switch(risultatoClick) {
			case 1:{
				System.out.println("la lampadina " + i + " si e' accesa");
				this.statoLampadario = StatiLamp.ACCESA;
				break;
			}
			case 0:{
				System.out.println("la lampadina " + i + " si e' spenta");
				this.statoLampadario = StatiLamp.SPENTA;
				break;
			}
			case -1:{
				System.out.println("la lampadina " + i + " si e' rotta");
				this.statoLampadario = StatiLamp.ROTTA;
				break;
			}
			}
		}
	}




	public Lampadina[] getLampadine() {
		return lampadine;
	}




	public void setLampadine(Lampadina lampadina, int posizione) {
		if(lampadine[posizione] != null) {
			return;
		}
		this.lampadine[posizione] = lampadina;
	}




	public int getNumeroLampadine() {
		return numeroLampadine;
	}




	public void setNumeroLampadine(int numeroLampadine) {
		this.numeroLampadine = numeroLampadine;
	}




	public String getStatoLampadario() {
		return statoLampadario;
	}




	public void setStatoLampadario(String statoLampadario) {
		this.statoLampadario = statoLampadario;
	}




	public int getMIN_NUM_LAMPADINE() {
		return MIN_NUM_LAMPADINE;
	}




	public int getMAX_NUM_LAMPADINE() {
		return MAX_NUM_LAMPADINE;
	}




	public String getTipologiaLampadario() {
		return tipologiaLampadario;
	}




	@Override
	public String toString() {
		return "Lampadario [MIN_NUM_LAMPADINE=" + MIN_NUM_LAMPADINE + ", MAX_NUM_LAMPADINE=" + MAX_NUM_LAMPADINE
				+ ", tipologiaLampadario=" + tipologiaLampadario + ", lampadine=" + Arrays.toString(lampadine)
				+ ", numeroLampadine=" + numeroLampadine + ", statoLampadario=" + statoLampadario + "]";
	}
	
	
	
}
