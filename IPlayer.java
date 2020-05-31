import java.util.*;

public interface IPlayer {
	String getName(); //returns name of player
	
	List<String> getPreferences(); //returns the list of players' preferences
	
	void setName(String name); //changes name of the player
	
	void addPreference(String prefer); //adds to list of players' preferences
}
