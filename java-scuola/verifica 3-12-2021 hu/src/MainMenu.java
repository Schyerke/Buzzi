import java.util.Scanner;

public class MainMenu {
	
	private static final String MESSAGGIO = "1. Creare un lampadario della dimensione scelta\n"
			+ "2. Inserire nel lampadario le lampadine, in numero pari alla dimensione scelta al punto\n"
			+ "precedente (non è possibile inserire un numero di lampadine inferiore)\n"
			+ "3. Fare l’operazione di click per il lampadario (che si ripercuote su tutte le lampadine)\n"
			+ "4. Visualizzare lo stato di tutti i lampadari con le corrispondenti lampadine\n"
			+ "5. Per cambiare lampadario (l'utilizzo)";
	
	
	private static final int MAX_LAMPADARI = 2;
	private Lampadario[] lampadariUtente = new Lampadario[MAX_LAMPADARI];
	private int lampadarioIndice;
	
	private int lampadarioInUso = -1;
	private int dimensioneLampadarioUtente = -1;
	
	public void startMenu() {
		Scanner scanner = new Scanner(System.in);
		boolean continua = true;
		do {
			printMenu();
			int sceltaUtente;
			boolean continuaSceltaUtente = true;
			do {
				System.out.println("Inserisci scelta: ");
				sceltaUtente = Integer.parseInt(scanner.nextLine());
				if(sceltaUtente < 0 || sceltaUtente > 5) {
					System.out.println("input invalido");
					continuaSceltaUtente = false;
				} else {
					System.out.println("ok");
					continuaSceltaUtente = true;
				}
			} while (!continuaSceltaUtente);
			
			
			
			switch(sceltaUtente) {
			case 1:
				//case 1 Creare un lampadario della dimensione scelta
				
				if(lampadarioIndice >= MAX_LAMPADARI) {
					System.out.println("troppi lampadari (max 2)");
					break;
				}
				
				System.out.println("Inserisci la dimensione del lampadario: ");
				dimensioneLampadarioUtente = Integer.parseInt(scanner.nextLine());
				
				if(dimensioneLampadarioUtente < 1 || dimensioneLampadarioUtente > 5) {
					System.out.println("dimensione non valida");
					break;
				}
				
				System.out.println("inserisci la tipologia del lampadario (parallela o serie): ");
				String tipologiaLampadario = scanner.nextLine().toLowerCase();
				if(!(tipologiaLampadario.equals(TipologiaLampadario.PARALLELA) || tipologiaLampadario.equals(TipologiaLampadario.SERIE))) {
					System.out.println("tipologia invalida. Parallelo o serie");
					break;
				}
				
				lampadarioInUso = lampadarioIndice;
				lampadariUtente[lampadarioIndice++] = new Lampadario(dimensioneLampadarioUtente, tipologiaLampadario);
				
				
				break;
			
			case 2:
				//case 2 Inserire nel lampadario le lampadine, in numero pari alla dimensione scelta al punto
				//precedente (non è possibile inserire un numero di lampadine inferiore)
				if(lampadarioInUso == -1) {
					System.out.println("crea prima una lampadario");
					break;
				}
				System.out.println(dimensioneLampadarioUtente);
				for (int i = 0; i < dimensioneLampadarioUtente; i++) {
					System.out.println("\nInserimento della lampadina " + i);
					Lampadina newLampadina = creaLampadina();
					lampadariUtente[lampadarioInUso].setLampadine(newLampadina, i);
				}
				System.out.println("\ncreati\n");
				
				
				break;
			
			case 3:
				//case 3 Fare l’operazione di click per il lampadario (che si ripercuote su tutte le lampadine)
				if(lampadarioInUso == -1) {
					System.out.println("crea prima una lampadario");
					break;
				}
				lampadariUtente[lampadarioInUso].click();
				
				break;
			
			case 4:
				//case 4 Visualizzare lo stato di tutti i lampadari con le corrispondenti lampadine
				if(lampadarioIndice == 0) {
					System.out.println("non hai creato nessun lampadario");
					break;
				}
				for (int i = 0; i < lampadarioIndice; i++) {
					System.out.println("lampadario " + i);
					for (int j = 0; j < lampadariUtente[i].getNumeroLampadine(); j++) {
						System.out.println(lampadariUtente[i].getStatoLampadario() + " |stato lampadina " + j);
					}
				}
				
				break;
				
			case 5:
				if(lampadarioInUso == -1) {
					System.out.println("crea prima una lampadario");
					break;
				}
				
				System.out.println("inserisci 1 o 2 selezionare quale lampadario usare: ");
				int lampadarioInUsoTest = Integer.parseInt(scanner.nextLine()) - 1;
				if(lampadariUtente[lampadarioInUsoTest] == null) {
					System.out.println("il lampadario che stai cercando di utilizzare non e' stato ancora creato");
				} else {
					lampadarioInUsoTest = lampadarioInUsoTest;
				}
				break;
			}
			
			
			
		} while (continua);
		
		
		
	}
	
	public void printMenu() {
		System.out.println(MESSAGGIO);
	}
	
	//metodi privati
	
	private Lampadina creaLampadina() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("inserisci quantita di luce emessa in lm: ");
		double quantitaLuceEmessaLm = Double.parseDouble(scanner.nextLine());
		
		System.out.println("inserisci potenza assorbita in watt: ");
		double potenzaAssorbitaWatt = Double.parseDouble(scanner.nextLine());
		
		System.out.println("inserisci tipologia ('led' o 'tradizionale'): ");
		boolean continua = true;
		String tipologia = "";
		while(continua) {
			tipologia = scanner.nextLine().toLowerCase();
			if(tipologia.equals("led") || tipologia.equals("tradizionale")) {
				System.out.println("\nok\n");
				continua = false;
			} else {
				System.out.println("input invalido. 'led' o 'tradizionale'");
				continua = true;
			}
		}
		return new Lampadina(quantitaLuceEmessaLm, potenzaAssorbitaWatt, tipologia);
		
	}
	
	
	
	
	
	
}
