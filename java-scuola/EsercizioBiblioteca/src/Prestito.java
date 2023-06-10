
public class Prestito {
	private Socio socio;
	private Libro libro;
	
	public Prestito(Socio socio, Libro libro) {
		this.socio = socio;
		this.libro = libro;
	}

	public Socio getSocio() {
		return socio;
	}

	public void setSocio(Socio socio) {
		this.socio = socio;
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	@Override
	public String toString() {
		return "Prestito [socio=" + socio + ", libro=" + libro + "]";
	}
	
	
	
}
