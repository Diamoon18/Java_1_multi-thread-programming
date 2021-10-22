package PD_11_10;

public class main_task_1 {
	
	static double wynik_prostokaty = 0;
	static double wynik_trapezy = 0;
	static double wynik_simpsona = 0;
	
	public static void main(String[] args) {
		System.out.println("----START----");
	//// parametry ////
		float xp = (float) 1.3;
		float xk = (float) 2.5;
		int n = 4;
		float dx = (xk - xp)/n;
		float dx_simpson = dx/2;
		int n_simpson = 2*n;
		
	//// metody ////
		for(int i = 1; i <= n; i++) {
			new M_prostokatow(wynik_prostokaty, i, xp, dx);
		}
		for(int i = 0; i <= n_simpson; i++) {
			new M_Simpsona(wynik_simpson, i, xp, dx_simpson, n_simpson);
		}
		for(int i = 0; i <= n; i++) {
			new M_trapezow(wynik_trapezy, i, xp, dx, n);
		}
				
	//// wyniki ////
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		wynik_prostokaty *= dx;
		System.out.println("---------------Wyniki---------------");
		System.out.println("Metoda prostokatow: Pole --> " + wynik_prostokaty);
		wynik_trapezy *= dx;
		System.out.println("Metoda trapezow: Pole --> " + wynik_trapezy);
		wynik_simpsona *= (dx_simpson/3);
		System.out.println("Metoda Simpsona: Pole --> " + wynik_simpsona);
	}
}
