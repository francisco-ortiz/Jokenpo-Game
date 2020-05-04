package br.com.jokenpo.service;

import java.util.List;

import br.com.jokenpo.dto.Move;
import br.com.jokenpo.exception.JokenpoException;

/**
 * @author Francisco Eduardo Ortiz
 * @version 1.0.0
 * @since 03/05/2020
 */
public interface MoveService {

	public Move saveMove(Move move) throws JokenpoException;
	
	public void delete(Move move);
	
	public List<Move> findAll();
	
	public void deleteAll();
	
}
