package PD_11_10;

public class M_Simpsona extends Thread{
	private float a;
	private float dx;
	
	private double w_calka;
	private int i, n;

	public M_Simpsona(double w_calka, int i, float a, float dx, int n) {
		this.a = a;
		this.dx = dx;
		this.w_calka = w_calka;
		this.i = i;
		this.n = n;
		start();
	}
	
	public void run() {
		if(i == 0 || i == n) {
			w_calka = mojPrzyklad.funkcja1(a+i*dx);
		} else if(i%2 == 0) {
			w_calka = 2*mojPrzyklad.funkcja1(a+i*dx);
		} else {
			w_calka = 4*mojPrzyklad.funkcja1(a+i*dx);
		}
		System.out.println("M_simpsona nr-" + i + " ma wartosc calki = " + w_calka);
		main_task_1.wynik_simpsona += w_calka;
	}
}
