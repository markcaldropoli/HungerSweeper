/* 
 * Mark Caldropoli & Marc Shelton
 */

import java.util.Random;

public class Computer extends Player {
	private int x;
	private int y;
	private String name;
	private int health = 100;
	private int boundary = 6;
	private boolean isPlayer = false;
	
	public Computer(String name) {
		super(name);
		this.name = name;
		
		Random random = new Random();
		this.x = random.nextInt(6);
		this.y = random.nextInt(6);
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

	public int getBoundary() {
		return boundary;
	}

	public void setBoundary(int boundary) {
		this.boundary = boundary;
	}

	public void move() {
		while(true) {
			//random # 0=up, 1=down, 2=right, 3=left
			Random random = new Random();
			int rand = random.nextInt(4);
			
			if(rand == 0) {
				if(this.getX() >= 0 && this.getX() < boundary && this.getY()-1 >= 0 && this.getY()-1 < boundary) {
					y--;
					break;
				}
			} else if(rand == 1) {
				if(this.getX() >= 0 && this.getX() < boundary && this.getY()+1 >= 0 && this.getY()+1 < boundary) {
					y++;
					break;
				}
			} else if(rand == 2) {
				if(this.getX()+1 >= 0 && this.getX()+1 < boundary && this.getY() >= 0 && this.getY() < boundary) {
					x++;
					break;
				}
			} else if(rand == 3) {
				if(this.getX()-1 >= 0 && this.getX()-1 < boundary && this.getY() >= 0 && this.getY() < boundary) {
					x--;
					break;
				}
			}
		}
	}
	
	public boolean fight(Player a) {
		Random random = new Random();
		if(health - a.getHealth() <= -20){
			int rand = random.nextInt(6);
			if(rand == 0) return true;
			else return false;		
		}
		else if(health - a.getHealth() <= -10){
			int rand = random.nextInt(5);
			if(rand == 0) return true;
			else return false;
		}
		else if(health - a.getHealth() >= 0 && health - a.getHealth() <- 9){
			int rand = random.nextInt(4);
			if(rand == 0) return false ;
			else return true;	
		}
		else if(health - a.getHealth() >= 10){
			int rand = random.nextInt(5);
			if(rand == 0) return false;
			else return true;
		}
		else if(health - a.getHealth() >= 20){
			int rand = random.nextInt(6);
			if(rand == 0) return false;
			else return true;	
		}
		return false;
	}
	
	public void print(){
	}
	
	public boolean caughtTrap(Traps a){
		return a.caughtTrap(this, isPlayer);
	}

	public boolean isPlayer() {
		return isPlayer;
	}

	public void setPlayer(boolean isPlayer) {
		this.isPlayer = isPlayer;
	}
}
	
