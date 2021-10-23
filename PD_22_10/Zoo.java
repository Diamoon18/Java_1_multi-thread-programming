package PD_22_10;

import java.util.Random;

public class Zoo {
	static int ZOO = 1;
	static int OPEN = 2;
	static int BREAK = 3;
	static int CLOSED = 4;
	static int DISASTER = 5;
	
	int number_of_aviaries;
	
	public Zoo(int number_of_aviaries) {
		this.number_of_aviaries = number_of_aviaries;
	}
	
	synchronized int start(int number){
		System.out.println("Aviary nr-" + number + " is ready!");
		return OPEN;
	}
	
	synchronized int food_transp(){
		try{
			Thread.currentThread();
			Thread.sleep(1000);
		} catch(Exception ie){}
		Random r = new Random();
		int number_of_food = r.nextInt(50);
		return number_of_food;
	}
}
