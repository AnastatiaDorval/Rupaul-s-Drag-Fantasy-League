import java.io.FileNotFoundException;
import java.util.*;

public interface IDragFantasyLeague {
	void newWeek() throws FileNotFoundException; //this will read in a file for the newest week
	
	void teams(); //this will involve the draft
	
	List<Queen> getTheQueens() throws FileNotFoundException; //this will read in the file for contestants
	
	List<Player> addPlayer(Player p); //this will add a player until limit of num of players is reached
	
	IDragFantasyLeague newGame(Player p); //this will create a new instance of the game so more people can play
}
