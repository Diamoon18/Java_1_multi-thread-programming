package PD_22_10;

import java.util.Random;

public class Aviaries extends Thread {
		static int ZOO = 1;
		static int OPEN = 2;
		static int BREAK = 3;
		static int CLOSED = 4;
		static int DISASTER = 5;
		static int CALM = 6;
		
		int number;
		String [] animals;
		int state;
		Zoo z;
		Random rand;
		int food, number_of_workers;
		
		public Aviaries(int number, String [] animals, Zoo z, int food, int number_of_workers){
			this.number = number;
			this.animals = animals;
			this.state = ZOO;
			this.z = z;
			this.food = food;
			this.number_of_workers = number_of_workers;
			rand = new Random();
		}
		
		public void run(){
			while(true){
				if(state == ZOO){
					if(food >= 1000 && number_of_workers > 1){
						System.out.println("There is enough food for animals and disasters are not found!");
						state = z.start(number);
					} else {
						System.out.println("The zoo cannot be opened!");
						state = CLOSED;
					}
				} else if(state == OPEN){
					System.out.println("Aviary nr-" + number + " working properly! " + 
							animals[rand.nextInt(animals.length-1)] + " aren't hungry");
					try{sleep(rand.nextInt(1000));}catch (Exception e){}
					state = CALM;
				} else if(state == CALM){
					food-=rand.nextInt(100);
					if(food <= 10){
						state = BREAK;
					}
					else try{
						sleep(rand.nextInt(100));
						state = OPEN;
					}
					catch (Exception e){}
				} else if(state == BREAK){
					System.out.println("Technical break due to hunger of animals! Aviary nr-" + number + " the amount of food " + food);
					int food_transp = z.food_transp();
					food += food_transp;
					System.out.println("Worker order supplies -> " + food_transp + "; Food now = " + food);
					if(food <= 10) {
						state = DISASTER;
					} else {
						state = OPEN;
					}
				} else if(state == DISASTER){
					System.out.println("Animals are in big trouble! Aviary nr-"+ number + 
										" workers = " + number_of_workers + " food = " + food);
					state = CLOSED;
				} else if(state == CLOSED) {
					 System.out.println("The zoo has a big problem, that's why it's closed!");
					 System.exit(0);
				}
			}
		}
}

