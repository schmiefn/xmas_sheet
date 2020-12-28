package de.unistuttgart.iste.rss.oo.tictactoe.ui;

import de.unistuttgart.iste.rss.oo.tictactoe.logic.TicTacToeGame;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 * Class that represents the game window. The game windows contains a 3x3 Matrix of Tiles and a status box at the bottom.
 * The content of the status box can be changed.
 */
public class TicTacToeFrame extends Parent {

	private TicTacToeGame game;
	private Tile [][] field = new Tile[3][3];
	private BorderPane root;
	private TilePane myTilePane;
	private Label statusBox;
	
    /**
     * @param game TicTacToe game linked to this frame.
     */
    public TicTacToeFrame(final TicTacToeGame game) {
        super();
        this.game = game;
        getChildren().add(initializeFrame());
    }

    /**
     * Generates a sample JavaFX {@link Parent} object which displays two texts: "Hello Santa" and "Hohoho".
     * The frame (or call it windows) is setup here.
     * 
     * 
     * @return Generates {@link Parent} object.
     */
    private Parent initializeFrame() {
        // TODO: This is sample code and not needed for the exercise in general.
        //       It is just here to demonstrate a basic use case of JavaFX.
        root = new BorderPane();
        myTilePane = new TilePane();
        
        myTilePane.setPrefColumns(3);
        myTilePane.setPrefRows(3);
        
        statusBox = new Label();
        statusBox.setText("Hallo");
        root.setCenter(myTilePane);
        root.setBottom(statusBox);
        for (int i=0;i<3;i++) {
        	for (int j=0;j<3;j++) {
        		Tile tile = new Tile(game, i, j);
        		field[i][j] = tile;
        		myTilePane.getChildren().add(field[i][j]);
        	}
        }
        //final Text helloSanta = new Text("Hello Santa");
        //final Text hohoho = new Text("Hohoho");
        
        //root.setPadding(new Insets(16));
        //root.setSpacing(8);
        //root.getChildren().addAll(helloSanta, hohoho);
        return root;
    }
    
    /**
     * Sets the text of the message box at the bottom of the window
     * @param message The message that will be displayed by the UI. Do not make this message too long!
     */
    public void writeMessageOnUI (final String message) {
    	statusBox.setText(message);
    }

}
