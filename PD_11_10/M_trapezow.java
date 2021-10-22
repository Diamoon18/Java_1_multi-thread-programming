package PD_11_10;

public class M_trapezow extends Thread{
	private float a;
	private float dx;
	
	private double w_calka;
	private int i, n;

	public M_trapezow(double w_calka, int i, float a, float dx, int n) {
		this.a = a;
		this.dx = dx;
		this.w_calka = w_calka;
		this.i = i;
		this.n = n;
		start();
	}
	
	public void run() {
		if(i == 0 || i == n) {
			w_calka = mojPrzyklad.exampleTen(a+i*dx)/2;
		} else {
			w_calka = mojPrzyklad.exampleTen(a+i*dx);
		}
		System.out.println("M_trapezow nr-" + i + " ma wartosc calki = " + w_calka);
		main_task_1.wynik_trapezy += w_calka;
	}
}
