import java.lang.reflect.UndeclaredThrowableException;
import java.util.Scanner;

public class MainMenu {
	
	private BibliotecaManagement bibliotecaManagement;
	private Scanner scanner = new Scanner(System.in);
	
	{
		bibliotecaManagement = BibliotecaManagement.getInstance();
		
		
		
	}
	
	{
		start();
	}
	
	
	public void start() {
		
		boolean ok = true;
		boolean okInput = true;
		
		int userInput = -1;
		
		
		do {
			printMenu();
			do {
				System.out.println("Inserisci una scelta: ");
				try {
					userInput = Integer.parseInt(scanner.nextLine());
					if(userInput < 0 || userInput >= 8) {
						throw new IllegalArgumentException("Numero invalido");
					}
					else {
						okInput = true;
					}
				} catch (IllegalArgumentException e) {
					System.out.println(e.getMessage());
					okInput = false;
				}
				
			} while (!okInput);
			
			
			
			
			
			switch (userInput) {
			
			case 0: {
				System.out.println("programma chiuso");
				ok = false;
				break;
			}
			
			case 1: 
				//ricerca dei dati di un libro a partire dal proprio codice ISBN
				System.out.println("insersici l'isbn di un libro");
				String userStringIsbn = scanner.nextLine();
				
				Libro libroTrovato = bibliotecaManagement.ricercaLibroIsbn(userStringIsbn);
				if(libroTrovato == null) {
					System.out.println("Libro non esistente con tale isbn");
				}
				else {
					System.out.println("Libro trovato: " + libroTrovato);
				}
				break;
			
			case 2: {
				//ricerca dei dati di un socio a partire dal proprio codice fiscale
				System.out.println("Inserisci un codice fiscale: ");
				String codiceFiscaleUser = scanner.nextLine();
				Socio socioTrovato = bibliotecaManagement.ricercaSocioCodiceFiscale(codiceFiscaleUser);
				if(socioTrovato == null) {
					System.out.println("nessun socio trovato");
				}
				else {
					System.out.println("Socio trovato: " + socioTrovato);
				}
				
				
				break;
			}
			case 3: {
				//verifica del prestito di un libro con indicazione dei dati del socio che lo ha preso
				Libro libro = newLibro();
				Socio socioTrovato = bibliotecaManagement.verificaPrestitoLibro(libro);
				if(socioTrovato == null) {
					System.out.println("Nessun prestito trovato");
				}
				else {
					System.out.println("Socio trovato: " + socioTrovato);
				}
				break;
			}
			
			case 4: {
				//memorizzazione di un nuovo prestito
				Prestito prestito = newPrestito();
				bibliotecaManagement.addPrestito(prestito);
				System.out.println("Prestito aggiunto");
				break;
			}
			
			case 5: {
				//restituzione di un libro
				
				System.out.println("Inserisci i dati del libro da restituire");
				Libro libro = newLibro();
				
				Boolean trovato = bibliotecaManagement.restituzione(libro);
				if(trovato == true) {
					System.out.println("Libro restituito");
				}
				else {
					System.out.println("Libro NON restituito");
				}
				break;
			}
			case 6: {
				Libro newLibro = newLibro();
				bibliotecaManagement.addLibro(newLibro);
				break;
			}
			case 7:{
				Socio socio = newSocio();
				bibliotecaManagement.addSocio(socio);
				break;
			}
			
			default:{
				throw new IllegalArgumentException();
			}
			
			}
		} while (ok);
		
	}
	
	
	public void printMenu() {
		System.out.println("Main Menu");
		System.out.println("0: chiudere il programma");
		System.out.println("1: ricerca dei dati di un libro a partire dal proprio codice ISBN");
		System.out.println("2: ricerca dei dati di un socio a partire dal proprio codice fiscale");
		System.out.println("3: verifica del prestito di un libro con indicazione dei dati del socio che lo ha preso");
		System.out.println("4: memorizzazione di un nuovo prestito");
		System.out.println("5: restituzione di un libro");
		System.out.println("6: inserisci un libro");
		System.out.println("7: inserisci un socio");
	}
	
	
	//interfacce private
	
	private Prestito newPrestito() {
		System.out.println("PRESTITO");
		Socio socio = newSocio();
		Libro libro = newLibro();
		return new Prestito(socio, libro);
	}
	
	private Socio newSocio() {
		System.out.println("SOCIO");
		System.out.println("inserisci nome: ");
		String nome = scanner.nextLine();
		System.out.println("inserisci cognome: ");
		String cognome = scanner.nextLine();
		System.out.println("insersici codice fiscale: ");
		String codiceFiscale = scanner.nextLine();
		return new Socio(nome, cognome, codiceFiscale);
	}
	
	private Libro newLibro() {
		System.out.println("LIBRO");
		System.out.println("inserisci titolo: ");
		String titolo = scanner.nextLine();
		System.out.println("insersici isbn: ");
		String isbnUser = scanner.nextLine();
		return new Libro(titolo, isbnUser);
	}
	
	
}
