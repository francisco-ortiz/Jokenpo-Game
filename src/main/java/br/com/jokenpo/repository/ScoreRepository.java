package br.com.jokenpo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.jokenpo.model.ScoreEntity;

/**
 * @author Francisco Eduardo Ortiz
 * @version 1.0.0
 * @since 03/05/2020
 */

@Repository
@Transactional
public interface ScoreRepository extends CrudRepository<ScoreEntity, String> {

	// Fetch winner player containing name with ignore case
	public ScoreEntity findByNameContainingIgnoreCase(@Param("name") String name);
	
	public void delete(ScoreEntity entity);

	public List<ScoreEntity> findAll();
	
}
