import java.util.ArrayList;

public class Menu {
	
	private ArrayList<ProdottoMenu> prodotti = new ArrayList<ProdottoMenu>();
	
	private double prezzoCoperto = 2.5;
	
	
	private static Menu menu;
	
	private Menu() {
		
	}
	
	public static Menu getIstanza() {
		if(menu == null) {
			menu = new Menu();
		}
		return menu;
	}
	
	public void addProdotto(ProdottoMenu prodotto) {
		prodotti.add(prodotto);
	}
	
	//dati cercati dal nome e' una classe che contiene i dati trovati nei prodotti
	public DatiCercatiDalNome cercaDati(String nome) {
		DatiCercatiDalNome dati = null;
		for (ProdottoMenu prodottoMenu : prodotti) {
			if(prodottoMenu != null && prodottoMenu.getNome().equals(nome)) {
				if(prodottoMenu != null && prodottoMenu instanceof Pizza) {
					dati = new DatiCercatiPizza(prodottoMenu.getDescrizione(), prodottoMenu.getNome(),
							prodottoMenu.getPrezzo(), ((Pizza)prodottoMenu).getCondimenti() );
					return dati;
				} 
				else if(prodottoMenu != null && prodottoMenu instanceof Bevande) {
					dati = new DatiCercatiBevanda(prodottoMenu.getDescrizione(), prodottoMenu.getNome(),
							prodottoMenu.getPrezzo(),  ((Bevande)prodottoMenu).getTIPOLOGIA() );
					return dati;
				} 
				else if(prodottoMenu != null && prodottoMenu instanceof Contorno) {
					dati = new DatiCercatiContorno(prodottoMenu.getDescrizione(), prodottoMenu.getNome(),
							prodottoMenu.getPrezzo());
					return dati;
				}
			}
		}
		return dati;
		
	}
	
	//metodo per eliminare un prodotto contenente nell'arraylist "prodotti". Mediante il nome della voce
	public boolean eliminaVoce(String voceEliminareUtente) {
		for(int i=0; i<prodotti.size(); i++) {
			if(prodotti.get(i) != null && prodotti.get(i).getNome().equalsIgnoreCase(voceEliminareUtente)) {
				prodotti.remove(i);
				return true;
			}
		}
		return false;
	}
	
	//metodo per impostare il prezzo di un coperto. Lancia l'ecezzione prezzoNegativo quando l'utente mette un prezzo minore di 0
	public void setPrezzoCoperto(double prezzo) throws PrezzoNegativo{
		if(prezzo < 0) {
			throw new PrezzoNegativo();
		}
		this.prezzoCoperto = prezzo;
	}
	
	public double prezzoCoperto(int numeroPersone) {
		return prezzoCoperto * numeroPersone;
	}
	
	//metodo per calcolare i prezzi medi delle varie voci (pizza, bevanda ecc)
	public double calcolaPrezzoMedio(String tipologia) {
		if(tipologia.equalsIgnoreCase(TipologieVoce.PIZZA) || tipologia.equalsIgnoreCase(TipologieVoce.CONTORNO)) {
			double prezzoTotalePizza=0;
			int i=0;
			for (ProdottoMenu prodottoMenu : prodotti) {
				if(prodottoMenu != null && prodottoMenu instanceof Pizza) {
					i++;
					prezzoTotalePizza += prodottoMenu.getPrezzo();
				}
				if (prodottoMenu != null && prodottoMenu instanceof Contorno) {
					i++;
					prezzoTotalePizza += prodottoMenu.getPrezzo();
				}
			}
			return (prezzoTotalePizza / i);
		}
		if (tipologia.equalsIgnoreCase(TipologieVoce.BEVANDA)) {
			double prezzoTotaleBevanda=0;
			int i=0;
			for (ProdottoMenu prodottoMenu : prodotti) {
				if(prodottoMenu != null && prodottoMenu instanceof Bevande) {
					i++;
					prezzoTotaleBevanda += prodottoMenu.getPrezzo();
				}
			}
			return (prezzoTotaleBevanda / i);
		}
		
		if (tipologia.equals("generale")) {
			double prezzoTotaleGenerale=0;
			int i=0;
			for (ProdottoMenu prodottoMenu : prodotti) {
				if(prodottoMenu != null) {
					i++;
					prezzoTotaleGenerale += prodottoMenu.getPrezzo();
				}
			}
			return (prezzoTotaleGenerale / i);
		}
		return -1;
	}
	
	
	

	@Override
	public String toString() {
		return "Menu [prodotti=" + prodotti + ", prezzoCoperto=" + prezzoCoperto + "]";
	}
	
	
	
}
