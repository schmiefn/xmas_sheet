package de.unistuttgart.iste.rss.oo.tictactoe.ui;

import de.unistuttgart.iste.rss.oo.tictactoe.logic.Player;
import de.unistuttgart.iste.rss.oo.tictactoe.logic.Symbol;
import de.unistuttgart.iste.rss.oo.tictactoe.logic.TicTacToeGame;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

/**
 * A tile is an UI object of which 9 are existing in the world of TicTacToe. Each tile stores its current symbol that is drawn
 * on itself and the row and the column in which the tile is located in the 3x3 matrix (each index starts with 0).
 * @author Fabian Schmierer
 *
 */
public class Tile extends Pane{
	private Symbol symbol;
	private TicTacToeGame game;
	private int row;
	private int column;
	
	/**
	 * Get the symbol that is drawn on this tile. If no symbol is drawn on the tile, Symbol.NONE will be returned
	 */
	public Symbol getSymbol () {
		return symbol;
	}
	
	/**
	 * Initalize the tile
	 * @param game TicTacToeGame object that administrates the whole game logic
	 * @param row row of the tile in the 3x3 matrix (starting with 0)
	 * @param column column of the tile in the 3x3 matrix (starting with 0)
	 */
	public Tile (final TicTacToeGame game, final int row, final int column) {
		this.row = row;
		this.column = column;
		this.game = game;
		this.symbol = Symbol.NONE;
		this.setStyle("-fx-border-color : black");
		this.setPrefSize(100, 100);
		this.setOnMouseClicked(e->handleInput());
	}
	
	
	private void handleInput() {
		Player activePlayer = game.getActivePlayer();
		if (symbol == Symbol.NONE && game.isGameInProgress()) {
			drawSymbol(activePlayer.getSymbol());
			game.setGameForNextMove(activePlayer.getSymbol(), row, column);
		}else {
			System.out.println("Cannot click");
		}
		
	}
	
	/**
	 * Draws a black cross on the current tile that fills the whole tile.
	 */
	private void drawCross () {
		Line line1 = new Line(0, this.getHeight(), this.getWidth(), 0);
		line1.setStyle("-fx-stroke-color : black");
		Line line2 = new Line(0,0, this.getWidth(),this.getHeight());
		line1.setStyle("-fx-stroke-color : black");
		this.getChildren().addAll(line1, line2);
	}
	
	/**
	 * Draws a black grey circle with black stroke on the current tile.
	 */
	private void drawCircle() {
		Circle circle = new Circle(this.getWidth()/2, this.getHeight()/2, this.getHeight()/2.1);
		circle.setFill(javafx.scene.paint.Color.WHITESMOKE);
		circle.setStroke(javafx.scene.paint.Color.BLACK);
		this.getChildren().add(circle);
	}
	
	/**
	 * Draw a symbol on this tile
	 * @param symbol Symbol that should be drawn. Should on have values CIRCLE or CROSS
	 */
	private void drawSymbol (Symbol symbol) {
		if (symbol == Symbol.CIRCLE) {
			drawCircle();
			this.symbol = Symbol.CIRCLE;
		}else if (symbol == Symbol.CROSS) {
			drawCross();
			this.symbol = Symbol.CROSS;
		}
	}
	
}
