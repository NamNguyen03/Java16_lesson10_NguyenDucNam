package controllers;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import models.Contexts;
import models.Player;

public class GameController {
	private List<Player> players;
	private List<Contexts> listContexts;
	private final long TIME_RESET_TOKEN = 15;
	private int RANGE_VALUE_RANDOM = 1000;
	private static GameController instance = null;

	private GameController() {
		super();
		players = new ArrayList<Player>();
		listContexts = new ArrayList<Contexts>();
	}

	public static GameController init() {
		if(instance == null) {
			instance = new GameController();
		}
		return instance;
	}

	public Player findPlayerByUsername(String username) {

		for(Player rs : players) {
			if(rs.getUsername().equals(username)) {
				return rs;
			}
		}

		return null;
	}

	public boolean login(String username) {

		Player player = findPlayerByUsername(username);

		if(player == null) {
			createPlayer(username);
			return true;
		}

		if(checkEpxToken(player)) {
			return false;
		}

		player = resetToken(player);

		return true;
	}

	public boolean checkEpxToken(Player player) {
		return LocalDateTime.now().isBefore(player.getExp());
	}

	public boolean checkToken(String username, int token) {
		Player player = findPlayerByUsername(username);
		if(player == null) {
			return false;
		}
		if(checkEpxToken(player)) {
			if(token == player.getToken()) {
				return true;
			}
		}
		return false;
	}

	private Player createPlayer(String username) {
		Player player = new Player();
		player.setUsername(username);
		player.setHighestScores(99999);
		player = resetToken(player);
		players.add(player);
		return player;
	}

	public Player resetToken(Player player) {
		Random rnd = new Random();
		player.setToken(rnd.nextInt());
		player.setExp(LocalDateTime.now().plusMinutes(TIME_RESET_TOKEN));
		return player;
	}

	public int getMinuteResetToken(String username) {

		LocalDateTime exp = findPlayerByUsername(username).getExp();

		LocalDateTime now = LocalDateTime.now();
		
		//because exp max value 15 minute
		if(exp.getHour() != now.getHour()) {
			return exp.getMinute() - now.getMinute() + 60;
		}

		return  exp.getMinute() - now.getMinute() ;
	}

	public boolean contextsExsist(String username) {
		for(Contexts c : listContexts) {
			if(c.getPlayer().getUsername().equals(username)) {
				return true;
			}
		}
		return false;
	}

	public Contexts findContextsByUsername(String username) {
		for(Contexts c : listContexts) {
			if(c.getPlayer().getUsername().equals(username)) {
				return c;
			}
		}
		return null;
	}

	public Contexts createContext(String username) {
		Contexts contexts = new Contexts();
		contexts.setPlayer(findPlayerByUsername(username));
		contexts.setScoresCurrent(0);
		Random rnd = new Random();
		contexts.setNumberCurrent(rnd.nextInt(RANGE_VALUE_RANDOM)+1);
		listContexts.add(contexts);
		return contexts;
	}

	public List<Player> getRank(){
		players.sort(Comparator.comparing(Player::getHighestScores));
		return players.stream().filter(item -> item.getHighestScores() != 99999).collect(Collectors.toList());
	}

	public void deleteContextsByUsername(String username) {
		Contexts contexts = findContextsByUsername(username);
		if(contexts !=null) {
			listContexts.remove(contexts);
		}

	}

	public void removeToken(String username) {
		Player player = findPlayerByUsername(username);
		player.setExp(LocalDateTime.now().minusMinutes(10));
		
	}
}
