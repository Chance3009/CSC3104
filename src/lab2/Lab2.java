package lab2;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.geometry.Insets;

public class Lab2 extends Application {
	String vehicleType = "car";
	int speed = 0;
	int speedLimit = 0;
	double fine = 0;
	
	String speedText = "";
	String limitText = "";
	
	public static void main(String[] args) {
		launch(args);
	} 
	
	@Override
	public void start (Stage stage) {
		GridPane pane = new GridPane();
		pane.setPadding(new Insets(20));
	    pane.setVgap(10); 
	    pane.setHgap(20);   
		
		Label vehicleLabel = new Label("Type of Vehicles");
		
		RadioButton carButton = new RadioButton("Car");
		RadioButton bikeButton = new RadioButton("Bike");
		ToggleGroup group = new ToggleGroup();
		carButton.setToggleGroup(group);
		bikeButton.setToggleGroup(group);
		
		carButton.setOnAction(e -> {
			if (carButton.isSelected()) vehicleType = "car";
		});

		bikeButton.setOnAction(e -> {
			if (bikeButton.isSelected()) vehicleType = "bike";
		});
		
		// Vehicle type will be car on default
		carButton.setSelected(true);
		
		HBox vehicleBox = new HBox(20);
		vehicleBox.getChildren().addAll(carButton, bikeButton);
		
		Label speedLabel = new Label("Speed");
		TextField speedField = new TextField();
		
		Label limitLabel = new Label("Speed Limit");
		TextField limitField = new TextField();
		
		Label fineLabel = new Label("Fine: RM");
		Button calculateFineButton = new Button("Calculate");
		
		// Calculate fine when the "Calculate" button is clicked
		// If speed or/and speed limit is/are invalid, an error message will be shown
		calculateFineButton.setOnAction(e -> {
			try{
				speed = Integer.parseInt(speedField.getText());
			} catch (Exception ex) {
				speedField.setText("Invalid speed");
			}
			
			try{
				speedLimit = Integer.parseInt(limitField.getText());
				fine = calculateFine(vehicleType, speed, speedLimit);
			} catch (Exception ex) {
				limitField.setText("Invalid speed limit");
				fine = 0;
			}
			
			fineLabel.setText(String.format("Fine: RM%.2f", fine));
		});
		
		// Add components to the pane
		pane.add(vehicleLabel, 0, 0);
		pane.add(vehicleBox, 1, 0);
		pane.add(speedLabel, 0, 1);
		pane.add(speedField, 1, 1);
		pane.add(limitLabel, 0, 2);
		pane.add(limitField, 1, 2);
		pane.add(fineLabel, 0, 3);
		pane.add(calculateFineButton, 1, 3);
		
		// Set up the scene and stage
		Scene scene = new Scene(pane);
		
		stage.setTitle("Fine Calculator");
		stage.setScene(scene);
		stage.show();
	}	

	// Calculates fine based on the vehicle type, speed, and speed limit
	public double calculateFine(String vehicle, int speed, int limit) {
		if (speed <= limit) return 0;
		switch(vehicle) {
			case "car":
				return (speed - limit) * (speed - limit) * 0.5;
			case "bike":
				return (30 + speed - limit);
		}
		return -1;
	}

}
