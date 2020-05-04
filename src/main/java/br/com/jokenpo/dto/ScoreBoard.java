package br.com.jokenpo.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Francisco Eduardo Ortiz
 * @version 1.0.0
 * @since 03/05/2020
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScoreBoard {
	
	String statusWinner;

	List<String> winner;
	
	List<Move> history;
	
}
