package br.com.jokenpo.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jokenpo.dto.Move;
import br.com.jokenpo.enumeration.EnumMove;
import br.com.jokenpo.exception.JokenpoException;
import br.com.jokenpo.model.MoveEntity;
import br.com.jokenpo.model.PlayerEntity;
import br.com.jokenpo.repository.MoveRepository;
import br.com.jokenpo.repository.PlayerRepository;
import lombok.extern.log4j.Log4j2;

/**
 * @author Francisco Eduardo Ortiz
 * @version 1.0.0
 * @since 03/05/2020
 */

@Log4j2
@Service
public class MoveServiceImpl implements MoveService {

	@Autowired
	private MoveRepository moveRepository;
	
	@Autowired
	private PlayerRepository playerRepository;

	@Transactional
	public Move saveMove(Move move) throws JokenpoException {
		log.info("Save moving");
		
		MoveEntity moveEntity = null;
		
		// Search the Player
		PlayerEntity playerEntity = playerRepository.findByNameContainingIgnoreCase(move.getName());
	
		if (playerEntity == null) 
				throw new JokenpoException(JokenpoException.PLAYER_ERROR_NOT_FOUND);
		
		// Search the Move
		moveEntity = moveRepository.findByNameContainingIgnoreCase(move.getName());
	
		if (moveEntity != null) 
				throw new JokenpoException(JokenpoException.MOVE_ERROR_ALREADY_PLAYED);		
		
		try {	
			
			moveEntity = moveRepository.save(new MoveEntity(playerEntity.getName(), EnumMove.getMoveByName(move.getMove())));
			
		} catch (Exception e) {
			
			log.error(e.getMessage());			
			throw new JokenpoException(JokenpoException.MOVE_ERROR_SAVE);
		}
		
		return new Move(moveEntity.getName(), moveEntity.getEnumMove().getName());
	}
	
	
	@Transactional
	public void delete(Move move) {
		log.info("Delete moving");
		
		PlayerEntity playerEntity = new PlayerEntity(move.getName());		
		
		MoveEntity moveEntity = new MoveEntity(playerEntity.getName(), EnumMove.getMoveByName(move.getMove()));
		
		moveRepository.delete(moveEntity);
	}

	@Transactional
	public List<Move> findAll() {
		log.info("Find all moving it");

		List<MoveEntity> moveEntityList = moveRepository.findAll();

		List<Move> moveList = new ArrayList<>();
		moveEntityList.forEach(move -> {
			moveList.add(new Move(move.getName(), move.getEnumMove().getName()));
		});

		return moveList;
	}
	
	@Transactional
	public void deleteAll() {
		log.info("Delete all moves");
		
		moveRepository.deleteAll();		
	}
	
}
