# PRiR-Homework - multi-thread programming
```PD_11_10``` - the first program for NUMERICAL INTEGRATION (methods Simpson, rectangle method, trapezoidal method) \
```PD_22_10``` - the second program about Zoo ( real world simulation system ) 
## PD_11_10 
I made three classes for each method to represent the area of one figure as a thread.\
First one: ```M_prostokatow``` - consists in dividing the integration interval into rectangles and calculating the area of these rectangles.\
The accuracy of calculations in all methods depends on the number of these divisions, i.e. rectangles.
### Variable initialization
```java
  	private float a; // beginning of the integration interval
	private float dx; // the length of one interval, i.e. the rectangle after the division 
	
	private double w_calka; // integral value
	private int i; // the iteration number, i.e. the thread or rectangle
```
### Constructor
Method start() = run()
```java
public M_prostokatow(double w_calka, int i, float a, float dx){
	this.a = a;
	this.dx = dx;
	this.w_calka = w_calka;
	this.i = i;
	start();
}
```
### Method run()
Count the areas of successive rectangles.\
mojPrzyklad.funkcja1() - a static function with an example integral.\
Writing to the console the value of the next thread = rectangle.\
In a static variable -> ```wynik_prostokaty``` from the main class we sum the result.
```java
public void run() {
	w_calka = mojPrzyklad.funkcja1(a+i*dx);
	System.out.println("M_Prostakat nr-" + i + " ma wartosc calki = " + w_calka);
	main_task_1.wynik_prostokaty += w_calka;
}
```
### This method in class main_task_1
```java
// parametrs
    	float xp = 1;
	float xk = 4;
	int n = 20;
	float dx = (xk - xp)/n;
// main loop - creating threads
    	for(int i = 1; i <= n; i++) {
		new M_prostokatow(wynik_prostokaty, i, xp, dx);
	}
// write the result to the console
    	wynik_prostokaty *= dx;
	System.out.println("---------------Wyniki---------------");
	System.out.println("Metoda prostokatow: Pole --> " + wynik_prostokaty);
```
## The class for trapezoidal method by analogy with rectangle method, but with a some difference.
1) Another formula for calculating the trapezoidal area = thread
```java
public void run() {
	w_calka = (mojPrzyklad.funkcja1(a+i*dx)+mojPrzyklad.funkcja1(a+(i+1)*dx))*dx/2;
	...
```
2) Main loop starts with 0
```java
for(int i = 0; i <= n; i++) {
	new M_trapezow(wynik_trapezy, i, xp, dx);
}
```
## Class for Simpson method
