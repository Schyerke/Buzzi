package controller;

public class DatiInputUtente {
	private String nome;
	private int lunghezza;
	private int lunghezzaCd;
	
	public DatiInputUtente(String nome, int lunghezza, int lunghezzaCd) {
		this.lunghezzaCd = lunghezzaCd;
		this.nome = nome;
		this.lunghezza = lunghezza;
	}
	
	public DatiInputUtente() {
		
	}
	
	public void setLunghezzaCd(int lunghezzaCd) {
		this.lunghezzaCd = lunghezzaCd;
	}
	
	public int getLunghezzaCd() {
		return lunghezzaCd;
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getLunghezza() {
		return lunghezza;
	}
	public void setLunghezza(int lunghezza) {
		this.lunghezza = lunghezza;
	}
	
	
	@Override
	public String toString() {
		return "DatiInputUtente [nome=" + nome + ", lunghezza=" + lunghezza + "]";
	}
	
	
	
	
}
