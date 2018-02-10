import java.util.Random;

public class Computer extends Player {
	private int x;
	private int y;
	private String name;
	private int health = 100;
	
	public Computer(String name) {
		super(name);
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
		while(true) {
			//random # 0=up, 1=down, 2=right, 3=left
			Random random = new Random();
			int rand = random.nextInt(5);
			
			if(rand == 0) {
				if(this.getX() > 0 && this.getX() < 15 && this.getY()-1 > 0 && this.getY()-1 < 15) {
					y--;
					break;
				}
			} else if(rand == 1) {
				if(this.getX() > 0 && this.getX() < 15 && this.getY()+1 > 0 && this.getY()+1 < 15) {
					y++;
					break;
				}
			} else if(rand == 2) {
				if(this.getX()+1 > 0 && this.getX()+1 < 15 && this.getY() > 0 && this.getY() < 15) {
					x++;
					break;
				}
			} else if(rand == 3) {
				if(this.getX()-1 > 0 && this.getX()-1 < 15 && this.getY() > 0 && this.getY() < 15) {
					x--;
					break;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Computer p1 = new Computer("Mark");
		Computer p2 = new Computer("Marc");
		Computer p3 = new Computer("Logen");
		p1.setX(5);
		p1.setY(5);
		p2.setX(1);
		p2.setY(1);
		p3.setX(14);
		p3.setY(14);
		
		for(int i = 0; i < 10; i++) {
			System.out.println(p1.getName() + " " + p1.getX() + " " + p1.getY());
			p1.move();
			System.out.println(p1.getName() + " " + p1.getX() + " " + p1.getY());

			System.out.println(p2.getName() + " " + p2.getX() + " " + p2.getY());
			p2.move();
			System.out.println(p2.getName() + " " + p2.getX() + " " + p2.getY());
			
			System.out.println(p3.getName() + " " + p3.getX() + " " + p3.getY());
			p3.move();
			System.out.println(p3.getName() + " " + p3.getX() + " " + p3.getY());
		}
	}
}