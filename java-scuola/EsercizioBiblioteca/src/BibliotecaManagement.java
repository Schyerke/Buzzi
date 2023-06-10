
import java.util.*;


public class BibliotecaManagement {
	
	private static BibliotecaManagement bibliotecaManagement;
	
	
	private ArrayList<Prestito> prestiti;
	private HashMap<String, Libro> libri;
	private TreeMap<String, Socio> soci;
	
	{
		prestiti = new ArrayList<Prestito>();
		libri = new HashMap<String, Libro>();
		soci = new TreeMap<String, Socio>();
	}
	
	
	private BibliotecaManagement () {
		
	}
	
	//interfacce pubbliche
	
	//singleton
	public static BibliotecaManagement getInstance() {
		if(bibliotecaManagement == null) {
			bibliotecaManagement = new BibliotecaManagement();
		}
		return bibliotecaManagement;
	}
	
	public boolean addPrestito(Socio socio, Libro libro) {
		for (var entry : libri.entrySet()) {
			if(entry.getValue().equals(libro)) {
				Prestito newPrestito = new Prestito(socio, libro);
				libri.remove(libro);
				prestiti.add(newPrestito);
				return true;
			}
		}
		return false;
	}
	
	public void addPrestito(Prestito prestito) {
		prestiti.add(prestito);
	}
	
	public boolean removePrestito(Prestito prestito) {
		if(prestiti.contains(prestito)) {
			prestiti.remove(prestito);
			return true;
		}
		else {
			return false;
		}
		
	}
	
	public void addLibro(Libro libro) {
		String isbnLibro = libro.getIsbn();
		libri.put(isbnLibro, libro);
	}
	
	public boolean removeLibro(Libro libro) {
		if(libri.containsKey(libro)) {
			libri.remove(libro);
			return true;
		}
		else {
			return false;
		}
	}
	
	
	public Libro ricercaLibroIsbn(String isbn) {
		if(libri.containsKey(isbn)) {
			return libri.get(isbn);
		}
		return null;
	}
	
	public Socio ricercaSocioCodiceFiscale(String codiceFisale) {
		if(soci.containsKey(codiceFisale)) {
			return soci.get(codiceFisale);
		}
		return null;
	}
	
	public void addSocio(Socio socio) {
		soci.put(socio.getCodiceFiscale(), socio);
	}
	
	public Socio verificaPrestitoLibro(Libro libro) {
		for (Prestito prestito : prestiti) {
			if(prestito != null) {
				if(prestito.getLibro().equals(libro)) {
					return prestito.getSocio();
				}
			}
		}
		return null;
	}
	
	public boolean restituzione(Libro libro) {
		for (Prestito prestito : prestiti) {
			if(prestito != null) {
				if(prestito.getLibro().equals(libro)) {
					prestiti.remove(libro);
					return true;
				}
			}
		}
		return false;
	}
	
	
	//interfacce private
	
	
}






