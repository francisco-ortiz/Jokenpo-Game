package br.com.jokenpo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jokenpo.dto.Move;
import br.com.jokenpo.dto.Player;
import br.com.jokenpo.dto.Score;
import br.com.jokenpo.dto.ScoreBoard;
import br.com.jokenpo.enumeration.EnumMove;
import br.com.jokenpo.exception.JokenpoException;
import lombok.extern.log4j.Log4j2;

/**
 * @author Francisco Eduardo Ortiz
 * @version 1.0.0
 * @since 03/05/2020
 */
@Log4j2
@Service
public class GameServiceImpl implements GameService {

	@Autowired
	private PlayerServiceImpl playerService;	
	
	@Autowired
	private MoveServiceImpl moveService;
	
	@Autowired
	private ScoreServiceImpl scoreService;  
	
    private static final String WINNER_ZERO = "ZERO WINNER !";
    private static final String WINNER_ONLY = "THE WINNER: ";
    private static final String WINNER_MANY = "THE WINNERS: ";
	
    /**
     * Resets all game data.
     */
    public List<Player> reset() throws JokenpoException {
        log.info("Reset all data");
        
        moveService.deleteAll();
        playerService.deleteAll();

        return this.playerService.findAll();
    };
    
    /**
     * Checks all needs to play the game.
     * 
     * @throws JokenpoException
     */
    private void checkGame() throws JokenpoException {
    	log.info("Check game");
    	
        if(this.playerService.findAll().size() == 0){
            throw new JokenpoException(JokenpoException.GAME_PLAYERS_ZERO);
        } else if (this.playerService.findAll().size() <= 1){
            throw new JokenpoException(JokenpoException.GAME_PLAYERS_INSUFFICIENT);
        } else if (this.moveService.findAll().size() <= 1){
            throw new JokenpoException(JokenpoException.GAME_MOVE_INSUFFICIENT);
        } else if (this.moveService.findAll().size() != this.playerService.findAll().size()){
            throw new JokenpoException(JokenpoException.GAME_MOVE_PENDING);
        }
    }  
    
    /**
     * Check for weaknesses to define the winner.
     * 
     * @param weakness
     * @return
     * @throws JokenpoException
     */
    private Boolean checkWinner(List<EnumMove> weakness) throws JokenpoException {
    	log.info("Check fo weanesses");
    	
        for (EnumMove enumMove : weakness) {
        	
        	log.info("Check Weaness: {}", enumMove.getName());

            for(Move move : this.moveService.findAll()) {
            	// If the weakness is the same of the other player moving, then game over.
                if(move.getMove().compareTo(enumMove.getName()) == 0) {
                	log.info("Player loser: {} moving {} ", move.getName(), enumMove.getName());
                    return false;
                }
            }
        }
        
        log.info("Player winner detected");
        return true;
    }    
    
    /**
     * Generate scores. 
     * @return
     */
    private void generateScore( ) {
    	log.info("Generate score");
    	   	
    	this.moveService.findAll().forEach(move -> {  
    		try {
    			if(checkWinner(EnumMove.getMoveByName(move.getMove()).getWeakness())) {
    				scoreService.save(new Score(move.getName(), 1L));
    			}
    		} catch (JokenpoException e) {
            	log.error("Error generating score with Gamer: {}", move.getName());
            	log.error("Error message: {}", e.getMessage());
            }
        });
    }
    
    /**
     * Generate scoreboard.
     * @return
     */
    private ScoreBoard scoreboard() {
    	log.info("Generate scoreboard");
    	
    	ScoreBoard scoreboard = new ScoreBoard();
    	
		scoreboard.setHistory(new ArrayList<>());
		scoreboard.setWinner(new ArrayList<>());
    	
    	List<Score> listScore = this.scoreService.findAll();
    	
    	// Get Score Winners
    	if (listScore == null) {
    		scoreboard.setStatusWinner(WINNER_ZERO);
    	} else {    		
    		int idxScore = listScore.size();
    		
    		if (idxScore == 0) {
    			scoreboard.setStatusWinner(WINNER_ZERO);
    		}
    		else if (idxScore == 1) {
    			scoreboard.setStatusWinner(WINNER_ONLY);
    			scoreboard.getWinner().add(listScore.get(0).getName().toUpperCase());
    		}
	    	else {  
    			scoreboard.setStatusWinner(WINNER_MANY);
	    		
	    		for(Score score : listScore)  
	    			scoreboard.getWinner().add(score.getName().toUpperCase());	    		
	    	}  
    	}
    	
    	// Get History
    	scoreboard.setHistory(this.moveService.findAll());

        return scoreboard;
    }    

    /**
     * Start the Game.
     */
    public ScoreBoard start() throws JokenpoException {
    	log.info("Start the Game");
    	
    	// Check if all is right.
    	this.checkGame();
    	
    	// Generate scores.
    	this.generateScore();
    	
    	// Generate scoresboard.
    	ScoreBoard scoreboard = this.scoreboard();
  
    	// Reset the game to start.
    	this.reset();
    	
    	log.info("Game Over");
    	
    	return scoreboard;
    };

}
