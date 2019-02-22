
package Cartoon;


import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
/* @yhajiqas 
 * This is my main class which sets up the stage. 
 * this game shows and prints the colors of rainbow by implementing a composite shape as well as label. 
 */

public class App extends Application {

    @Override
	public void start(Stage stage) {
    PaneOrganizer organizer = new PaneOrganizer();
	Scene scene = new Scene(organizer.getRoot(),400,400);
    stage.setTitle("Rainbow!");
    stage.setScene(scene);
    stage.show();
  }

	
	public static void main(String[] argv) {
        	// launch is a method inherited from Application
		launch(argv);
	}
}