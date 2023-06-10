import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TextFile  {
	private char mode;
	private BufferedReader reader;
	private BufferedWriter writer;
	
	public TextFile(String filename, char mode) throws IOException {
		this.mode = 'R';
		if (mode == 'W' || mode == 'w') {
			this.mode = 'W';
			writer = new BufferedWriter(new FileWriter(filename));
		}
		else {
			reader = new BufferedReader(new FileReader(filename));
		}
	}
	
	public void toFile (String line) throws FileException, IOException {
		if(this.mode == 'R' || this.mode == 'r') {
			throw new FileException("Solo scrittura");
		}
		System.out.println(line);
		writer.write(line);
		writer.newLine();
	}
	
	public String fromFile() throws FileException, IOException{
		String tmp;
		if(this.mode == 'w' || this.mode == 'W') {
			throw new FileException("Solo lettera");
		}
		tmp = reader.readLine();
		if(tmp == null) {
			throw new FileException("Fine riga");
		}
		return tmp;
	}

	public void closeFile() throws IOException {
		if(this.mode == 'R' || this.mode == 'r') {
			reader.close();
		}
		else {
			writer.close();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
