public class Main {
	public static void main(String[] args) {
		Lista<String> l=new Lista<String>();
		l.insTesta("aa");
		l.insTesta("bbb");
		l.insTesta("sss");
		l.insCoda("xxx");
		l.insMezzo(3, "---");
		for(Object e:l) {
			System.out.print(e.toString()+"\n");
		}
		
	}
}