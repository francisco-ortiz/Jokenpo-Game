package br.com.jokenpo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jokenpo.dto.JokenpoResponse;
import br.com.jokenpo.enumeration.EnumStatus;
import br.com.jokenpo.exception.JokenpoException;
import br.com.jokenpo.service.GameServiceImpl;

/**
 * @author Francisco Eduardo Ortiz
 * @version 1.0.0
 * @since 03/05/2020
 */

@RestController
@RequestMapping("/game")
public class GameController {

	@Autowired
	GameServiceImpl gameService;
	
	@DeleteMapping
    public ResponseEntity<Object> reset() throws JokenpoException {
   	
    	return ResponseEntity.ok(new JokenpoResponse<>(EnumStatus.OK, this.gameService.reset()));
    }
	
	@GetMapping
    public ResponseEntity<Object> start() throws JokenpoException {
   	
    	return ResponseEntity.ok(new JokenpoResponse<>(EnumStatus.OK, this.gameService.start()));
    }	
}
