package model;

import javax.swing.plaf.basic.BasicFormattedTextFieldUI;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class PortaCD {
	private CD[] cd = new CD[100];
	private int lunghezza;
	private StringProperty nomeProperty = new SimpleStringProperty();
	
	//costruttore
	
	
	public PortaCD(int lunghezza, String nome) {
		this.nomeProperty.set(nome);
		this.lunghezza = lunghezza;
	}


	
	
	public PortaCD() {
	}
	
	
	// get set
	
	public String getNome() {
		return nomeProperty.get();
	}
	
	public void setNome(String nome) {
		this.nomeProperty.set(nome);
	}
	
	public StringProperty getNomeProperty() {
		return this.nomeProperty;
	}
	
	
	//metodi dell'esericizio
	
	public CD getCd(int index) {
		/*
		try {
			return cd[index];
		} catch (NullPointerException e) {
			return null;
		}
		*/
		
		if(cd[index] == null) {
			return null;
		}
		return cd[index];
		
	}
	
	public void setCd(int index, CD cd) {
		if(this.cd[index] == null) {
			return;
		}
		this.cd[index] = cd;
	}
	
	public void killCd(int index) {
		if(cd[index] == null) {
			return;
		}
		cd[index] = null;
	}
	
	public CD[] getN() {
		int index = 0;
		for(CD oneCd : cd) {
			if(oneCd != null) {
				index++;
			}
		}
		CD[] cdNonNull = new CD[index];
		index = 0;
		for(CD oneCd : cd) {
			if(oneCd != null) {
				cdNonNull[index++] = oneCd;
			}
		}
		return cdNonNull;
	}
	
	public int cercaCdPerTitolo(CD cdDaCercare) {
		for(int i = 0; i < cd.length; i++) {
			if(cd[i].getTitolo().equalsIgnoreCase(cdDaCercare.getTitolo())) {
				return i;
			}
		}
		return -1;
	}
	
	public static int confrontaCollezione(PortaCD collezione1, PortaCD collezione2) {
		int numeroInComune = 0;
		String[] collezione1Titoli = collezione1.toString().split("\n");
		String[] collezione2Titoli = collezione1.toString().split("\n");
		for(String titoloCollezione1 : collezione1Titoli) {
			for(String titoloCollezione2 : collezione2Titoli) {
				if(titoloCollezione1.equalsIgnoreCase(titoloCollezione2)) {
					numeroInComune++;
				}
			}
		}
		return numeroInComune;
	}

	
	// to string

	@Override
	public String toString() {
		String titoliCd = "";
		for(CD oneCd : cd) {
			if(oneCd != null) {
				titoliCd += oneCd.getTitolo() + "\n";
			}
		}
		return titoliCd;
	}
	
	
	
	
	
}
