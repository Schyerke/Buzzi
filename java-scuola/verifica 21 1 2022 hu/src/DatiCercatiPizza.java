import java.util.Arrays;

public class DatiCercatiPizza extends DatiCercatiDalNome{
	

	private String[] condimenti;
	
	public DatiCercatiPizza(String nome, String desc, double prezzo, String[] condimenti) {
		super(nome, desc, prezzo);
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
		
		String app = super.toString();
		app += "[condimenti=" + Arrays.toString(condimenti) + "]";
		return app;
		
	}
	
	
	
	
}
