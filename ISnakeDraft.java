import java.util.*;

public interface ISnakeDraft {
	void addPlayer(Player player); //This adds player to the queue
	
	Map<Player, List<Queen>> draft(); //this creates teams of queens for the players
	
	List<Queen> addContestant(Queen queen); //this will create a list of queens from which the players will "pick"
}
