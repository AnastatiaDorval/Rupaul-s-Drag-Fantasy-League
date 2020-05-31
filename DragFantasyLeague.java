import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class DragFantasyLeague implements IDragFantasyLeague {
	private ISnakeDraft sd;
	private List<Player> pl;
	private List<Queen> qs;
	final private int maxNumOfPlayers;
	private int currentWeek;
	private int currentSeason;

	DragFantasyLeague(int season) {
		sd = new SnakeDraft();
		qs = new ArrayList<Queen>();
		pl = new ArrayList<Player>();
		maxNumOfPlayers = 4;
		currentWeek = 1;
		currentSeason = season;
	}
	
	public void newWeek() throws FileNotFoundException{
		Scanner in = new Scanner(new File("Week " + currentWeek));
		
		while(in.hasNext()){
			while(!in.nextLine().equals("Bottom:")){
				if (in.nextLine().equals("Top")){
					in.nextLine();
					qs.get(qs.indexOf(in.nextLine())).Top();
				}
				qs.get(qs.indexOf(in.nextLine())).Top();
			}
			
			while(!in.nextLine().equals("Bottom 2:")){
				if (in.nextLine().equals("Bottom:")){
					in.nextLine();
					qs.get(qs.indexOf(in.nextLine())).BotWithOutLip();
				}
				qs.get(qs.indexOf(in.nextLine())).BotWithOutLip();
			}
			
			while(!in.nextLine().equals("Maxi Challenge Winner:")){
				if (in.nextLine().equals("Bottom 2:")){
					in.nextLine();
					qs.get(qs.indexOf(in.nextLine())).LipSync();
				}
				qs.get(qs.indexOf(in.nextLine())).LipSync();
			}
			
			if (in.nextLine().equals("Maxi Challenge Winner:")){
				in.nextLine();
				qs.get(qs.indexOf(in.nextLine())).addMaxi();
			}
			
			if (in.nextLine().equals("Mini Challenge Winner:")){
				in.nextLine();
				qs.get(qs.indexOf(in.nextLine())).addMini();
			}
		}
		
		currentWeek++;
	}

	public void teams() {
		for (Player p : pl.subList(0, pl.size()-1)){
			sd.addPlayer(p);
		}
		
		for (Queen q : qs.subList(0, qs.size()-1)){
			sd.addContestant(q);
		}
		
		sd.draft();
	}

	public List<Queen> getTheQueens() throws FileNotFoundException{
		Scanner in = new Scanner(new File("Season " + currentSeason + " Contestants"));
		
		in.nextLine();
		while (in.hasNext()){
			qs.add(new Queen(in.next(""+", "+""+", "+"")));
		}
		
		return qs;
	}

	public List<Player> addPlayer(Player p) {
		if (pl.size() < maxNumOfPlayers){
			sd.addPlayer(p);
			pl.add(p);
		}
		
		if (pl.size() == maxNumOfPlayers){
			this.newGame(p);
		}
		
		return pl;
	}

	public IDragFantasyLeague newGame(Player p) {
		IDragFantasyLeague dfl = new DragFantasyLeague(currentSeason);
		dfl.addPlayer(p);
		
		return dfl;
	}

}
