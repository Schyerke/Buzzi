import java.util.Iterator;

import figureGeometriche.*;
import figuregeometricheAbstract.FiguraSolida;
import figuregeometricheAbstract.FigureGeometriche;

public class Lista<T> implements Iterable<T>{
	private Nodo<T> testa;
	private int length;
	
	public Lista() {
		
	}
	
	public boolean isEmpty() {
		return (length == 0 || testa == null);
	}
	
	public int size() {
		return length;
	}
	
	public boolean inserisciInTesta(T info) {
		Nodo<T> app = new Nodo<T>(info);
		app.setNext(testa);
		testa = app;
		length++;
		return true;
	}
	
	public boolean inserisciInCoda(T info) {
		Nodo<T> app = testa;
		
		while(app.getNext() != null) {
			app = app.getNext();
		}
		app.setNext(new Nodo<T>(info));
		length++;
		return true;
	}
	
	public boolean inserisciInMezzo(T info, int pos) {
		if (pos > length || pos < 0 || testa == null) {
			return false;
		}
		if(pos == 0) {
			inserisciInTesta(info);
			return true;
		}
		length++;
		Nodo<T> app = testa;
		
		for (int i=0; i<pos -1; i++) {
			app = app.getNext();
		}
		Nodo<T> appTmp = app.getNext();
		app.setNext(new Nodo<T>(info));
		app.getNext().setNext(appTmp);
		return true;
	}
	
	public T cancellaInTesta() {
		Nodo<T> appTmp = testa;
		testa = testa.getNext();
		appTmp.setNext(null);
		length--;
		return appTmp.getInfo();
	}
	
	public T cancellaInCoda() {
		if(testa == null) {
			return null;
		}
		length--;
		Nodo<T> appTmp = testa;
		while(appTmp.getNext().getNext() != null) {
			appTmp = appTmp.getNext();
		}
		T tmpInfo = appTmp.getInfo();
		appTmp.setNext(null);
		return tmpInfo;
	}
	
	public T cancellaInMezzo(int pos) {
		if(pos < 0 || pos > length) {
			return null;
		}
		length--;
		Nodo<T> appTmp = testa;
		
		for (int i = 0; i < pos-1; i++) {
			appTmp = appTmp.getNext();
		}
		T tmpInfo = appTmp.getNext().getInfo();
		Nodo<T> toDelete = appTmp.getNext();
		appTmp.setNext(appTmp.getNext().getNext());
		toDelete = null;
		return tmpInfo;
	}
	
	public boolean ricerca(T info) {
		Nodo<T> temp = testa;
		
		while(temp != null) {
			if(info instanceof String) {
				if(info.equals(temp.getInfo())) {
					return true;
				}
			}
			if(info instanceof Cerchio) {
				System.out.println("Ho trovato un cerchio");
				return true;
			}
			if(info instanceof Cilindro) {
				System.out.println("Ho trovato un cilindro");
				return true;
			}
			if(info instanceof Piramide) {
				System.out.println("Ho trovato una piramide");
				return true;
			}
			if(info instanceof Quadrato) {
				System.out.println("Ho trovato un quadrato");
				return true;
			}
			
			temp = temp.getNext();
		}
		return false;
	}
	
	
	//metodo per ottenere un elemento dato l'indice
	public T get(int pos) {
		if(pos < 0 || pos>length) {
			return null;
		}
		Nodo<T> appTmp = testa;
		for(int i=0; i<pos; i++) {
			appTmp = appTmp.getNext();
		}
		return appTmp.getInfo();
	}
	
	public String toString() {
		if(testa == null) {
			return null;
		}
		Nodo<T> temp = testa;
		String message = "";
		while(temp != null) {
			message += temp.getInfo().toString() + "  ";
			temp = temp.getNext();
		}
		return message;
	}

	@Override
	public Iterator<T> iterator() {
		return new IteratoreLista<T>(testa);
	}
}



















