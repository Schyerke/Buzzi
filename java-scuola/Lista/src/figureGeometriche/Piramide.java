package figureGeometriche;
import figuregeometricheAbstract.FiguraSolida;
import figuregeometricheAbstract.FigureGeometriche;

public class Piramide extends FiguraSolida{
	
	private double altezza;
	private double lunghezza;
	
	public Piramide(double altezza, double lunghezza) {
		this.altezza = altezza;
		this.lunghezza = lunghezza;
	}
	
	

	@Override
	public void stampare() {
		System.out.println("sono una piramide");
	}

	@Override
	public double area() {
		return lunghezza * lunghezza;
	}



	@Override
	public double volume() {
		return area() * this.altezza / 3;
	}



	@Override
	public String toString() {
		return "Piramide [altezza=" + altezza + ", lunghezza=" + lunghezza + "]";
	}
	
	
	
	
}
