package br.com.jokenpo.enumeration;

import static java.util.Arrays.asList;

import java.util.Arrays;
import java.util.List;

/**
 * @author Francisco Eduardo Ortiz
 * @version 1.0.0
 * @since 03/05/2020
 */
public enum EnumMove {

	SPOCK("SPOCK"), 
	SCISSORS("SCISSORS"), 
	PAPER("PAPER"), 
	STONE("STONE"), 
	LIZARD("LIZARD");

	private String name;
	private List<EnumMove> weakness;

	EnumMove(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public List<EnumMove> getWeakness() {
		return weakness;
	}

	public void setWeakness(List<EnumMove> weakness) {
		this.weakness = weakness;
	}
	
	static {
		SPOCK.setWeakness(asList(LIZARD, PAPER));
		SCISSORS.setWeakness(asList(SPOCK, STONE));
		PAPER.setWeakness(asList(SCISSORS, LIZARD));
		STONE.setWeakness(asList(SPOCK, PAPER));
		LIZARD.setWeakness(asList(SCISSORS, STONE));
	}	

	public static EnumMove getMoveByName(String name) {
		for (EnumMove enumMove : Arrays.asList(EnumMove.values())) {
			if (name.equals(enumMove.getName())) {
				return enumMove;
			}
		}
    	throw new IllegalArgumentException("MOVE NOT FOUND.");
	}
}
