package br.com.jokenpo.service;

import java.util.List;

import br.com.jokenpo.dto.Player;
import br.com.jokenpo.exception.JokenpoException;

/**
 * @author Francisco Eduardo Ortiz
 * @version 1.0.0
 * @since 03/05/2020
 */
public interface PlayerService {

	public Player save(Player player) throws JokenpoException;
	
	public void delete(Player player);
	
	public List<Player> findAll();
	
	public void deleteAll();
	
}
