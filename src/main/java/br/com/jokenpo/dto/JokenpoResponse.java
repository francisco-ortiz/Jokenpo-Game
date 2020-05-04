package br.com.jokenpo.dto;

import java.sql.Timestamp;

import br.com.jokenpo.enumeration.EnumStatus;
import lombok.Data;

/**
 * @author Francisco Eduardo Ortiz
 * @version 1.0.0
 * @since 03/05/2020
 */
@Data
public class JokenpoResponse<T> {

	EnumStatus status;
	Timestamp timestamp;
	T data;

	public JokenpoResponse(EnumStatus status, T data) {

		this.status = status;
		this.timestamp = new Timestamp(System.currentTimeMillis());
		this.data = data;

	}

}
