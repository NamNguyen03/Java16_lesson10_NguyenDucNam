package models;

import java.time.LocalDateTime;

public class Player {
	private String username;
	private int highestScores;
	private int token;
	private LocalDateTime exp;
	
	public Player() {
		super();
	}

	public Player(String username, int highestScores, int token, LocalDateTime exp) {
		super();
		this.username = username;
		this.highestScores = highestScores;
		this.token = token;
		this.exp = exp;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getHighestScores() {
		return highestScores;
	}

	public void setHighestScores(int highestScores) {
		this.highestScores = highestScores;
	}

	public int getToken() {
		return token;
	}

	public void setToken(int token) {
		this.token = token;
	}

	public LocalDateTime getExp() {
		return exp;
	}

	public void setExp(LocalDateTime exp) {
		this.exp = exp;
	}

	@Override
	public String toString() {
		return "Player [username=" + username + ", highestScores=" + highestScores + ", token=" + token + ", exp=" + exp
				+ "]";
	}
	
	

	
}
