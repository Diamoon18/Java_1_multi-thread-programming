package PD_11_10;

public class M_trapezow extends Thread{
	private float a;
	private float dx;
	
	private double w_calka;
	private int i;

	public M_trapezow(double w_calka, int i, float a, float dx) {
		this.a = a;
		this.dx = dx;
		this.w_calka = w_calka;
		this.i = i;
		start();
	}
	
	public void run() {
		w_calka = (mojPrzyklad.funkcja1(a+i*dx)+mojPrzyklad.funkcja1(a+(i+1)*dx))*dx/2;
		System.out.println("M_trapezow nr-" + i + " ma wartosc calki = " + w_calka);
		main_task_1.wynik_trapezy += w_calka;
	}
}
