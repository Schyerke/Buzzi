public class Nodo<T> {
	private T info;
	private Nodo<T> link;
	public Nodo(T info){
		this.info=info;
		this.link=null;
	}
	public T getInfo() {
		return info;
	}
	public void setInfo(T info) {
		this.info = info;
	}
	public Nodo<T> getLink() {
		return link;
	}
	public void setLink(Nodo<T> link) {
		this.link = link;
	}
	public String toString() {
		return info+"\n";
	}
}