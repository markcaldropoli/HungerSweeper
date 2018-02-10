import java.util.Scanner;

public class Player {
	private int x;
	private int y;
	private String name;
	
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
	
	public void move() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please input a direction: ");
		System.out.println("(up,down,right,left)");
		
		while(true) {
			String mov = sc.nextLine();
			if(mov.equalsIgnoreCase("up")) {
				if(this.getX() > 0 && this.getX() < 15 && this.getY()-1 > 0 && this.getY()-1 < 15) {
					y--;
				}
				break;
			} else if(mov.equalsIgnoreCase("down")) {
				if(this.getX() > 0 && this.getX() < 15 && this.getY()+1 > 0 && this.getY()+1 < 15) {
					y++;
				}
				break;
			} else if(mov.equalsIgnoreCase("right")) {
				if(this.getX()+1 > 0 && this.getX()+1 < 15 && this.getY() > 0 && this.getY() < 15) {
					x++;
				}
				break;
			} else if(mov.equalsIgnoreCase("left")) {
				if(this.getX()-1 > 0 && this.getX()-1 < 15 && this.getY() > 0 && this.getY() < 15) {
					x--;
				}
				break;
			} else {
				System.out.println("Please enter a valid direction.");
			}
		}
	}
}