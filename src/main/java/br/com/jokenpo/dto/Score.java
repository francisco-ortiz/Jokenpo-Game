package br.com.jokenpo.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

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
public class Score {

    @Size(min = 3)
    @NotNull(message = "Player name is empty")
    @JsonProperty(value = "name")
	private String name;
	
    @NotNull(message = "Score is empty")
    @JsonProperty(value = "score")
	private Long score;	

}
