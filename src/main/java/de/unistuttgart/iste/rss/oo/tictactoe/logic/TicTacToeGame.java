 package de.unistuttgart.iste.rss.oo.tictactoe.logic;

import java.util.Optional;

import de.unistuttgart.iste.rss.oo.tictactoe.ui.TicTacToeFrame;
import de.unistuttgart.iste.rss.oo.tictactoe.ui.Tile;

public class TicTacToeGame {
	
	/**
	 * Folgende Attritube soll das TicTacToeGame-Objekt besitzen
	 */
	
	//Verwaltet das Spielfeld. An jeder Position des Array symbolisiert ein Wert des Symbol-Enums
	//welches Symbol die Kachel speichert (CROSS, CIRCLE oder NONE)
    private Symbol[][] field = new Symbol[3][3];
    
    //Damit gelangt man an das UI-Window
    private TicTacToeFrame frame;
    
    //Die beiden Spieler, die gegeneinander spielen
    private Player player1;
    private Player player2;
    
    //Der Spieler, der nun ein Symbol auf das Feld setzen soll
    private Player activePlayer;
    
    //Speichert, ob das Spiel noch läuft (kann wieder auf false gesetzt werden), sobald das Spiel vorbei ist
    private boolean isGameInProgress = false;
    
    /**
     * TODO: Initialisieren sie player1, player2, activePlayer und isGameInProgress mit sinnvollen Werten
     */
    public TicTacToeGame () {
    	initializeField();
    	
    	
    }

    /**
     * TODO: Initialisieren sie das Spielfeld mit sinnvollen Werten (Symbol.NONE). Die Operation wird aus
     * dem Konstruktor heraus aufgerufen.
     */
    private void initializeField() {
    	
    }
    
    /**
     * TODO: Vervollständigen Sie den Getter (er soll nur den Wert von isGameInProgress nach außen hin
     * zurückgeben). 
     */
    public boolean isGameInProgress() {
    	
    }
    
    
    public void setGameForNextMove(final Symbol inputSymbol, int row, int column) {	

    	
    }
    
   
    /**
     * TODO: Die Operation soll ein Optional zurückgeben, welches empty ist, wenn es keinen Gewinner
     * gibt und den Player speichern soll, der das Spiel gewonnen hat.
     */
    private Optional<Player> getWinner () {

    	
    }
    
    /**
     * TODO: Diese Operation soll den aktiven Spieler switchen. D.h. wenn Spieler1 momentan der aktive
     * Spieler ist, soll es nun Spieler2 sein.
     */
    private void toggleActivePlayer() {
    	
    }
    
    /**
     * TODO: Vervollständigen Sie den Getter (er soll nur das Objekt des zurückgeben, welches activePlayer
     * momentan referenziert). 
     */
    public Player getActivePlayer() {
    	
    }
    
    /**
     * TODO: Diese Operation soll true zurückgeben, wenn jede Kachel auf dem Spielfeld mit einem
     * Symbol belegt ist (also entweder Symbol.CIRCLE oder Symbol.CROSS).
     */
    private boolean isBoardFull () {
    	
    }
    
    /**
     * TODO: Wir übergeben eine Reihe "row" als Argument. Wir wollen in dieser Reihe schauen, ob
     * diese von einem Symbol "dominiert" wird. D.h. wenn sich in dieser Reihe drei Kreuze befinden,
     * wird Symbol.CROSS zurückgegeben (bei drei Kreisen wird Symbol.CIRCLE zurückgegeben). Gibt es
     * kein dominantes Symbol (also keine drei Kreuze oder Kreise) wird Symbol.NONE zurückgegeben.
     */
    private Symbol getDominantSymbolInRow (final int row) {
    	
    }
    
    /**
     * TODO: Implementieren Sie die Operation analog wie getDominantSymbolInRow. Der einzige Unterschied
     * besteht darin, dass wir jetzt eine Spalte absuchen. 
     */
    private Symbol getDominantSymbolInColumn (final int column) {
    		
    }
    
    /**
     * TODO: Implementieren Sie die Überprüfung der Diagonalen.
     */
    private Symbol getDominantSymbolDiagonal() {
    	
    }
    
    private Symbol getDominantSymbolInDiagonal() {
    	
    }
    	
    	
    
    private Symbol getDominantSymbolInDiagonal() {
    	
    }

    
    /**
     * Bitte nicht verändern!
     */
    public void giveMeMyFrame (final TicTacToeFrame frame) {
    	this.frame = frame;
    	System.out.println("Frame übergeben!");
    }
    
    /**
     * Bitte nicht verändern!
     * Sets the text of the message box at the bottom of the window
     * @param message The message that will be displayed by the UI. Do not make this message too long!
     */
    private void writeMessageOnUI(final String message) {
    		frame.writeMessageOnUI(message);
    }
    

}
