package beans;

import java.io.Serializable;

public class DipendentiBean implements Serializable{
	private String cognome;
	private String nome;
	private int eta;
	private double oreLavorate;
	private double pagaOraria;
	
	public DipendentiBean() {
		
	}
	
	public DipendentiBean(String cognome, String nome, int eta, double oreLavorate, double pagaOraria) {
		this.cognome = cognome;
		this.nome = nome;
		this.eta = eta;
		this.oreLavorate = oreLavorate;
		this.pagaOraria = pagaOraria;
	}
	
	public String getCognome() {
		return cognome;
	}
	
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getEta() {
		return eta;
	}
	
	public void setEta(int eta) {
		this.eta = eta;
	}
	
	public double getOreLavorate() {
		return oreLavorate;
	}
	
	public void setOreLavorate(double oreLavorate) {
		this.oreLavorate = oreLavorate;
	}
	
	public double getPagaOraria() {
		return pagaOraria;
	}
	
	public void setPagaOraria(double pagaOraria) {
		this.pagaOraria = pagaOraria;
	}
	
	public double pagaGiornaliera(double pagaOraria, double oreLavorate) {
		double pagaGiornaliera = pagaOraria * oreLavorate;
		return pagaGiornaliera;
	}

}
