import java.util.Iterator;

public class IteratoreLista<T> implements Iterator<T>{
	private Nodo<T> n;
	public IteratoreLista(Nodo<T> n) {
		this.n=n;
	}
	public boolean hasNext() {
		return n!=null;
	}
	public T next() {
		if(n==null) return null;
		T x=n.getInfo();
		n=n.getLink();
		return x;
	}
}