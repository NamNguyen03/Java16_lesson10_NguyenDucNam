package models;

public class Contexts {
	private Player player;
	private int numberCurrent;
	private int scoresCurrent;
	
	public Contexts() {
		super();
	}

	public Contexts(Player player, int numberCurrent, int scoresCurrent) {
		super();
		this.player = player;
		this.numberCurrent = numberCurrent;
		this.scoresCurrent = scoresCurrent;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public int getNumberCurrent() {
		return numberCurrent;
	}

	public void setNumberCurrent(int numberCurrent) {
		this.numberCurrent = numberCurrent;
	}

	public int getScoresCurrent() {
		return scoresCurrent;
	}

	public void setScoresCurrent(int scoresCurrent) {
		this.scoresCurrent = scoresCurrent;
	}

	@Override
	public String toString() {
		return "Contexts [player=" + player.toString() + ", numberCurrent=" + numberCurrent + ", scoresCurrent=" + scoresCurrent
				+ "]";
	}
	
	
	
}
