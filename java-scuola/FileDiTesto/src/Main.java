import java.io.IOException;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) throws Exception {
	 //Caso e' una classe privo di senso, usato per testare la classe TextFile
		Caso caso1 = new Caso("ugo", "o");
		Caso caso2 = new Caso("ugo1", "2o");
		Caso caso3 = new Caso("ugo2", "o2");
		
		ArrayList<Caso> casi = new ArrayList<Caso>();
		casi.add(caso3);
		casi.add(caso2);
		casi.add(caso1);
		
		TextFile out = new TextFile("casi.csv", 'W');
		
		try{
			for(int i = 0; i < casi.size(); i++) {
				if(casi.get(i) != null) {
					String line = Integer.toString(i);
					line += ";" + casi.get(i).getNomeString();
					line += ";" + casi.get(i).getDatiString();
					out.toFile(line);
				}
			}
		}
		catch (Exception e) {
			System.err.println(e.getMessage());
		}
		out.closeFile();
		System.out.println("dati salvati");
		
		System.out.println();
		System.out.println();
		
		TextFile in = new TextFile("casi.csv", 'R');
		try {
			while(true) {
				String line = in.fromFile();
				String[] elementi = line.split(";");
				System.out.println("1: " + elementi[0]);
				System.out.println("2: " + elementi[1]);
				System.out.println("3: " + elementi[2]);
				System.out.println();
			}
		}
		catch (Exception e) {
			System.err.println(e.getMessage());
		}
		out.closeFile();
		System.out.println();
		System.out.println("dati letti");
		
		
	}
}
