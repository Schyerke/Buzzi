import java.util.Arrays;

public class Pizza extends ProdottoMenu{
	
	private String[] condimenti;
	
	
	public Pizza(String nome, String descrizione, double prezzo, String[] condimenti) {
		super(nome, descrizione, prezzo);
		
		this.condimenti = condimenti;
	}


	public String[] getCondimenti() {
		return condimenti;
	}


	public void setCondimenti(String[] condimenti) {
		this.condimenti = condimenti;
	}


	@Override
	public String toString() {
		return "Pizza [condimenti=" + Arrays.toString(condimenti) + "]";
	}
	
	
	
	
	
}
