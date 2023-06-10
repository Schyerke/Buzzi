package figureGeometriche;
import figuregeometricheAbstract.FiguraPiana;
import figuregeometricheAbstract.FigureGeometriche;

public class Quadrato extends FiguraPiana{
	
	private double lunghezza;
	
	public Quadrato(double lunghezza) {
		this.lunghezza = lunghezza;
	}
	
	
	

	@Override
	public void stampare() {
		System.out.println("sono un quadrato");
	}

	@Override
	public double area() {
		return lunghezza * lunghezza;
	}

	@Override
	public double perimetro() {
		return 4 * lunghezza;
	}




	@Override
	public String toString() {
		return "Quadrato [lunghezza=" + lunghezza + "]";
	}
	
	
	
}
