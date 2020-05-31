import java.util.*;

public class Queen implements IQueen{
	private String name;
	private String type;
	private String local;
	private int numMaxiWins;
	private int numMiniWins;
	private int score;
	
	public Queen(){
		//Do nothing
	}
	
	public Queen(String name){
		this.name = name;
		this.score = 0;
	}
	
	public Queen(String name, String type){
		this.name = name;
		this.type = type;
		this.score = 0;
	}

	public Queen(String name, String type, String local){
		this.name = name;
		this.type = type;
		this.local = local;
	}
	
	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public String getLocal() {
		return local;
	}
	
	public List<String> getAllInfo() {
		List<String> info = new ArrayList<String>();
		info.add(name);
		info.add(type);
		info.add(local);
		
		return info;
	}

	public int getMaxiWins() {
		return numMaxiWins;
	}

	public void addMaxi() {
		numMaxiWins++;
		this.score = this.score + 10;
	}

	public int getMiniWins() {
		return numMiniWins;
	}

	public void addMini() {
		numMiniWins++;
		this.score = this.score + 3;
	}

	public void LipSync() {
		this.score = this.score - 3;
	}

	public void Top() {
		this.score++;
	}

	public void BotWithOutLip() {
		this.score--;
	}

	public int getScore() {
		return score;
	}
}
