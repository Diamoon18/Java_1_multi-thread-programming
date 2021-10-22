package PD_11_10;

public class mojPrzyklad {
	
	private static double wynik;
	
	public static double funkcja1(double x) {
		wynik = x*x;
		return wynik;
	}
	
	public static double funkcja2(double x) {
		wynik = (x*x*Math.sqrt(1+x))/(1+x*x);
		return wynik;
	}
	
	public static double exampleTen(double x) {
		wynik = Math.sqrt(x*x + 0.5)/(1.2+Math.sqrt(0.8*x*x+1.1));
		return wynik;
	}
}
