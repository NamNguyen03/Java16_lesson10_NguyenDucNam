package models;

import java.time.LocalDateTime;

public class Player {
	private String username;
	private int token;
	private LocalDateTime exp;
	
	public Player() {
		super();
	}

	public Player(String username, int token, LocalDateTime exp) {
		super();
		this.username = username;
		this.token = token;
		this.exp = exp;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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
		return "Player [username=" + username +  ", token=" + token + ", exp=" + exp
				+ "]";
	}
	
	

	
}
