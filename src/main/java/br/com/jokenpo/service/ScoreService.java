package br.com.jokenpo.service;

import java.util.List;

import br.com.jokenpo.dto.Score;
import br.com.jokenpo.exception.JokenpoException;

/**
 * @author Francisco Eduardo Ortiz
 * @version 1.0.0
 * @since 03/05/2020
 */
public interface ScoreService {

	public Score save(Score score) throws JokenpoException;
	
	public void delete(Score score);
	
	public List<Score> findAll();
	
	public void deleteAll();
	
}
