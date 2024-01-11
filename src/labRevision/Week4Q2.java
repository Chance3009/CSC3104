package labRevision;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Week4Q2 extends Application{
	double rate;
	int hour;
	double wage;
	
	@Override
	public void start(Stage stage) throws Exception {
		VBox root = new VBox(10);
		root.setPadding(new Insets(15));
		
		HBox rateBox = new HBox(15);
		Label rateLabel = new Label("Rate:");
		TextField rateField = new TextField();
		rateBox.setAlignment(Pos.CENTER_RIGHT);
		rateBox.getChildren().addAll(rateLabel, rateField);
		
		HBox hourBox = new HBox(15);
		Label hourLabel = new Label("Num Hours:");
		TextField hourField = new TextField();
		
		hourBox.setAlignment(Pos.CENTER_RIGHT);
		hourBox.getChildren().addAll(hourLabel, hourField);
		
		HBox wageBox = new HBox(15);		
		Label wageLabel = new Label("Total Wage:");
		TextField wageField = new TextField();
		wageField.setEditable(false);
		wageBox.setAlignment(Pos.CENTER_RIGHT);
		wageBox.getChildren().addAll(wageLabel, wageField);

		Button calculateButton = new Button("Calculate>>");
	
		calculateButton.setOnAction(e -> {
			try{
				rate = Double.parseDouble(rateField.getText());
			} catch (Exception ex) {
				rateField.setText("Invalid Rate");
			}
			
			try{
				hour = Integer.parseInt(hourField.getText());
				wage = rate  * hour;
			} catch (Exception ex) {
				hourField.setText("Invalid Hour");
			}
			
			wageField.setText(String.format("RM%.2f", wage));
		});

		root.getChildren().addAll(rateBox, hourBox, wageBox, calculateButton);
		
		Scene scene = new Scene(root);
		
		stage.setScene(scene);
		stage.setTitle("Wage Calculator");
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
