import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class GestioneFileBinari {
	
	public static Object leggiDati(String nomeFile) throws IOException, FileNotFoundException, ClassNotFoundException{
		Object app = null;
		ObjectInputStream leggiFile = null;
		try {
			leggiFile = new ObjectInputStream(new FileInputStream(nomeFile));
			app = leggiFile.readObject();
		}
		catch(Exception e) {
			throw e;
		}
		finally {
			leggiFile.close();
		}
		return app;
	}
	
	
	
	public static void salvaDati(Object obj, String nomeFile) throws IOException {
		ObjectOutputStream scriviFile = null;
		try {
			scriviFile = new ObjectOutputStream(new FileOutputStream(nomeFile));
			scriviFile.writeObject(obj);
		}
		catch(Exception e){
			throw e;
		}
		finally {
			scriviFile.close();
		}
	}
	
	
}
