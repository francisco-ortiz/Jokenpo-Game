package br.com.jokenpo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
@Entity
@Table(name = "tb_player")
public class PlayerEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @Column(name = "name", length = 40)
	private String name;

}
