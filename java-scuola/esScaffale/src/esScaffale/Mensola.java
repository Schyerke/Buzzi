package esScaffale;

import java.util.Arrays;

public class Mensola {
	private static final int NUM_MAX_VOLUMI = 15;
	private Libro[] volumi = new Libro[NUM_MAX_VOLUMI];
	
	
	
	public Mensola() {
		
		
	}
	
	// set con posizione libro, return 1 se fatto con successo, -1 altrimenti
	public int setVolume(Libro libro, int posizione) {
		if(volumi[posizione] == null) {
			return -1;
		}
		volumi[posizione] = libro;
		return 1;
	}
	
	//get volume da posizione
	public Libro getVolume(int posizione) {
		if(volumi[posizione] == null) {
			return null;
		}
		return volumi[posizione];
	}
	
	//rimuovi volume dato posizione || return 1 se fatto con successo, -1 se e' vuoto
	public int rimuoviVolume(int posizine) {
		if(volumi[posizine] == null) {
			return -1;
		}
		volumi[posizine] = null;
		return 1;
	}
	
	//return num massimi di volume
	public int getNumMaxVolume() {
		return NUM_MAX_VOLUMI;
	}
	
	//retrun numeri di volume
	public int getNumVolume() {
		int volumi = 0;
		for(Libro libro : this.volumi) {
			if(libro != null) {
				volumi++;
			}
		}
		return volumi;
	}

	@Override
	public String toString() {
		return "Mensola [volumei=" + Arrays.toString(volumi) + "]";
	}
	
	
	
	
}
