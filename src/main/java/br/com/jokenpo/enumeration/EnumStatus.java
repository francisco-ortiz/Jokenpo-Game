package br.com.jokenpo.enumeration;

import java.io.Serializable;

/**
 * @author Francisco Eduardo Ortiz
 * @version 1.0.0
 * @since 03/05/2020
 */
public enum EnumStatus implements Serializable {
	
	ERROR,
	OK;
	
	public String getStatus() {
        return this.name();
    }

}
