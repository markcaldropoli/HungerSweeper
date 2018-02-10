import java.util.Scanner;

public class Player {
	private int x;
	private int y;
	private String name;
	private int health = 100;
	
	public Player(String name) {
		this.name = name;
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
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public void move() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Please input a direction: ");
		System.out.println("(up,down,right,left)");
		
		while(true) {
			String mov = sc.nextLine();
			if(mov.equalsIgnoreCase("up")) {
				if(this.getX() > 0 && this.getX() < 15 && this.getY()-1 > 0 && this.getY()-1 < 15) {
					y--;
					break;
				} else {
					System.out.println("Invalid move, please pick a different direction.");
				}
			} else if(mov.equalsIgnoreCase("down")) {
				if(this.getX() > 0 && this.getX() < 15 && this.getY()+1 > 0 && this.getY()+1 < 15) {
					y++;
					break;
				} else {
					System.out.println("Invalid move, please pick a different direction.");
				}
			} else if(mov.equalsIgnoreCase("right")) {
				if(this.getX()+1 > 0 && this.getX()+1 < 15 && this.getY() > 0 && this.getY() < 15) {
					x++;
					break;
				} else {
					System.out.println("Invalid move, please pick a different direction.");
				}
			} else if(mov.equalsIgnoreCase("left")) {
				if(this.getX()-1 > 0 && this.getX()-1 < 15 && this.getY() > 0 && this.getY() < 15) {
					x--;
					break;
				} else {
					System.out.println("Invalid move, please pick a different direction.");
				}
			} else {
				System.out.println("Please enter a valid direction. (up,down,right,left)");
			}
		}
	}
	
	public boolean fight() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Do you want to fight or run?");
		System.out.println("(fight,run)");
		
		while(true) {
			String decision = sc.nextLine();
			if(decision.equalsIgnoreCase("fight")) return true;
			else if(decision.equalsIgnoreCase("run")) return false;
			else System.out.println("Quick! Pick one of the two decisions! (fight,run)");
		}
	}
	
	public static void main(String[] args) {
		Player p1 = new Player("Mark");
		Player p2 = new Player("Marc");
		PlayerManager p = new PlayerManager();
		p.fight(p1, p2);
	}
}