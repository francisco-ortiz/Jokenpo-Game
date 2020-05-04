package br.com.jokenpo.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jokenpo.dto.Score;
import br.com.jokenpo.exception.JokenpoException;
import br.com.jokenpo.model.ScoreEntity;
import br.com.jokenpo.repository.ScoreRepository;
import lombok.extern.log4j.Log4j2;

/**
 * @author Francisco Eduardo Ortiz
 * @version 1.0.0
 * @since 03/05/2020
 */

@Log4j2
@Service
public class ScoreServiceImpl implements ScoreService {

	@Autowired
	private ScoreRepository scoreRepository;

	@Transactional
	public Score save(Score score) throws JokenpoException {
		log.info("Save score");
		
		ScoreEntity scoreEntity = scoreRepository.findByNameContainingIgnoreCase(score.getName());
		
		if (scoreEntity != null) {
			scoreEntity.setScore(scoreEntity.getScore() + 1L);
			scoreEntity = scoreRepository.save(scoreEntity);
		} else {
			scoreEntity = scoreRepository.save(new ScoreEntity(score.getName(), 1L));
		}

		return new Score(scoreEntity.getName(), scoreEntity.getScore());
	}

	@Transactional
	public void delete(Score score) {
		log.info("Delete score");
		
		scoreRepository.deleteById(score.getName());
	}

	@Transactional
	public List<Score> findAll() {
		log.info("Find all scores");

		List<ScoreEntity> scoreEntityList = scoreRepository.findAll();

		List<Score> scoreList = new ArrayList<>();
		scoreEntityList.forEach(score -> {
			scoreList.add(new Score(score.getName(), score.getScore()));
		});

		return scoreList;
	}
	
	@Transactional
	public void deleteAll() {
		log.info("Delete all scores");
		
		scoreRepository.deleteAll();
	}
}
