public class Game {
	public static void main(String[] args){
		System.out.println("Welcome to the Arena! Watch your step for there are both traps and miracles hidden within this 4x4 battle stadium!");
		PlayerManager pm = new PlayerManager();
		pm.addPlayer();
		pm.setTraps();
		while(pm.getPlayers().size() != 1) {
			pm.update();
			if(pm.getPlayers().size() == 1){
				break;
			}
			pm.move();
			System.out.println("---------------------------");
			pm.printPlayers();
		}
		System.out.println("Congratulations! " + pm.getPlayers().get(0).getName() + ", you've won!!!!!!!");
	}
}
