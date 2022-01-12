package models;

import java.time.LocalDateTime;
import java.util.UUID;

public class Contexts {
	private UUID id;
	private Player player;
	private int numberCurrent;
	private int scoresCurrent;
	private LocalDateTime timePlay;
	private boolean isFinish;
	
	public Contexts() {
		super();
	}

	public Contexts(UUID id, Player player, int numberCurrent, int scoresCurrent, LocalDateTime timePlay,
			boolean isFinish) {
		super();
		this.id = id;
		this.player = player;
		this.numberCurrent = numberCurrent;
		this.scoresCurrent = scoresCurrent;
		this.timePlay = timePlay;
		this.isFinish = isFinish;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
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

	public LocalDateTime getTimePlay() {
		return timePlay;
	}

	public void setTimePlay(LocalDateTime timePlay) {
		this.timePlay = timePlay;
	}

	public boolean isFinish() {
		return isFinish;
	}

	public void setFinish(boolean isFinish) {
		this.isFinish = isFinish;
	}

	@Override
	public String toString() {
		return "Contexts [id=" + id + ", player={" + player.toString() + "}, numberCurrent=" + numberCurrent + ", scoresCurrent="
				+ scoresCurrent + ", timePlay=" + timePlay + ", isFinish=" + isFinish + "]";
	}
	
	
	
}
