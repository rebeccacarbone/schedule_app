/*
 * Main class for running the program. Currently WIP - adding functionality
 * and a UI with JavaFX
 */
package schedule;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import org.apache.log4j.chainsaw.Main;

public class Schedule extends Application {


    @Override
    public void start(Stage primaryStage) throws FileNotFoundException, IOException {
        /*load up current FXML.fxml file with rough draft of what the initial screen
        should display*/
       Parent root = FXMLLoader.load(getClass().getResource("FXML.fxml"));
    
        Scene scene = new Scene(root);
    
        primaryStage.setTitle("FXML Welcome");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch();
    }

    
}
