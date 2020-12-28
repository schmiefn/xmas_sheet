package de.unistuttgart.iste.rss.oo.tictactoe.logic;

import java.util.Optional;

import de.unistuttgart.iste.rss.oo.tictactoe.ui.TicTacToeFrame;
import de.unistuttgart.iste.rss.oo.tictactoe.ui.Tile;

public class TicTacToeGame {
	
    private Symbol[][] field = new Symbol[3][3];
    private TicTacToeFrame frame;
    private Player player1;
    private Player player2;
    
    private Player activePlayer;
    
    private boolean isGameInProgress = false;
    
    public TicTacToeGame () {
    	initializeField();
    	
    	player1 = new Player("Fabian", Symbol.CROSS);
    	player2 = new Player("Tobias", Symbol.CIRCLE);
    	activePlayer = player1;
    	isGameInProgress = true;
    }

    private void initializeField() {
    	for (int i=0;i<3;i++) {
    		for (int j=0;j<3;j++) {
    			field[i][j] = Symbol.NONE;
    		}
    	}
    }
    
    public void setGameForNextMove(final Symbol inputSymbol, int row, int column) {	
    	field[row][column] = inputSymbol; 
    	Optional<Player> winner = getWinner();
    	if (!winner.isEmpty()) {
    		isGameInProgress = false;
    		writeMessageOnUI(winner.get().getName()+" hat gewonnen!");
    	}else if (isBoardFull()) {
    		isGameInProgress = false;
    		writeMessageOnUI("Unentschieden!");
    	}
    	
    	if (isGameInProgress) {
    		toggleActivePlayer();
    		writeMessageOnUI(activePlayer.getName() +" muss spielen!");	
    	}
    	
    }
    
    private void writeMessageOnUI(final String message) {
    	if (frame!=null) {
    		frame.writeMessageOnUI(message);
    	}else {
    		System.out.println("frame == null");
    	}
    	
    }
    
    private Optional<Player> getWinner () {
    	Optional<Player> player = Optional.empty();
    	Symbol rowSymbol = Symbol.NONE;
    	Symbol columnSymbol = Symbol.NONE;
    	Symbol diagonalSymbol = Symbol.NONE;
    	for (int i=0;i<3;i++) {
    		rowSymbol = getDominantSymbolInRow(i);
    		columnSymbol = getDominantSymbolInColumn(i);
    		diagonalSymbol = getDominantSymbolInDiagonal();
    		if (rowSymbol == Symbol.CIRCLE || columnSymbol == Symbol.CIRCLE || diagonalSymbol == Symbol.CIRCLE) {
    			System.out.println("Circle win");
        		return(Optional.of(player2));
        	}
        	if (rowSymbol == Symbol.CROSS || columnSymbol == Symbol.CROSS || diagonalSymbol == Symbol.CROSS) {
        		System.out.println("Cross win");
        		return(Optional.of(player1));
        	}
    	}
    	
    	return player;
    }
    
    private void toggleActivePlayer() {
    	if (activePlayer == player1) {
    		activePlayer = player2;
    	}else {
    		activePlayer = player1;
    	}
    }
    
    public Player getActivePlayer() {
    	return activePlayer;
    }
    
    
    private boolean isBoardFull () {
    	for (int i=0;i<3;i++) {
    		for (int j=0;j<3;j++) {
    			if (field[i][j]==Symbol.NONE) {
    				return false;
    			}
    		}
    	}
    	return true;
    }
    
    private Symbol getDominantSymbolInRow (final int row) {
    	int checksum = 0;
    	for (int column=0;column<3;column++) {
    		if (field[row][column] == Symbol.CIRCLE) {
    			checksum ++;
    		}else if (field[row][column] == Symbol.CROSS) {
    			checksum--;
    		}
    	}
    	if (checksum == 3) {
    		System.out.println("Dominant circle row");
    		return Symbol.CIRCLE;
    	}else if (checksum == -3) {
    		System.out.println("Dominant cross row");
    		return Symbol.CROSS;
    	}else {
    		return Symbol.NONE;
    	}	
    }
    
    private Symbol getDominantSymbolInColumn (final int column) {
    	int checksum = 0;
    	for (int row=0;row<3;row++) {
    		if (field[row][column] == Symbol.CIRCLE) {
    			checksum ++;
    		}else if (field[row][column] == Symbol.CROSS) {
    			checksum--;
    		}
    	}
    	if (checksum == 3) {
    		return Symbol.CIRCLE;
    	}else if (checksum == -3) {
    		System.out.println("dominant cross column");
    		return Symbol.CROSS;
    	}else {
    		return Symbol.NONE;
    	}	
    }
    
    private Symbol getDominantSymbolInDiagonal() {
    	int checksum = 0;
    	for (int i=0;i<3;i++) {
    		if (field[i][i]==Symbol.CIRCLE) {
    			checksum++;
    		}else if (field[i][i]==Symbol.CROSS) {
    			checksum--;
    		}
    	}
    	
    	if (checksum==3) {
    		return Symbol.CIRCLE;
    	}else if (checksum==-3) {
    		return Symbol.CROSS;
    	}
    	checksum=0;
    	for (int i=0;i<3;i++) {
    		if (field[2-i][i]==Symbol.CIRCLE) {
    			checksum++;
    		}else if (field[2-i][i]==Symbol.CROSS) {
    			checksum--;
    		}
    	}
    	
    	if (checksum==3) {
    		return Symbol.CIRCLE;
    	}else if (checksum==-3) {
    		return Symbol.CROSS;
    	}else {
    		return Symbol.NONE;
    	}
    }

    public void giveMeMyFrame (final TicTacToeFrame frame) {
    	this.frame = frame;
    	System.out.println("Frame übergeben!");
    }
    
    public boolean isGameInProgress() {
    	return isGameInProgress;
    }

}
