package br.com.jokenpo.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
public class Move {

    @Size(min = 3)
    @NotNull(message = "Player name is empty")
    private String name;

    @Size(min = 4)
    @NotNull(message = "Movement is empty")
    private String move;
	
}
