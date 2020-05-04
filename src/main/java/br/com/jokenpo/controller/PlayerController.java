package br.com.jokenpo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jokenpo.dto.JokenpoResponse;
import br.com.jokenpo.dto.Player;
import br.com.jokenpo.enumeration.EnumStatus;
import br.com.jokenpo.exception.JokenpoException;
import br.com.jokenpo.service.PlayerServiceImpl;

/**
 * @author Francisco Eduardo Ortiz
 * @version 1.0.0
 * @since 03/05/2020
 */

@RestController
@RequestMapping("/player")
public class PlayerController {

	@Autowired
    private PlayerServiceImpl playerService;

    /**
     * @param player
     * @return
     */
    @PostMapping
    public ResponseEntity<Object> save(@Valid @RequestBody Player player) throws JokenpoException {    	
    	return ResponseEntity.ok(new JokenpoResponse<>(EnumStatus.OK, this.playerService.save(player)));    	
    }
    
    @DeleteMapping
    public ResponseEntity<Object> delete(@Valid @RequestBody Player player) throws JokenpoException {
    	
    	this.playerService.delete(player);
    	
    	return ResponseEntity.ok(new JokenpoResponse<>(EnumStatus.OK, "Excluido com sucesso"));
    }

    @GetMapping
    public ResponseEntity<Object> getAll() throws JokenpoException {
    	return ResponseEntity.ok(new JokenpoResponse<>(EnumStatus.OK, this.playerService.findAll()));
    } 	
}
