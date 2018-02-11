/* 
 * Mark Caldropoli & Marc Shelton
 */

import java.util.Random;
import java.util.Scanner;

public class Traps {
	String description;
	int x;
	int y;
	String choice1;
	String choice2;
	String answer1;
	String answer2;
	int healthLoss;
	boolean answer;
	int range;
	public Traps(String description, String choice1, String choice2, String answer1, String answer2, int healthLoss, boolean answer, int r) {
		super();
		this.description = description;
		Random random = new Random();
		this.x = random.nextInt(r);
		this.y = random.nextInt(r);
		this.choice1 = choice1;
		this.choice2 = choice2;
		this.answer1 = answer1;
		this.answer2 = answer2;
		this.healthLoss = healthLoss;
		this.answer = answer;
		this.range = r;
	}
	public void move() {
		while(true) {
			Random random = new Random();
			int rand = random.nextInt(4);

			if(rand == 0) {
				if(this.getX() > 0 && this.getX() < 8 && this.getY()-1 > 0 && this.getY()-1 < range) {
					y--;
					break;
				}
			} else if(rand == 1) {
				if(this.getX() > 0 && this.getX() < 8 && this.getY()+1 > 0 && this.getY()+1 < range) {
					y++;
					break;
				}
			} else if(rand == 2) {
				if(this.getX()+1 > 0 && this.getX()+1 < 8 && this.getY() > 0 && this.getY() < range) {
					x++;
					break;
				}
			} else if(rand == 3) {
				if(this.getX()-1 > 0 && this.getX()-1 < 8 && this.getY() > 0 && this.getY() < range) {
					x--;
					break;
				}
			}
		}
	}
	public boolean caughtTrap(Player a, boolean b){
		if(b){
			@SuppressWarnings("resource")
			Scanner reader = new Scanner(System.in);
			int n = 0;
			System.out.println("---------------------------");
			System.out.println("Oh no, " + a.getName() + ", " + description + "\nDo you?:\n1. " + choice1 + "\n2. " + choice2 + "\n(Type 1 or 2)");
			while(!reader.hasNextInt()) {
				reader.next();
				System.out.println("Please enter a number. 1 and 2 are the only choices.");
			}
			n = reader.nextInt();
			while(n != 1 && n != 2){
				System.out.println("Please enter a valid number. 1 and 2 are the only choices.");
				while(!reader.hasNextInt()) {
					reader.next();
					System.out.println("Please enter a number. 1 and 2 are the only choices.");
				}
				n = reader.nextInt();
			}
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
		else{
			Random random = new Random();
			int n = random.nextInt(2);
			if(n == 1){
				if(answer){
					a.setHealth(a.getHealth() - healthLoss);
				}
			}
			if(n == 2){
				if(!(answer)){
					a.setHealth(a.getHealth() - healthLoss);
				}
			}
			if(a.getHealth() <= 0){
				System.out.println("---------------------------");
				System.out.println(a.getName() + " has died!");
				return true;
			}
			x = -1;
			y = -1;
			return false;
		}
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public String getChoice1() {
		return choice1;
	}
	public void setChoice1(String choice1) {
		this.choice1 = choice1;
	}
	public String getChoice2() {
		return choice2;
	}
	public void setChoice2(String choice2) {
		this.choice2 = choice2;
	}
	public String getAnswer1() {
		return answer1;
	}
	public void setAnswer1(String answer1) {
		this.answer1 = answer1;
	}
	public String getAnswer2() {
		return answer2;
	}
	public void setAnswer2(String answer2) {
		this.answer2 = answer2;
	}
	public int getHealthLoss() {
		return healthLoss;
	}
	public void setHealthLoss(int healthLoss) {
		this.healthLoss = healthLoss;
	}
	public boolean isAnswer() {
		return answer;
	}
	public void setAnswer(boolean answer) {
		this.answer = answer;
	}
}
