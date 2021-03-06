/* 
 * Mark Caldropoli & Marc Shelton
 */

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class PlayerManager {
	private ArrayList<Player> players = new ArrayList<>();
	private static Random ranGen = new Random();
	private ArrayList<Traps> traps = new ArrayList<>();
	private ArrayList<String> names = new ArrayList<>();

	public void setTraps() {
		Traps banana = new Traps("you slipped on a banana!", "Break your fall with you hand?", "Try to stand tall?", "You break your fall sucessfully!", "You fall and hit your head!", 20, false, 4);
		Traps mine = new Traps("you stepped on a mine!", "Slowly lift your foot?", "Put a rock to replace your foot and then move it?", "The mine doesn't go off", "The mine explodes under you!", 40, false, 4);
		Traps pit = new Traps("you fall into a pit that is filled with ants!", "Try to climb out?", "Try to stomp on the ants?", "Your hand slips and you fall into the ant pit", "You manage to kill most of the ants!", 14, true, 4);
		Traps avalance = new Traps("an avalance is coming down towards you!", "Run away?", "Hide behind a tree?", "You can't outrun the avalance and get crushed", "The tree blocks the debris!", 40, true, 4);
		Traps apple = new Traps("you see an apple in a tree!", "Try to climb the tree to get it?", "Ignore it?", "You fall on the ground, unable to grab an apple", "You continue on your merry way!", 4, true, 4);
		Traps panther = new Traps("you encounter a wild panther!", "Run away", "Try to pet it?", "The panther catches you and takes a bite?", "The panther purrs and leaves you alone!", 30, true, 4);
		Traps quicksand = new Traps("you've stepped in quicksand!", "Struggle", "Let it take you?", "You get sucked in and suffocate before finally escaping?", "The quicksand peacefully spits you out!", 14, true, 4);
		Traps arrow = new Traps("you've stepped on a pressure plate and see an arrow about to fly towards you!", "Duck?", "Try to catch it?", "It passes over your head!", "Why would you try to catch it and not duck? The arrow righty goes through your hand.", 24, false, 4);
		Traps button = new Traps("you see a button atop a pedestal with a neon sign above it that says DON'T PRESS!", "Press it?", "Don't press it?", "Acid sprays from the pedestal and burns your arm!", "Nice self control.", 44, true, 3);
		Miracle pool = new Miracle("you see a murky lake spread out in front of you.", "Go for a swim?", "Stay away?", "The pool rejuvinates you.", "You walk away from the pool.", 14, true, 4);
		Miracle button2 = new Miracle("you see a button atop a pedestal with a neon sign above it that says DON'T PRESS!", "Press it?", "Don't press it?", "An angelic light shines upon you and rejuivantes your health.", "Nice self control.", 44, true, 3);
		Traps shed = new Traps("you see a suuply shed in the middle of a clearing!", "Go inside?", "Leave it alone?", "The shed is filled with snakes and you get bitten!", "You leave the shed alone. Aren't you curious?", 10, true, 4);
		Miracle shed2 = new Miracle("you see a suuply shed in the middle of a clearing!", "Go inside?", "Leave it alone?", "The shed holds medical supplies and you heal yourself with them!", "You leave the shed alone. Aren't you curious?", 10, true, 3);
		Traps bearTrap = new Traps("a bear trap blocks your path!", "Carefully explain to it that you are not a bear?", "Carefully step around it?", "The bear trap disappears!", "You slip and get caught anyway!", 20, false, 4);
		Miracle tangerine = new Miracle("you find a tangerine on the ground!", "Throw it away?", "Eat it?","You throw the tangerine and it lands with a sad thud. It feels rejected.", "The tangerine makes you feel better!",  10, false, 4);
		Traps sawblades = new Traps("you've stepped on a pressure plate and sawblades approach on either side of you!", "Jump backward?", "Jump forward?", "You manage to dodge the blades!", "You barely manage to dodge but a blade cuts your leg", 34, false, 4);
		if(players.size() <= 4){
			traps.add(button);
			traps.add(button2);
			traps.add(shed);
			traps.add(shed2);
			checkSameTraps();
		}
		else{
			traps.add(banana);
			traps.add(mine);
			traps.add(pit);
			traps.add(avalance);
			traps.add(apple);
			traps.add(panther);
			traps.add(quicksand);
			traps.add(arrow);
			traps.add(pool);
			traps.add(bearTrap);
			traps.add(tangerine);
			traps.add(sawblades);
			checkSameTraps();
		}
	}

	public void setTraps2(){
		traps.clear();
		Traps button = new Traps("you see a button atop a pedestal with a neon sign above it that says DON'T PRESS!", "Press it?", "Don't press it?", "Acid sprays from the pedestal and burns your arm!", "Nice self control.", 44, true, 3);
		Miracle button2 = new Miracle("you see a button atop a pedestal with a neon sign above it that says DON'T PRESS!", "Press it?", "Don't press it?", "An angelic light shines upon you and rejuivantes your health.", "Nice self control.", 44, true, 3);
		Traps shed = new Traps("you see a suuply shed in the middle of a clearing!", "Go inside?", "Leave it alone?", "The shed is filled with snakes and you get bitten!", "You leave the shed alone. Aren't you curious?", 10, true, 4);
		Miracle shed2 = new Miracle("you see a suuply shed in the middle of a clearing!", "Go inside?", "Leave it alone?", "The shed holds medical supplies and you heal yourself with them!", "You leave the shed alone. Aren't you curious?", 10, true, 3);
		traps.add(button);
		traps.add(button2);
		traps.add(shed);
		traps.add(shed2);
		checkSameTraps();
	}

	public void removeTrap(Traps a) {
		int i;
		for(i = 0; i < traps.size(); i++) {
			if(traps.get(i).getDescription() == a.getDescription()) break;
		}
		players.remove(i);
	}

	public void checkSameTraps() {
		for(int i = 0; i < traps.size(); i++) {
			for(int j = i+1; j < traps.size(); j++) {
				if(traps.get(i).getX() == traps.get(j).getX()) {
					if(traps.get(i).getY() == traps.get(j).getY()) {
						int whoMove = (int) Math.random() * 2;
						if(whoMove == 0) {
							traps.get(i).move();
						}
						if(whoMove == 1) {
							traps.get(j).move();
						}
					}
				}
			}
		}
	}

	public void addPlayer() {
		@SuppressWarnings("resource")
		Scanner reader = new Scanner(System.in);
		int n = 0, c = 0;
		while(true) {
			System.out.println("The maximum amount of players is 12.");
			System.out.println("How many human players are there going to be?");
			n = reader.nextInt();
			reader.nextLine();
			if(n > 12) continue;
			break;
		}

		for(int i = 1; i < n+1; i++) {
			System.out.println("What is Player " + i + "'s name?");
			String p = reader.nextLine();
			players.add(new Player(p));
		}

		while(true) {
			if(n == 12) break;
			System.out.println("The maximum amount of players is 12. You have " + players.size() + " players so far.");
			System.out.println("How many computer players are there going to be?");
			c = reader.nextInt();
			if((c + n) > 12) continue;
			break;
		}

		for(int i = 0; i < c; i++) {	
			String p = getRandomFirstName();
			players.add(new Computer(p));
		}

		checkSame();
	}

	public void removePlayer(String name) {
		int i;
		for(i = 0; i < players.size(); i++) {
			if(players.get(i).getName() == name) break;
		}
		players.remove(i);
	}

	public String getRandomFirstName() {
		String name = "";
		if(Math.random() > 0.4) {
			while(true){
				name = maleFirstNames[ranGen.nextInt(maleFirstNames.length)];
				for(int i = 0; i < names.size(); i++){
					if(names.get(i) == name){
						continue;
					}
				}
				break;
			}
			names.add(name);
		} else {
			while(true){
				name = femaleFirstNames[ranGen.nextInt(femaleFirstNames.length)];
				for(int i = 0; i < names.size(); i++){
					if(names.get(i) == name){
						continue;
					}
				}
				break;
			}
			names.add(name);
		}
		return name;
	}

	public void printPlayers() {
		for(int i = 0; i < players.size(); i++) {
			System.out.println(players.get(i).getName() + " (" + players.get(i).getHealth() + " hp)");
		}
	}	


	public void update() {
		if(players.size() == 2 && players.get(0).getBoundary() > 2) {
			endFight(players.get(0), players.get(1));
		}
		else if(players.size() <= 4 && players.get(0).getBoundary() > 3) {
			System.out.println("The boundaries have shrunk to a 3x3!");
			System.out.println("Everyone has been transported within the boundaries!");
			for(int i = 0; i < players.size(); i++) {
				players.get(i).setBoundary(3);

				if(players.get(i).getX() >= 3) players.get(i).setX(2);
				if(players.get(i).getY() >= 3) players.get(i).setY(2);
			}
			setTraps2();
			checkSame2();
		}
	}

	public void checkSame() {
		for(int i = 0; i < players.size(); i++) {
			for(int j = i+1; j < players.size(); j++) {
				if(players.get(i).getX() == players.get(j).getX()) {
					if(players.get(i).getY() == players.get(j).getY()) {
						int whoMove = (int) Math.random() * 2;
						if(whoMove == 0) {
							players.get(i).print();
							players.get(i).move();
						}
						if(whoMove == 1) {
							players.get(i).print();
							players.get(j).move();
						}
					}
				}
			}
		}
	}

	public void checkSame2() {
		for(int i = 0; i < players.size(); i++) {
			for(int j = i+1; j < players.size(); j++) {
				if(players.get(i).getX() == players.get(j).getX()) {
					if(players.get(i).getY() == players.get(j).getY()) {
						fight(players.get(i), players.get(j));
					}
				}
			}
		}
	}

	public void move() {
		for(int i = 0; i < players.size(); i++) {
			players.get(i).move();
			for(int j = 0; j < traps.size(); j++) {
				if(players.get(i).getX() == traps.get(j).getX()) {
					if(players.get(i).getY() == traps.get(j).getY()) {
						if(players.get(i).caughtTrap(traps.get(j))) {
							removePlayer(players.get(i).getName());
						}
					}
				}
			}
		}
		for(int i = 0; i < players.size(); i++) {
			for(int j = i+1; j < players.size(); j++) {
				if(players.get(i).getX() == players.get(j).getX()) {
					if(players.get(i).getY() == players.get(j).getY()) {
						fight(players.get(i), players.get(j));
					}
				}
			}
		}
	}

	public ArrayList<Player> getPlayers() {
		return players;
	}

	public void fight(Player a, Player b) {
		boolean one;
		boolean two;
		if((!(a.isPlayer())) && (!(b.isPlayer()))){
			while(a.getHealth() > 0 && b.getHealth() > 0) {
				one = a.fight(b);
				two = b.fight(a);
				if(one == false && two == false) {
					int whoMove = (int) Math.random() * 2;
					if(whoMove == 0) a.move();
					if(whoMove == 1) b.move();
					break;
				}
				if(one == true) {
					int damage = (int) (Math.random() * 20 + 1);
					b.setHealth(b.getHealth() - damage);
					if(b.getHealth() <= 0) {
						System.out.println("---------------------------");
						System.out.println(a.getName() + " killed " + b.getName() + "!");
						removePlayer(b.getName());
						break;
					}
				}
				if(one == false) {
					int chance = (int) (Math.random() * 4);
					if(chance == 0) {
						a.move();
						break;
					}
				}
				try {
					Thread.sleep(1400);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if(two == true) {
					int damage = (int) (Math.random() * 20 + 1);
					a.setHealth(a.getHealth() - damage);
					if(a.getHealth() <= 0) {
						System.out.println("---------------------------");
						System.out.println(b.getName() + " killed " + a.getName() + "!");
						removePlayer(a.getName());
						break;
					}
				}
				if(two == false) {
					int chance = (int) (Math.random() * 4);
					if(chance == 0) {
						b.move();
						break;
					}
				}
			}
		}
		else{
			System.out.println("---------------------------");
			System.out.println("Two players have encountered each other! " + a.getName() + " and " + b.getName() + ", it's time to rumble!");
			while(a.getHealth() > 0 && b.getHealth() > 0) {
				one = a.fight(b);
				two = b.fight(a);
				if(one == false && two == false) {
					System.out.println("---------------------------");
					System.out.println("You both ran! Chickens!");
					int whoMove = (int) Math.random() * 2;
					if(whoMove == 0) a.move();
					if(whoMove == 1) b.move();
					break;
				}
				System.out.println("---------------------------");
				if(one == true) {
					System.out.println(a.getName() + " punches " + b.getName() + " in the face!");
					int damage = (int) (Math.random() * 20 + 1);
					System.out.println(b.getName() + " takes " + damage + " pts damage!");
					b.setHealth(b.getHealth() - damage);
					if(b.getHealth() <= 0) {
						System.out.println("---------------------------");
						System.out.println(a.getName() + " killed " + b.getName() + "!");
						removePlayer(b.getName());
						break;
					}
					System.out.println(b.getName() + " has " + b.getHealth() + " health left!");
				}
				if(one == false) {
					int chance = (int) (Math.random() * 4);
					if(chance == 0) {
						System.out.println("---------------------------");
						System.out.println(a.getName() + " has ran! Coward!");
						a.move();
						break;
					}
					else {
						System.out.println(a.getName() + " couldn't get away!");
					}
				}
				try {
					Thread.sleep(1400);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if(two == true) {
					System.out.println("---------------------------");
					System.out.println(b.getName() + " punches " +a.getName() + " in the face!");
					int damage = (int) (Math.random() * 20 + 1);
					System.out.println(a.getName() + " takes " + damage + " pts of damage!");
					a.setHealth(a.getHealth() - damage);
					if(a.getHealth() <= 0) {
						System.out.println("---------------------------");
						System.out.println(b.getName() + " killed " + a.getName() + "!");
						removePlayer(a.getName());
						break;
					}
					System.out.println(a.getName() + " has " + a.getHealth() + " health left!");
				}
				if(two == false) {
					int chance = (int) (Math.random() * 4);
					if(chance == 0) {
						System.out.println("---------------------------");
						System.out.println(b.getName() + " has ran! Coward!");
						b.move();
						break;
					}
					else {
						System.out.println("---------------------------");
						System.out.println(b.getName() + " couldn't get away!");
					}
				}
			}
		}
	}

		public void endFight(Player a, Player b){
			System.out.println("---------------------------");
			System.out.println("It's time for the final fight! " + a.getName() + " and " + b.getName() + ", it's the final showdown!");
			while(a.getHealth() > 0 && b.getHealth() > 0) {
				System.out.println("---------------------------");
				System.out.println(a.getName() + " punches " + b.getName() + " in the face!");
				int damage = (int) (Math.random() * 20 + 1);
				System.out.println(b.getName() + " takes " + damage + " pts damage!");
				b.setHealth(b.getHealth() - damage);
				if(b.getHealth() <= 0) {
					System.out.println("---------------------------");
					System.out.println(a.getName() + " killed " + b.getName() + "!");
					System.out.println("---------------------------");
					removePlayer(b.getName());
					break;
				}
				System.out.println(b.getName() + " has " + b.getHealth() + " health left!");
				try {
					Thread.sleep(1400);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("---------------------------");
				System.out.println(b.getName() + " punches " +a.getName() + " in the face!");
				damage = (int) (Math.random() * 20 + 1);
				System.out.println(a.getName() + " takes " + damage + " pts of damage!");
				a.setHealth(a.getHealth() - damage);
				if(a.getHealth() <= 0) {
					System.out.println("---------------------------");
					System.out.println(b.getName() + " killed " + a.getName() + "!");
					System.out.println("---------------------------");
					removePlayer(a.getName());
					break;
				}
				System.out.println(a.getName() + " has " + a.getHealth() + " health left!");
				try {
					Thread.sleep(1300);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

		private static String[] maleFirstNames = {
				"James", "John", "Robert", "Michael",
				"William", "David", "Richard", "Charles", "Joseph",
				"Thomas", "Christopher", "Daniel", "Paul", "Mark",
				"Donald", "George", "Kenneth", "Steven", "Edward",
				"Brian", "Ronald", "Anthony", "Kevin", "Jason",
				"Matthew", "Gary", "Timothy", "Jose", "Larry", "Jeffrey",
				"Frank", "Scott", "Eric", "Stephen", "Andrew", "Raymond",
				"Gregory", "Joshua", "Jerry", "Dennis", "Walter",
				"Patrick", "Peter", "Harold", "Douglas", "Henry", "Carl",
				"Arthur", "Ryan", "Roger", "Joe", "Juan", "Jack",
				"Albert", "Jonathan", "Justin", "Terry", "Gerald",
				"Keith", "Samuel", "Willie", "Ralph", "Lawrence",
				"Nicholas", "Roy", "Benjamin", "Bruce", "Brandon", "Adam",
				"Harry", "Fred", "Wayne", "Billy", "Steve", "Louis",
				"Jeremy", "Aaron", "Randy", "Howard", "Eugene",	"Carlos",
				"Russell", "Bobby", "Victor", "Martin", "Ernest",
				"Phillip", "Todd", "Jesse", "Craig", "Alan", "Shawn",
				"Clarence", "Sean", "Philip", "Chris", "Johnny", "Earl",
				"Jimmy", "Antonio", "Danny", "Bryan", "Tony", "Luis",
				"Mike", "Stanley", "Leonard", "Nathan", "Dale", "Manuel",
				"Rodney", "Curtis", "Norman", "Allen", "Marvin",
				"Vincent", "Glenn", "Jeffery", "Travis", "Jeff", "Chad",
				"Jacob", "Lee", "Melvin", "Alfred", "Kyle", "Francis",
				"Bradley", "Jesus", "Herbert", "Frederick", "Ray", "Joel",
				"Edwin", "Don", "Eddie", "Ricky", "Troy", "Randall",
				"Barry", "Alexander", "Bernard", "Mario", "Leroy",
				"Francisco", "Marcus", "Micheal", "Theodore", "Clifford",
				"Miguel", "Oscar", "Jay", "Jim", "Tom", "Calvin", "Alex",
				"Jon", "Ronnie", "Bill", "Lloyd", "Tommy", "Leon",
				"Derek", "Warren", "Darrell", "Jerome", "Floyd", "Leo",
				"Alvin", "Tim", "Wesley", "Gordon", "Dean", "Greg",
				"Jorge", "Dustin", "Pedro", "Derrick", "Dan", "Lewis",
				"Zachary", "Corey", "Herman", "Maurice", "Vernon",
				"Roberto", "Clyde", "Glen", "Hector", "Shane", "Ricardo",
				"Sam", "Rick", "Lester", "Brent", "Ramon", "Charlie",
				"Tyler", "Gilbert", "Gene", "Marc", "Reginald", "Ruben",
				"Brett", "Angel", "Nathaniel", "Rafael", "Leslie",
				"Edgar", "Milton", "Raul", "Ben", "Chester", "Cecil",
				"Duane", "Franklin", "Andre", "Elmer", "Brad", "Gabriel",
				"Ron", "Mitchell", "Roland", "Arnold", "Harvey", "Jared",
				"Adrian", "Karl", "Cory", "Claude", "Erik", "Darryl",
				"Jamie", "Neil", "Jessie", "Christian", "Javier",
				"Fernando", "Clinton", "Ted", "Mathew", "Tyrone",
				"Darren", "Lonnie", "Lance", "Cody", "Julio", "Kelly",
				"Kurt", "Allan", "Nelson", "Guy", "Clayton", "Hugh",
				"Max", "Dwayne", "Dwight", "Armando", "Felix", "Jimmie",
				"Everett", "Jordan", "Ian", "Wallace", "Ken", "Bob",
				"Jaime", "Casey", "Alfredo", "Alberto", "Dave", "Ivan",
				"Johnnie", "Sidney", "Byron", "Julian", "Isaac", "Morris",
				"Clifton", "Willard", "Daryl", "Ross", "Virgil", "Andy",
				"Marshall", "Salvador", "Perry", "Kirk", "Sergio",
				"Marion", "Tracy", "Seth", "Kent", "Terrance", "Rene",
				"Eduardo", "Terrence", "Enrique", "Freddie", "Wade"};

		private static String[] femaleFirstNames = {"Mary", "Patricia", "Linda",
				"Barbara", "Elizabeth", "Jennifer", "Maria", "Susan",
				"Margaret", "Dorothy", "Lisa", "Nancy", "Karen",
				"Betty", "Helen", "Sandra", "Donna", "Carol", "Ruth",
				"Sharon", "Michelle", "Laura", "Sarah", "Kimberly",
				"Deborah", "Jessica", "Shirley", "Cynthia", "Angela",
				"Melissa", "Brenda", "Amy", "Anna", "Rebecca",
				"Virginia", "Kathleen", "Pamela", "Martha", "Debra",
				"Amanda", "Stephanie", "Carolyn", "Christine", "Marie",
				"Janet", "Catherine", "Frances", "Ann", "Joyce", "Diane",
				"Alice", "Julie", "Heather", "Teresa", "Doris", "Gloria",
				"Evelyn", "Jean", "Cheryl", "Mildred", "Katherine",
				"Joan", "Ashley", "Judith", "Rose", "Janice", "Kelly",
				"Nicole", "Judy", "Christina", "Kathy", "Theresa",
				"Beverly", "Denise", "Tammy", "Irene", "Jane", "Lori",
				"Rachel", "Marilyn", "Andrea", "Kathryn", "Louise",
				"Sara", "Anne", "Jacqueline", "Wanda", "Bonnie", "Julia",
				"Ruby", "Lois", "Tina", "Phyllis", "Norma", "Paula",
				"Diana", "Annie", "Lillian", "Emily", "Robin", "Peggy",
				"Crystal", "Gladys", "Rita", "Dawn", "Connie", "Florence",
				"Tracy", "Edna", "Tiffany", "Carmen", "Rosa", "Cindy",
				"Grace", "Wendy", "Victoria", "Edith", "Kim", "Sherry",
				"Sylvia", "Josephine", "Thelma", "Shannon", "Sheila",
				"Ethel", "Ellen", "Elaine", "Marjorie", "Carrie",
				"Charlotte", "Monica", "Esther", "Pauline", "Emma",
				"Juanita", "Anita", "Rhonda", "Hazel", "Amber", "Eva",
				"Debbie", "April", "Leslie", "Clara", "Lucille", "Jamie",
				"Joanne", "Eleanor", "Valerie", "Danielle", "Megan",
				"Alicia", "Suzanne", "Michele", "Gail", "Bertha",
				"Darlene", "Veronica", "Jill", "Erin", "Geraldine",
				"Lauren", "Cathy", "Joann", "Lorraine", "Lynn", "Sally",
				"Regina", "Erica", "Beatrice", "Dolores", "Bernice",
				"Audrey", "Yvonne", "Annette", "June", "Samantha",
				"Marion", "Dana", "Stacy", "Ana", "Renee", "Ida",
				"Vivian", "Roberta", "Holly", "Brittany", "Melanie",
				"Loretta", "Yolanda", "Jeanette", "Laurie", "Katie",
				"Kristen", "Vanessa", "Alma", "Sue", "Elsie", "Beth",
				"Jeanne", "Vicki", "Carla", "Tara", "Rosemary", "Eileen",
				"Terri", "Gertrude", "Lucy", "Tonya", "Ella", "Stacey",
				"Wilma", "Gina", "Kristin", "Jessie", "Natalie", "Agnes",
				"Vera", "Willie", "Charlene", "Bessie", "Delores",
				"Melinda", "Pearl", "Arlene", "Maureen", "Colleen",
				"Allison", "Tamara", "Joy", "Georgia", "Constance",
				"Lillie", "Claudia", "Jackie", "Marcia", "Tanya",
				"Nellie", "Minnie", "Marlene", "Heidi", "Glenda",
				"Lydia", "Viola", "Courtney", "Marian", "Stella",
				"Caroline", "Dora", "Jo", "Vickie", "Mattie", "Terry",
				"Maxine", "Irma", "Mabel", "Marsha", "Myrtle", "Lena",
				"Christy", "Deanna", "Patsy", "Hilda", "Gwendolyn",
				"Jennie", "Nora", "Margie", "Nina", "Cassandra", "Leah",
				"Penny", "Kay", "Priscilla", "Naomi", "Carole", "Brandy",
				"Olga", "Billie", "Dianne", "Tracey", "Leona", "Jenny",
				"Felicia", "Sonia", "Miriam", "Velma", "Becky", "Bobbie",
				"Violet", "Kristina", "Toni", "Misty", "Mae", "Shelly",
				"Daisy", "Ramona", "Sherri", "Erika", "Katrina", "Claire",
				"Lindsey", "Lindsay", "Geneva", "Guadalupe", "Belinda",
				"Margarita", "Sheryl", "Cora", "Faye", "Ada", "Natasha",
				"Sabrina", "Isabel", "Marguerite", "Hattie", "Harriet",
				"Molly", "Cecilia", "Kristi", "Brandi", "Blanche",
				"Sandy", "Rosie", "Joanna", "Iris", "Eunice", "Angie",
				"Inez", "Lynda", "Madeline", "Amelia", "Alberta",
				"Genevieve", "Monique", "Jodi", "Janie", "Maggie",
				"Kayla", "Sonya", "Jan", "Lee", "Kristine", "Candace",
				"Fannie", "Maryann", "Opal", "Alison", "Yvette", "Melody",
				"Luz", "Susie", "Olivia", "Flora", "Shelley", "Kristy",
				"Mamie", "Lula", "Lola", "Verna", "Beulah", "Antoinette",
				"Candice", "Juana", "Jeannette", "Pam", "Kelli", "Hannah",
				"Whitney", "Bridget", "Karla", "Celia", "Latoya", "Patty",
				"Shelia", "Gayle", "Della", "Vicky", "Lynne", "Sheri",
				"Marianne", "Kara", "Jacquelyn", "Erma", "Blanca", "Myra",
				"Leticia", "Pat", "Krista", "Roxanne", "Angelica",
				"Johnnie", "Robyn", "Francis", "Adrienne", "Rosalie",
				"Alexandra", "Brooke", "Bethany", "Sadie", "Bernadette",
				"Traci", "Jody", "Kendra", "Jasmine", "Nichole",
				"Rachael", "Chelsea", "Mable", "Ernestine", "Muriel",
				"Marcella", "Elena", "Krystal", "Angelina", "Nadine",
				"Kari", "Estelle", "Dianna", "Paulette", "Lora", "Mona",
				"Doreen", "Rosemarie", "Angel", "Desiree", "Antonia",
				"Hope", "Ginger", "Janis", "Betsy", "Christie", "Freda",
				"Mercedes", "Meredith", "Lynette", "Teri", "Cristina",
				"Eula", "Leigh", "Meghan", "Sophia", "Eloise", "Rochelle",
				"Gretchen", "Cecelia", "Raquel", "Henrietta", "Alyssa",
				"Jana", "Kelley", "Gwen", "Kerry", "Jenna", "Tricia",
				"Laverne", "Olive", "Alexis", "Tasha", "Silvia", "Elvira",
				"Casey", "Delia", "Sophie", "Kate", "Patti", "Lorena",
				"Kellie", "Sonja", "Lila", "Lana", "Darla", "May",
				"Mindy", "Essie", "Mandy", "Lorene", "Elsa", "Josefina",
				"Jeannie", "Miranda", "Dixie", "Lucia", "Marta", "Faith",
				"Lela", "Johanna", "Shari", "Camille", "Tami", "Shawna",
				"Elisa", "Ebony", "Melba", "Ora", "Nettie", "Tabitha",
				"Ollie", "Jaime", "Winifred", "Kristie", "Marina",
				"Alisha", "Aimee", "Rena", "Myrna", "Marla", "Tammie",
				"Latasha", "Bonita", "Patrice", "Ronda", "Sherrie",
				"Addie", "Francine", "Deloris", "Stacie", "Adriana",
				"Cheri", "Shelby", "Abigail", "Celeste", "Jewel", "Cara",
				"Adele", "Rebekah", "Lucinda", "Dorthy", "Chris", "Effie",
				"Trina", "Reba", "Shawn", "Sallie", "Aurora", "Lenora",
				"Etta", "Lottie", "Kerri", "Trisha", "Nikki", "Estella",
				"Francisca", "Josie", "Tracie", "Marissa", "Karin",
				"Brittney", "Janelle", "Lourdes", "Laurel", "Helene",
				"Fern", "Elva", "Corinne", "Kelsey", "Ina", "Bettie",
				"Elisabeth", "Aida", "Caitlin", "Ingrid", "Iva",
				"Eugenia", "Christa", "Goldie", "Cassie", "Maude",
				"Jenifer", "Therese", "Frankie", "Dena", "Lorna",
				"Janette", "Latonya", "Candy", "Morgan", "Consuelo",
				"Tamika", "Rosetta", "Debora", "Cherie", "Polly", "Dina",
				"Jewell", "Fay", "Jillian", "Dorothea", "Nell", "Trudy",
				"Esperanza", "Patrica", "Kimberley", "Shanna", "Helena",
				"Carolina", "Cleo", "Stefanie", "Rosario", "Ola",
				"Janine", "Mollie", "Lupe", "Alisa", "Lou", "Maribel",
				"Susanne", "Bette", "Susana", "Elise", "Cecile",
				"Isabelle", "Lesley", "Jocelyn", "Paige", "Joni",
				"Rachelle", "Leola", "Daphne", "Alta", "Ester", "Petra",
				"Graciela", "Imogene", "Jolene", "Keisha", "Lacey",
				"Glenna", "Gabriela", "Keri", "Ursula", "Lizzie",
				"Kirsten", "Shana", "Adeline", "Mayra", "Jayne",
				"Jaclyn", "Gracie", "Sondra", "Carmela", "Marisa",
				"Rosalind", "Charity", "Tonia", "Beatriz", "Marisol",
				"Clarice", "Jeanine", "Sheena", "Angeline", "Frieda",
				"Lily", "Robbie", "Shauna", "Millie", "Claudette",
				"Cathleen", "Angelia", "Gabrielle", "Autumn", "Katharine",
				"Summer", "Jodie", "Staci", "Lea", "Christi", "Jimmie",
				"Justine", "Elma", "Luella", "Margret", "Dominique",
				"Socorro", "Rene", "Martina", "Margo", "Mavis", "Callie",
				"Bobbi", "Maritza", "Lucile", "Leanne", "Jeannine",
				"Deana", "Aileen", "Lorie", "Ladonna", "Willa", "Manuela",
				"Gale", "Selma", "Dolly", "Sybil", "Abby", "Lara", "Dale",
				"Ivy", "Dee", "Winnie", "Marcy", "Luisa", "Jeri",
				"Magdalena", "Ofelia", "Meagan", "Audra", "Matilda",
				"Leila", "Cornelia", "Bianca", "Simone", "Bettye",
				"Randi", "Virgie", "Latisha", "Barbra", "Georgina",			
				"Eliza", "Leann", "Bridgette", "Rhoda", "Haley", "Adela",
				"Nola", "Bernadine", "Flossie", "Ila", "Greta", "Ruthie",
				"Nelda", "Minerva", "Lilly", "Terrie", "Letha", "Hilary",
				"Estela", "Valarie", "Brianna", "Rosalyn", "Earline",
				"Catalina", "Ava", "Mia", "Clarissa", "Lidia", "Corrine",
				"Alexandria", "Concepcion", "Tia", "Sharron", "Rae",
				"Dona", "Ericka", "Jami", "Elnora", "Chandra", "Lenore",
				"Neva", "Marylou", "Melisa", "Tabatha", "Serena", "Avis",
				"Allie", "Sofia", "Jeanie", "Odessa", "Nannie",
				"Harriett", "Loraine", "Penelope", "Milagros", "Emilia",
				"Benita", "Allyson", "Ashlee", "Tania", "Tommie",
				"Esmeralda", "Karina", "Eve", "Pearlie", "Zelma",
				"Malinda", "Noreen", "Tameka", "Saundra", "Hillary",
				"Amie", "Althea", "Rosalinda", "Jordan", "Lilia",
				"Alana", "Gay", "Clare", "Alejandra", "Elinor", "Michael",
				"Lorrie", "Jerri", "Darcy", "Earnestine", "Carmella",
				"Taylor", "Noemi", "Marcie", "Liza", "Annabelle",
				"Louisa", "Earlene", "Mallory", "Carlene", "Nita",
				"Selena", "Tanisha", "Katy", "Julianne", "John",
				"Lakisha", "Edwina", "Maricela", "Margery", "Kenya",
				"Dollie", "Roxie", "Roslyn", "Kathrine", "Nanette",
				"Charmaine", "Lavonne", "Ilene", "Kris", "Tammi",
				"Suzette", "Corine", "Kaye", "Jerry", "Merle", "Chrystal",
				"Lina", "Deanne", "Lilian", "Juliana", "Aline", "Luann",
				"Kasey", "Maryanne", "Evangeline", "Colette", "Melva",
				"Lawanda", "Yesenia", "Nadia", "Madge", "Kathie", "Eddie",
				"Ophelia", "Valeria", "Nona", "Mitzi", "Mari",
				"Georgette", "Claudine", "Fran", "Alissa", "Roseann",
				"Lakeisha", "Susanna", "Reva", "Deidre", "Chasity",
				"Sheree", "Carly", "James", "Elvia", "Alyce", "Deirdre",
				"Gena", "Briana", "Araceli", "Katelyn", "Rosanne",
				"Wendi", "Tessa", "Berta", "Marva", "Imelda", "Marietta",
				"Marci", "Leonor", "Arline", "Sasha", "Madelyn", "Janna",
				"Juliette", "Deena", "Aurelia", "Josefa", "Augusta",
				"Liliana", "Young", "Christian", "Lessie", "Amalia",
				"Savannah", "Anastasia", "Vilma", "Natalia", "Rosella",
				"Lynnette", "Corina", "Alfreda", "Leanna", "Carey",
				"Amparo", "Coleen", "Tamra", "Aisha", "Wilda", "Karyn",
				"Cherry", "Queen", "Maura", "Mai", "Evangelina",
				"Rosanna", "Hallie", "Erna", "Enid", "Mariana", "Lacy",
				"Juliet", "Jacklyn", "Freida", "Madeleine", "Mara",
				"Hester", "Cathryn", "Lelia", "Casandra", "Bridgett",
				"Angelita", "Jannie", "Dionne", "Annmarie", "Katina",
				"Beryl", "Phoebe", "Millicent", "Katheryn", "Diann",
				"Carissa", "Maryellen", "Liz", "Lauri", "Helga", "Gilda",
				"Adrian", "Rhea", "Marquita", "Hollie", "Tisha", "Tamera",
				"Angelique", "Francesca", "Britney", "Kaitlin", "Lolita",
				"Florine", "Rowena", "Reyna", "Twila", "Fanny", "Janell",
				"Ines", "Concetta", "Bertie", "Alba", "Brigitte",
				"Alyson", "Vonda", "Pansy", "Elba", "Noelle", "Letitia",
				"Kitty", "Deann", "Brandie", "Louella", "Leta", "Felecia",
				"Sharlene", "Lesa", "Beverley", "Roberta", "Isabella",
				"Herminia", "Terra", "Celina"};
	}

