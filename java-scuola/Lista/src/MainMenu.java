import figureGeometriche.Cerchio;
import figureGeometriche.Cilindro;
import figureGeometriche.Piramide;
import figureGeometriche.Quadrato;
import figuregeometricheAbstract.FiguraPiana;
import figuregeometricheAbstract.FiguraSolida;
import figuregeometricheAbstract.FigureGeometriche;

public class MainMenu {
	{
		start();
	}
	
	public void start() {
		//questo metodo e' stato usato per testare il programma usando le stringhe invece che le figure geometriche (per semplificare il testing)
		//testListaConStringhe();
		
		
		//metodo per testare il programma usando figure geometriche
		testListaConFigureGeometriche();
		
		
		
	}
	
	private void testListaConFigureGeometriche() {
		Lista<FigureGeometriche> lista = new Lista<FigureGeometriche>();
		if(lista.cancellaInCoda() == null) {
			System.out.println("lista null");
		}
		
		if(lista.inserisciInMezzo(new Cerchio(3), 2) == false) {
			System.out.println("lista null 2.0");
		}
		System.out.println("1: " + lista.size());
		if(lista.isEmpty()) {
			System.out.println("Lista empty");
		}
		
		lista.inserisciInTesta(new Piramide(3, 3));
		
		System.out.println("1: " + lista.size());
		
		
		if(lista.isEmpty()) {
			System.out.println("Lista empty");
		}
		else {
			System.out.println("lista non empty");
			System.out.println("elemento: " + lista.toString());
		}
		
		lista.inserisciInTesta(new Cerchio(2));
		
		stampaLista(lista);
		
		lista.inserisciInCoda(new Cerchio(5));
		
		stampaLista(lista);
		
		lista.inserisciInCoda(new Quadrato(3));
		
		stampaLista(lista);
		System.out.println("1: " + lista.size());
		
		if(lista.inserisciInMezzo(new Quadrato(543), 2) == true) {
			System.out.println("true");
		}
		else {
			System.out.println("false");
		}
		System.out.println("1: " + lista.size());
		stampaLista(lista);
		
		if(lista.inserisciInMezzo(new Cilindro(2, 54), 0));
		System.out.println("1: " + lista.size());
		stampaLista(lista);
		
		
		lista.inserisciInMezzo(new Cilindro(2, 34), 4);
		System.out.println(lista.size());
		System.out.println(lista.ricerca(new Cilindro(23, 54)));
		
		stampaLista(lista);
		
		lista.cancellaInCoda();
		stampaLista(lista);
		lista.cancellaInMezzo(3);
		stampaLista(lista);
		
		lista.cancellaInTesta();
		stampaLista(lista);
		
		lista.cancellaInCoda();
		lista.cancellaInCoda();
		
		stampaLista(lista);
		
		System.out.println();
		System.out.println();
		//calcolo area totale
		calcoloAreaTotale(lista);
		
	}
	
	
	private void calcoloAreaTotale(Lista<FigureGeometriche> lista) {
		System.out.println("calcolo area");
		double totArea = 0;
		for (int i=0; i<lista.size(); i++) {
			
			FigureGeometriche figura = lista.get(i);
			if (figura instanceof FiguraPiana o) {
				totArea += o.area();
			}
			if(figura instanceof FiguraSolida o) {
				totArea += o.area();
			}
		}
		System.out.println();
		System.out.println(totArea);
		
		
		
		
	}
	
	private void stampaLista(Lista lista) {
		if(lista.isEmpty()) {
			System.out.println("Lista empty");
		}
		else {
			System.out.println("lista non empty");
			System.out.println("elemento: " + lista.toString());
		}
	}
	
	private void testListaConStringhe() {
		Lista<String> lista = new Lista<String>();
		if(lista.cancellaInCoda() == null) {
			System.out.println("lista null");
		}
		
		if(lista.inserisciInMezzo("Hello", 2) == false) {
			System.out.println("lista null 2.0");
		}
		
		if(lista.isEmpty()) {
			System.out.println("Lista empty");
		}
		
		lista.inserisciInTesta("1");
		
		
		
		
		if(lista.isEmpty()) {
			System.out.println("Lista empty");
		}
		else {
			System.out.println("lista non empty");
			System.out.println("elemento: " + lista.toString());
		}
		
		lista.inserisciInTesta("2");
		
		stampaLista(lista);
		
		lista.inserisciInCoda("3");
		
		stampaLista(lista);
		
		lista.inserisciInCoda("4");
		
		stampaLista(lista);
		
		if(lista.inserisciInMezzo("5", 2) == true) {
			System.out.println("true");
		}
		else {
			System.out.println("false");
		}
		stampaLista(lista);
		
		if(lista.inserisciInMezzo("6", 0));
		
		stampaLista(lista);
		
		lista.inserisciInMezzo("7", 4);
		System.out.println(lista.size());
		System.out.println(lista.ricerca("7"));
		
		stampaLista(lista);
		
		lista.cancellaInCoda();
		stampaLista(lista);
		lista.cancellaInMezzo(3);
		stampaLista(lista);
		
		lista.cancellaInTesta();
		stampaLista(lista);
		
		
	}
	
	
}
