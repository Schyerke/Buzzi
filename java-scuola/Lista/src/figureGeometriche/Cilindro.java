package figureGeometriche;
import figuregeometricheAbstract.FiguraSolida;
import figuregeometricheAbstract.FigureGeometriche;

public class Cilindro extends FiguraSolida{

	private double altezza;
	private double raggio;
	
	public Cilindro(double altezza, double raggio) {
		this.altezza = altezza;
		this.raggio = raggio;
	}
	
	@Override
	public void stampare() {
		System.out.println("sono un cilindro");
	}

	@Override
	public double area() {
		return 2 * Math.PI * this.raggio;
	}

	@Override
	public double volume() {
		return area() * this.altezza;
	}

	@Override
	public String toString() {
		return "Cilindro [altezza=" + altezza + ", raggio=" + raggio + "]";
	}
	

}
