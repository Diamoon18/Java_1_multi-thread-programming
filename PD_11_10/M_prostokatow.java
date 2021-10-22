package PD_11_10;

public class M_prostokatow extends Thread{
	private float a;
	private float dx;
	
	private double w_calka;
	private int i;

	public M_prostokatow(double w_calka, int i, float a, float dx){
		this.a = a;
		this.dx = dx;
		this.w_calka = w_calka;
		this.i = i;
		start();
	}
	
	public void run() {
		w_calka = mojPrzyklad.exampleTen(a+i*dx);
		System.out.println("M_Prostakat nr-" + i + " ma wartosc calki = " + w_calka);
		main_task_1.wynik_prostokaty += w_calka;
	}
}
