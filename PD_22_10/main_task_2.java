package PD_22_10;


public class main_task_2 {
	
	static int number_of_aviaries = 10;
	static Zoo zoo;
	static String[] animals = {"Spiders", "Flamingo", "Owls", "Sparrows", "Horses",
								"Lions", "Gazelle", "Rabbits", "Hawks", "Snakes", 
								"Cockatoos", "Wolfs", "Foxes", "Butterflies"};
	static int food = 1000;
	static int number_of_workers = 3;
	
	public main_task_2(){}
	
	public static void main(String[] args) {
		zoo = new Zoo(number_of_aviaries);
		for(int i = 0; i < number_of_aviaries; i++)
			new Aviaries(i, animals, zoo, food, number_of_workers).start();
	}

}
