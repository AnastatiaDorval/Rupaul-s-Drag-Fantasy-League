public interface IQueen {
	String getName(); //returns name of queen
	
	String getType(); //returns type of queen
	
	String getLocal(); //returns were Queen's main scene is
	
	int getMaxiWins(); //returns Queen's number of maxi wins
	
	void addMaxi(); //adds to Queen's maxi wins
	
	int getMiniWins(); //returns Queen's number of mini wins
	
	void addMini(); //adds to Queen's mini wins
	
	void LipSync(); //returns Queen's score after lip syncing for life
	
	void Top(); //returns Queen's score after being in Top
	
	void BotWithOutLip(); //returns Queen's score total after being in bottom
	
	int getScore(); //returns Queen's total score
}
