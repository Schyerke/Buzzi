import java.util.Iterator;

public class Lista<T> implements Iterable{
	private Nodo<T> testa;
	private int n;
	public Lista() {
		testa=null;
		n=0;
	}
	public int size() {
		return n;
	}
	public void insTesta(T info) {
		Nodo<T> p=new Nodo<T>(info);
		p.setLink(testa);
		testa=p;
		n++;
	}
	public void insCoda(T info) {
		Nodo<T> t=testa, p=new Nodo<T>(info);
		if(size()==0) insTesta(info);
		else {
			while(t.getLink()!=null) t=t.getLink();
			p.setLink(null);
			t.setLink(p);
			n++;
		}
	}
	public void insMezzo(int x, T info) {
		int i=1; Nodo<T> t=testa, p=new Nodo<T>(info);
		if(size()==0||x<=1) insTesta(info);
		else if(n<x) insCoda(info);
		else {
			while(i<x-1) {
				i++;
				t=t.getLink();
			}
			p.setLink(t.getLink());
			t.setLink(p);
			n++;
		}
	}
	public T rimTesta() {
		if(size()==0) return null;
		else {
			n--;
			T app=testa.getInfo();
			testa=testa.getLink();
			return app;
		}
	}
	public T rimCoda() {
		Nodo<T> t=testa;
		if(size()==0) return null;
		else if(size()==1) return rimTesta();
		else {
			n--;
			while(t.getLink().getLink()!=null) t=t.getLink();
			T app=t.getLink().getInfo();
			t.setLink(null);
			return app;
		}
	}
	public T rimMezzo(int x) {
		int i=1; Nodo<T> t=testa;
		if(size()==0||x<=1) return rimTesta();
		else if(size()<=x) return rimCoda();
		else {
			while(i<x-1) {
				i++;
				t=t.getLink();
			}
			T app=t.getLink().getInfo();
			t.setLink(t.getLink().getLink());
			n--;
			return app;
		}
	}
	
	
	public String toString() {
		Nodo<T> t=testa; String app="";
		if(n==0) return app;
		else while(t.getLink()!=null) {
			app+=t.toString();
			t=t.getLink();
		}
		app+=t.toString();
		return app;
	}
	public Iterator<T> iterator() {
		return new IteratoreLista<T>(testa);
	}
}