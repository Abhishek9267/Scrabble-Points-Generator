/**
 * Owen Brown
 * COMP 1011
 * Assignment 2
 * December 2019
 *      This is the main class for the Scrabble Generator program
 */

package A2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("board.fxml"));
        primaryStage.setTitle("Scrabble Points Generator");
        primaryStage.setScene(new Scene(root, 889, 1002));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
