package labRevision;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.geometry.Pos;
import javafx.geometry.HPos;
import javafx.geometry.VPos;

public class Week4Q1 extends Application{
	@Override
	public void start(Stage stage) throws Exception {
		GridPane root = new GridPane();
		root.setVgap(5);
		root.setHgap(5);
		
		for(int i=0; i<4; i++) {
			for(int j=0; j<4; j++) {
				Rectangle rect = new Rectangle(150, 150);
				rect.setFill(Color.GREEN);
				root.add(rect, i, j);
			}
		}
		
		Label wowLabel = new Label("Wow");
		wowLabel.setStyle("-fx-font-family: Arial; -fx-font-size: 30;");
		wowLabel.setAlignment(Pos.CENTER);
		root.add(wowLabel, 0, 0);
		GridPane.setHalignment(wowLabel, HPos.CENTER);
		GridPane.setValignment(wowLabel, VPos.CENTER);
		
		
		ImageView dentistLogo = new ImageView(new Image("dentist.jpg"));
		root.add(dentistLogo, 1, 1);
		GridPane.setHalignment(dentistLogo, HPos.CENTER);
		GridPane.setValignment(dentistLogo, VPos.CENTER);
		
		
		Button bestButton = new Button("BEST");
		bestButton.setStyle("-fx-font-family: Arial; -fx-font-size: 30;");
		bestButton.setOnAction(e -> System.out.println("You are the best!"));
		root.add(bestButton, 2, 2);
		GridPane.setHalignment(bestButton, HPos.CENTER);
		GridPane.setValignment(bestButton, VPos.CENTER);
		
		Scene scene = new Scene(root);
		
		stage.setTitle("Dental Sideboard");
		stage.setScene(scene);
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
