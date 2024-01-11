package lab3;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class CircleControl extends Application {
  @Override 
  public void start(Stage primaryStage) {
    circlePane circlePane = new circlePane(); 
    Scene scene = new Scene(circlePane, circlePane.width, circlePane.height);
    primaryStage.setTitle("Exercise15_19"); 
    primaryStage.setScene(scene); 
    primaryStage.show(); 
    
    circlePane.requestFocus();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
