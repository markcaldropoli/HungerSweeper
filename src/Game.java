public class Game {
	public static void main(String[] args) throws InterruptedException {
		PlayerManager pm = new PlayerManager();
		pm.addPlayer();
		pm.setTraps();
		while(pm.getPlayers().size() != 1) {
			pm.move();
			pm.printPlayers();
		}
	}
}
