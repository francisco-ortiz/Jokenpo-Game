package br.com.jokenpo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.jokenpo.model.PlayerEntity;

/**
 * @author Francisco Eduardo Ortiz
 * @version 1.0.0
 * @since 03/05/2020
 */

@Repository
@Transactional
public interface PlayerRepository extends CrudRepository<PlayerEntity, String> {

	// Fetch player containing name with ignore case
	public PlayerEntity findByNameContainingIgnoreCase(@Param("name") String name);
	
	public void delete(PlayerEntity entity);

	public List<PlayerEntity> findAll();
	
}
