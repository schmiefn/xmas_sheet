package de.unistuttgart.iste.rss.oo.tictactoe.logic;

public class Player {
	private final String name;
	private final Symbol symbol;
	
	public Player (final String name, final Symbol symbol) {
		this.name = name;
		this.symbol = symbol;
	}
	
	public String getName() {
		return name;
	}
	
	public Symbol getSymbol () {
		return symbol;
	}
}
