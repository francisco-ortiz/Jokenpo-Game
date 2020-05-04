package br.com.jokenpo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class JokenpoException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public static final String PLAYER_ERROR_SAVE = "Player not saved";
	public static final String PLAYER_ERROR_NOT_FOUND = "Player not found";
	public static final String PLAYER_ERROR_ALREADY_EXIST = "Player name in use";
	public static final String MOVE_ERROR_SAVE = "Move no saved";
	public static final String MOVE_ERROR_ALREADY_PLAYED = "Already played";
	public static final String GAME_PLAYERS_ZERO = "Nobody playing";
	public static final String GAME_PLAYERS_INSUFFICIENT = "Insufficient players";
	public static final String GAME_MOVE_INSUFFICIENT = "Insufficient movements";
	public static final String GAME_MOVE_PENDING = "Pending movies from players";

	public JokenpoException(String message) {
		super(message);
	}

}
