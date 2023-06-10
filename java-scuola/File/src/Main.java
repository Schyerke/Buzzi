import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		
		//Caso e' una classe privo di senso, usato per testare la classe GestioneFileBinari
		Caso caso1 = new Caso("ugo", "o");
		Caso caso2 = new Caso("ugo1", "2o");
		Caso caso3 = new Caso("ugo2", "o2");
		
		ArrayList<Caso> casi = new ArrayList<Caso>();
		casi.add(caso3);
		casi.add(caso2);
		casi.add(caso1);
		
		try {
			GestioneFileBinari.salvaDati(casi, "casi.bin");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("dati salvati");
		ArrayList<Caso> copiaCasi = new ArrayList<Caso>();
		try {
			copiaCasi = (ArrayList<Caso>)(GestioneFileBinari.leggiDati("casi.bin"));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(copiaCasi.toString());
		
		
		
		
		
	}
}
