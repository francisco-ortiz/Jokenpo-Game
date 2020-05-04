package br.com.jokenpo.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jokenpo.dto.Player;
import br.com.jokenpo.exception.JokenpoException;
import br.com.jokenpo.model.PlayerEntity;
import br.com.jokenpo.repository.PlayerRepository;
import lombok.extern.log4j.Log4j2;

/**
 * @author Francisco Eduardo Ortiz
 * @version 1.0.0
 * @since 03/05/2020
 */

@Log4j2
@Service
public class PlayerServiceImpl implements PlayerService {

	@Autowired
	private PlayerRepository playerRepository;

	@Transactional
	public Player save(Player player) throws JokenpoException {
		log.info("Save player");
		
		PlayerEntity playerEntity = playerRepository.findByNameContainingIgnoreCase(player.getName());
		
		if (playerEntity != null) 
			throw new JokenpoException(JokenpoException.PLAYER_ERROR_ALREADY_EXIST);

		playerEntity = playerRepository.save(new PlayerEntity(player.getName()));

		return new Player(playerEntity.getName());
	}

	@Transactional
	public void delete(Player player) {
		log.info("Delete player");
		
		playerRepository.delete(new PlayerEntity(player.getName()));
	}

	@Transactional
	public List<Player> findAll() {
		log.info("Find all players");

		List<PlayerEntity> playerEntityList = playerRepository.findAll();

		List<Player> playerList = new ArrayList<>();
		playerEntityList.forEach(player -> {
			playerList.add(new Player(player.getName()));
		});

		return playerList;
	}
	
	@Transactional
	public void deleteAll() {
		log.info("Delete all players");
		
		playerRepository.deleteAll();
	}
}
