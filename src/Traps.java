import java.util.Random;

public class Traps {
	String description;
	int x;
	int y;
	String choice1;
	String choice2;
	String answer1;
	String answer2;
	int healthLoss;
	String reward;
	boolean answer;
	public Traps(String description, String choice1, String choice2, String answer1, String answer2, int healthLoss, String reward, boolean answer) {
		super();
		this.description = description;
		Random random = new Random();
		this.x = random.nextInt(15);
		this.y = random.nextInt(15);
		this.choice1 = choice1;
		this.choice2 = choice2;
		this.answer1 = answer1;
		this.answer2 = answer2;
		this.healthLoss = healthLoss;
		this.reward = reward;
		this.answer = answer;
	}
}
