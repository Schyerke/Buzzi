
public class Nodo <T> {
	private T nome;
	private Nodo<T> next;
	
	public Nodo(T nome) {
		this.nome = nome;
	}
	
	public void setInfo(T nome) {
		this.nome = nome;
	}
	
	public T getInfo() {
		return this.nome;
	}
	
	public void setNext(Nodo<T> nodo) {
		this.next = nodo;
	}
	
	public Nodo<T> getNext() {
		return this.next;
	}
	
	@Override
	public String toString() {
		return " " + this.nome + " ";
	}
	
}
