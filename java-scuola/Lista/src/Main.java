
public class Main {
	public static void main(String[] args) {
		Lista<String> l=new Lista<String>();
		l.inserisciInTesta("aa");
		l.inserisciInTesta("bbb");
		l.inserisciInTesta("sss");
		for(Object e:l) {
			System.out.print(e.toString()+"\n");
		}
	}
}
