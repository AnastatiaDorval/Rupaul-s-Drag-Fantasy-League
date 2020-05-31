import java.util.*;

public class Player implements IPlayer{
	private String name;
	private List<String> preferences;
	
	Player(String name){
		this.name = name;
		this.preferences = new ArrayList<String>();
	}
	
	Player(String name, List<String> prefers){
		this.name = name;
		this.preferences = prefers;
	}

	public String getName() {
		return this.name;
	}

	public List<String> getPreferences() {
		return preferences;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void addPreference(String prefer) {
		preferences.add(prefer);
	}

}
