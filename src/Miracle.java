import java.util.Random;
import java.util.Scanner;

public class Miracle extends Traps {
	public Miracle(String description, String choice1, String choice2, String answer1, String answer2, int healthLoss,
			boolean answer) {
		super(description, choice1, choice2, answer1, answer2, healthLoss, answer);
	}

	public void caughtTrap(Player a, PlayerManager b){
		@SuppressWarnings("resource")
		Scanner reader = new Scanner(System.in);
		System.out.println("Oh no, " + a.getName() + ", " + description + "\nDo you?:\n1. " + choice1 + "\n2. " + choice2 + "\n(Type 1 or 2)");
		int n = reader.nextInt();
		if(n == 1){
			System.out.println(answer1);
			if(answer){
				System.out.println("You gain " + healthLoss + " points of health!");
				a.setHealth(a.getHealth() - healthLoss);
			}
		}
		if(n == 2){
			System.out.println(answer2);
			if(!(answer)){
				System.out.println("You gain " + healthLoss + " points of health!");
				a.setHealth(a.getHealth() - healthLoss);
			}
		}
		if(a.getHealth() <= 0){
			System.out.println("---------------------------");
			System.out.println(a.getName() + " has died!");
			System.out.println("---------------------------");
			b.removePlayer(a.getName());
		}
		else{
			System.out.println(a.getName() + " has " + a.getHealth() + " health left!");
		}
		x = -1;
		y = -1;
	}

	@Override
	public boolean caughtTrap(Player a, boolean b){
		if(b){
			@SuppressWarnings("resource")
			Scanner reader = new Scanner(System.in);
			int n = 0;
			System.out.println("Oh no, " + a.getName() + ", " + description + "\nDo you?:\n1. " + choice1 + "\n2. " + choice2 + "\n(Type 1 or 2)");
			while(!reader.hasNextInt()) {
				reader.next();
				System.out.println("Please enter a valid number. 1 and 2 are the only choices.");
			}
			n = reader.nextInt();
			while(n != 1 && n != 2){
				while(!reader.hasNextInt()) {
					reader.next();
					System.out.println("Please enter a valid number. 1 and 2 are the only choices.");
				}
				n = reader.nextInt();
			}
			if(n == 1){
				System.out.println(answer1);
				if(answer){
					if(a.getHealth() + healthLoss >= 100){
						System.out.println("Your health is fully restored!");
						a.setHealth(100);
					}
					else{
						System.out.println("You gain " + healthLoss + " points of health!");
						a.setHealth(a.getHealth() + healthLoss);
					}
				}
			}
			if(n == 2){
				System.out.println(answer2);
				if(!(answer)){
					if(a.getHealth() + healthLoss >= 100){
						System.out.println("Your health is fully restored!");
						a.setHealth(100);
					}
					else{
						System.out.println("You gain " + healthLoss + " points of health!");
						a.setHealth(a.getHealth() + healthLoss);
					}
				}
			}
			System.out.println(a.getName() + " has " + a.getHealth() + " health left!");
			x = -1;
			y = -1;
			return false;
		}
		else{
			System.out.println("Oh no, " + a.getName() + ", " + description + "\nDo you?:\n1. " + choice1 + "\n2. " + choice2 + "\n(Type 1 or 2)");
			Random random = new Random();
			int n = random.nextInt(2);
			if(n == 1){
				System.out.println(answer1);
				if(answer){
					System.out.println("You take " + healthLoss + " points of damage!");
					a.setHealth(a.getHealth() - healthLoss);
				}
			}
			if(n == 2){
				System.out.println(answer2);
				if(!(answer)){
					System.out.println("You take " + healthLoss + " points of damage!");
					a.setHealth(a.getHealth() - healthLoss);
				}
			}
			if(a.getHealth() <= 0){
				System.out.println("---------------------------");
				System.out.println(a.getName() + " has died!");
				System.out.println("---------------------------");
				return true;
			}
			else{
				System.out.println(a.getName() + " has " + a.getHealth() + " health left!");
			}
			x = -1;
			y = -1;
			return false;
		}
	}
}
