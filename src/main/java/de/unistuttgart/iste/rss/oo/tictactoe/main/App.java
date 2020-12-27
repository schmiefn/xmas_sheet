package de.unistuttgart.iste.rss.oo.tictactoe.main;

import de.unistuttgart.iste.rss.oo.tictactoe.logic.TicTacToeGame;
import de.unistuttgart.iste.rss.oo.tictactoe.ui.TicTacToeFrame;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Main class which starts the app.
 */
public class App extends Application {

    @Override
    public void start(final Stage primaryStage) throws Exception {
        final TicTacToeGame game = new TicTacToeGame();
        final TicTacToeFrame frame = new TicTacToeFrame(game);
        final Scene defaultScene = new Scene(frame);
        game.giveMeMyFrame(frame);

        primaryStage.setTitle("XMas TicTacToe");
        primaryStage.setWidth(316);
        primaryStage.setHeight(360);
        primaryStage.setResizable(false);
        primaryStage.setScene(defaultScene);
        primaryStage.show();
        
    }

    public static void main(final String[] args) {
        launch();
    }
}
