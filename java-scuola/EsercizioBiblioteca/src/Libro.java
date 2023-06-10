import java.util.Objects;

public class Libro {
	private String titolo;
	private String isbn;
	public Libro(String titolo, String isbn) {
		this.titolo = titolo;
		this.isbn = isbn;
	}
	
	public String getTitolo() {
		return this.titolo;
	}
	
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	
	public String getIsbn() {
		return this.isbn;
	}
	
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	
	
	
	@Override
	public int hashCode() {
		return Objects.hash(isbn, titolo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libro other = (Libro) obj;
		return Objects.equals(isbn, other.isbn) && Objects.equals(titolo, other.titolo);
	}
	
	
	

	@Override
	public String toString() {
		return "Libro [titolo=" + titolo + ", isbn=" + isbn + "]";
	}
	
	
	
	
}
