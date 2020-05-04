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
import br.com.jokenpo.dto.Move;
import br.com.jokenpo.enumeration.EnumStatus;
import br.com.jokenpo.exception.JokenpoException;
import br.com.jokenpo.service.MoveServiceImpl;

/**
 * @author Francisco Eduardo Ortiz
 * @version 1.0.0
 * @since 03/05/2020
 */

@RestController
@RequestMapping("/move")
public class MoveController {

	@Autowired
    private MoveServiceImpl moveService;

    /**
     * @param player
     * @return
     */
    @PostMapping(value = "")
    public ResponseEntity<Object> save(@Valid @RequestBody Move move) throws JokenpoException {
    	
    	//try {    	    	
    		return ResponseEntity.ok(new JokenpoResponse<>(EnumStatus.OK, this.moveService.saveMove(move))); 
    	//} catch (Exception e) {
    	//	return ResponseEntity.ok(new JokenpoResponse<>(EnumStatus.ERROR, JokenpoException.PLAYER_ERROR_SAVE));
    	//}
    }
    
    @DeleteMapping
    public ResponseEntity<Object> delete(@Valid @RequestBody Move move) throws JokenpoException {
    	
    	this.moveService.delete(move);
    	
    	return ResponseEntity.ok(new JokenpoResponse<>(EnumStatus.OK, "Excluido com sucesso"));
    }

    @GetMapping
    public ResponseEntity<Object> getAll() throws JokenpoException {
    	return ResponseEntity.ok(new JokenpoResponse<>(EnumStatus.OK, this.moveService.findAll()));
    }     
	
}
