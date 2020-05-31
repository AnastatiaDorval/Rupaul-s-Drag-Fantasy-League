import java.util.*;


public class SnakeDraft implements ISnakeDraft {
	private Queue<Player> game;
	private List<Queen> pool;
	
	SnakeDraft() {
		game = new LinkedList<Player>();
		pool = new LinkedList<Queen>();
	}
	
	public void addPlayer(Player player) {
		game.add(player);
	}

	public Map<Player, List<Queen>> draft() {
		Map<Player, List<Queen>> d = new HashMap<Player, List<Queen>>(); //to be returned with players chosen Queens for given round
		Player curr = game.poll(); //will be updated in while loop
		Map<Queen, Integer> matches = new HashMap<Queen, Integer>(); //to keep track of how many matches each queen has
		
		for (int i = 0; i < game.size(); i++){ //this is to add every player to the draft before they actually "pick" their queens
			d.put(curr, new ArrayList<Queen>());
			game.add(curr);
			curr = game.poll();
		}
		
		while (!pool.isEmpty()){
			int match = 0; //keeps track of the num of matches between Queen characteristics and player preferences
			int max = 0; //keeps track of max num of matches
			int prev; //for later when you need to compare values to find max
			
			for(Queen q : pool.subList(0, pool.size()-1)){ //goes through each of the queens
				for(String p : curr.getPreferences()) { //goes through each players' preferences
					for(String c : q.getAllInfo()){ //goes through every characteristic of specified queen
						if(p.toLowerCase().equals(c.toLowerCase())) //compares player's preference with queen's characteristics
							match++;
					}
					
					matches.put(q, match);
				}
			}
			
			for (Queen q : matches.keySet()){ //find queen with maximum number of player preference matches
				prev = matches.get(q);
				if (prev >= max)
					max = prev;
			}
			
			for (Queen q : matches.keySet()){ //adding queen with maximum number of matches
				if(matches.get(q) == max){
					d.get(curr).add(q);
					pool.remove(q);
				}
			}
			
			game.add(curr);
			curr = game.poll();
		}
		
		return d;
	}

	public List<Queen> addContestant(Queen queen) {
		pool.add(queen);
		return pool;
	}

}
