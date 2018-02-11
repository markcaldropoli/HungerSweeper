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
	boolean answer;
	public Traps(String description, String choice1, String choice2, String answer1, String answer2, int healthLoss, boolean answer) {
		super();
		this.description = description;
		Random random = new Random();
		this.x = random.nextInt(6);
		this.y = random.nextInt(6);
		this.choice1 = choice1;
		this.choice2 = choice2;
		this.answer1 = answer1;
		this.answer2 = answer2;
		this.healthLoss = healthLoss;
		this.answer = answer;
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
