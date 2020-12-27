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
 * 
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
        getChildren().add(generateRootNode());
    }

    /**
     * Generates a sample JavaFX {@link Parent} object which displays two texts: "Hello Santa" and "Hohoho".
     * 
     * @return Generates {@link Parent} object.
     */
    private Parent generateRootNode() {
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
    
    public void writeMessageOnUI (final String message) {
    	statusBox.setText(message);
    }

}
