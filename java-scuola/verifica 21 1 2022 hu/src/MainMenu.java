import java.util.Scanner;

public class MainMenu {
	
	private static final String MESSAGGIO = "1. Inserire una nuova voce nel menu\r\n"
			+ "2. Dato il nome di un piatto o bevanda, trovarne prezzo e gli altri eventuali dati\r\n"
			+ "3. Eliminare una voce dal menu, dato il suo nome\r\n"
			+ "4. Trovare il prezzo medio dei piatti (pizze e contorni), il prezzo medio delle bevande,\r\n"
			+ "e il prezzo medio generale di tutte le voci del menu\r\n"
			+ "5. Modificare il prezzo del coperto\r\n"
			+ "6. Visualizzare il menu coperto compreso"
			+ "0 per chiudere";
	
	private Menu menu = Menu.getIstanza();
	
	private Scanner scanner = new Scanner(System.in);
	
	{
		start();
	}
	
	public void start() {
		boolean ok = true;
		int userChoice = -1;
		do {
			boolean continua = false;
			do {
				
				printMessaggio();
				
				try {
					userChoice = Integer.parseInt(scanner.nextLine());
				} catch(NumberFormatException e) {
					System.out.println(e.getMessage());
				}
				finally {
					if(userChoice == -1 || (userChoice < 0 || userChoice > 6)) {
						System.out.println("Errore, reinserire");
						continua = false;
					} else {
						continua = true;
					}
				}
				
				
			} while (!continua);
			
			
			switch(userChoice) {
			case 0:{
				System.out.println("programma chiuso");
				ok = false;
				break;
			}
			case 1:{
				//inserire una nuova voce nel menu
				System.out.println("inserire una nuova voce nel menu: (bevanda, pizza, o contorno)");
				String voceUtente = scanner.nextLine().toLowerCase();
				
				ProdottoMenu prodottoUtente = null;
				try {
					prodottoUtente = creaProdotto(voceUtente);
				} catch (BevandaNonEsistente e) {
					System.out.println(e.getMessage());
				}
				
				if(prodottoUtente == null) {
					System.out.println("errore, prodotto non e' stato definito");
					break;
				} else {
					menu.addProdotto(prodottoUtente);
				}
				
				
				
				break;
				
			}
			case 2:{
				//Dato il nome di un piatto o bevanda, trovarne prezzo e gli altri eventuali dati
				System.out.println("Inserisci un nome di un prodotto: ");
				String nomeProdottoUtente = scanner.nextLine();
				
				DatiCercatiDalNome dati = menu.cercaDati(nomeProdottoUtente);
				if(dati == null) {
					System.out.println("Nome non trovato");
					break;
				}
				if(dati instanceof DatiCercatiBevanda) {
					System.out.println(((DatiCercatiBevanda)dati).toString());
				}
				else if(dati instanceof DatiCercatiContorno) {
					System.out.println(((DatiCercatiContorno)dati).toString());
				}
				else if(dati instanceof DatiCercatiPizza) {
					System.out.println(((DatiCercatiPizza)dati).toString());
				}
				
				break;
			}
			
			case 3:{
				//Eliminare una voce dal menu, dato il suo nome
				System.out.println("inserisci una voce da eliminare");
				String voceUtenteEliminare = scanner.nextLine();
				
				if(menu.eliminaVoce(voceUtenteEliminare)) {
					System.out.println("voce eliminata con successo");
				}
				else {
					System.out.println("Voce NON trovata");
				}
				
				
				break;
			}
			
			case 4:{
				//Trovare il prezzo medio dei piatti (pizze e contorni), il prezzo medio delle bevande,\r\n"
				//e il prezzo medio generale di tutte le voci del menu
				double prezzoMedioPiatti = menu.calcolaPrezzoMedio("pizza");
				double prezzoMedioBevande = menu.calcolaPrezzoMedio("bevande");
				double prezzoMedioGenerale = menu.calcolaPrezzoMedio("generale");
				
				if(prezzoMedioBevande == -1) {
					System.out.println("non ci sono bevande");
				} else {
					System.out.println("prezzo bevande: " + prezzoMedioBevande);
				}
				
				if(prezzoMedioGenerale == -1) {
					System.out.println("non ci sono prodotti");
				}
				else {
					System.out.println("prezzo generale: " + prezzoMedioGenerale);
				}
				
				if(prezzoMedioPiatti == -1) {
					System.out.println("non ci sono piatti e/o contorni");
				}
				else {
					System.out.println("Prezzo piatti: " + prezzoMedioPiatti);
				}
				
				break;
			}
			case 5:{
				//Modificare il prezzo del coperto
				int prezzoCoperto = -1;
				System.out.println("Inserire prezzo coperto: ");
				try {
					prezzoCoperto = Integer.parseInt(scanner.nextLine());
					menu.setPrezzoCoperto(prezzoCoperto);
				} catch (PrezzoNegativo e) {
					System.out.println(e.getMessage());
				}
				break;
			}
			case 6:{
				//Visualizzare il menu coperto compreso
				System.out.println("Menu: " + menu.toString());
				break;
			}
			
			}
			
			
			
			
		} while (ok);
		
		
	}
	
	
	
	public void printMessaggio() {
		System.out.println(MESSAGGIO);
	}
	
	//private method
	
	//metodo per creare un prodotto dato il nome del voce. Lancia "BevandaNonEsistente" (ecezzione) se l'utente mette una tipologia 
	//di una bevanda NON esistente
	private ProdottoMenu creaProdotto(String voceUtente) throws BevandaNonEsistente{
		
		//prodotto deve avere: nome, descrizione, prezzo
		System.out.println("Inserisci nome: ");
		String nome = scanner.nextLine();
		
		System.out.println("inserisci descrizione: ");
		String desc = scanner.nextLine();
		
		System.out.println("inserisci prezzo: ");
		double prezzo = Double.parseDouble(scanner.nextLine());
		
		if(voceUtente.equalsIgnoreCase(TipologieVoce.BEVANDA)) {
			System.out.println("inserisci tipologia della bevanda: (lattina o spina)");
			String tipologiaBevandaUtente = scanner.nextLine().toLowerCase();
			if(!(tipologiaBevandaUtente.equals(TipologiaBevande.LATTINA) || tipologiaBevandaUtente.equals(TipologiaBevande.SPINA))) {
				throw new BevandaNonEsistente();
			}
			return new Bevande(nome, desc, prezzo, tipologiaBevandaUtente);
		}
		if(voceUtente.equalsIgnoreCase(TipologieVoce.CONTORNO)) {
			return new Contorno(nome, desc, prezzo);
		}
		if(voceUtente.equalsIgnoreCase(TipologieVoce.PIZZA)) {
			
			String[] condimenti = inserimentoCondimenti();
			return new Pizza(nome, desc, prezzo, condimenti);
		}
		return null;
		
		
	}
	
	//metodo per inserire i condimenti per una pizza
	private String[] inserimentoCondimenti() {
		
		System.out.println("Inserisci i condimenti separati da uno spazio: ");
		String[] condimenti = scanner.nextLine().split(" ");
		return condimenti;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
