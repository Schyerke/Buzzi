package figureGeometriche;
import figuregeometricheAbstract.FiguraPiana;
import figuregeometricheAbstract.FigureGeometriche;

public class Cerchio extends FiguraPiana{
	
	private double raggio;
	
	public Cerchio(double raggio) {
		this.raggio = raggio;
	}
	

	@Override
	public void stampare() {
		System.out.println("sono un cilindro");
	}

	@Override
	public double area() {
		return Math.PI * this.raggio * this.raggio;
	}


	@Override
	public double perimetro() {
		return 2 * Math.PI * this.raggio;
	}


	@Override
	public String toString() {
		return "Cerchio [raggio=" + raggio + "]";
	}
	
	
	
}
