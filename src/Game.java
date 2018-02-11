public class Game {
	public static void main(String[] args){
		PlayerManager pm = new PlayerManager();
		pm.addPlayer();
		pm.setTraps();
		while(pm.getPlayers().size() != 1) {
			pm.move();
			pm.printPlayers();
		}
	}
}
