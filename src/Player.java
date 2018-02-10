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
				System.out.println("Please enter a valid direction.");
			}
		}
	}
	
	public static void main(String[] args) {
		Player p1 = new Player("Mark");
		Player p2 = new Player("Marc");
		Player p3 = new Player("Logen");
		p1.setX(5);
		p1.setY(5);
		p2.setX(1);
		p2.setY(1);
		p3.setX(14);
		p3.setY(14);
		p3.move();
	}
}