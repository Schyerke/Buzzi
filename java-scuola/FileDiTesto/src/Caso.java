import java.io.Serializable;

public class Caso implements Serializable{
	private String nomeString;
	private String datiString;
	public Caso(String nomeString, String datiString) {
		super();
		this.nomeString = nomeString;
		this.datiString = datiString;
	}
	public String getNomeString() {
		return nomeString;
	}
	public void setNomeString(String nomeString) {
		this.nomeString = nomeString;
	}
	public String getDatiString() {
		return datiString;
	}
	public void setDatiString(String datiString) {
		this.datiString = datiString;
	}
	@Override
	public String toString() {
		return "Caso [nomeString=" + nomeString + ", datiString=" + datiString + "]";
	}
	
}
