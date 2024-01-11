package lab1;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;

public class DentalPaymentApplication extends Application {
	double total = 0;

	@Override
    public void start(Stage primaryStage) {
		BorderPane root = new BorderPane();
		root.setPadding(new Insets(20));
        
		// Create top pane 
		VBox topBox = new VBox();
		topBox.setAlignment(Pos.CENTER);
		
		HBox titleBox = new HBox();
		titleBox.setPadding(new Insets(10));
		titleBox.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, new CornerRadii(0), new Insets(0))));
		titleBox.setBorder(new Border(new BorderStroke(Color.BLACK, Color.RED, Color.BLACK, Color.RED,
                BorderStrokeStyle.NONE, BorderStrokeStyle.NONE, BorderStrokeStyle.SOLID, BorderStrokeStyle.NONE,
                CornerRadii.EMPTY, new BorderWidths(2), new Insets(0))));
		
		Rectangle empty = new Rectangle(30,30, Color.LIGHTGRAY);
        
		Region region1 = new Region();
		HBox.setHgrow(region1, Priority.ALWAYS);
		
		Label titleLabel = new Label("Chan Dental Payment Application");
		titleLabel.setStyle("-fx-font-size: 24px");
		titleLabel.setTextAlignment(TextAlignment.CENTER);
		titleLabel.setAlignment(Pos.CENTER);
		
        Region region2 = new Region();
        HBox.setHgrow(region2, Priority.ALWAYS);
        
	    ImageView logoImageView = new ImageView(new Image("dentist.jpg"));
        logoImageView.setFitHeight(30);
        logoImageView.setFitWidth(30);

        // Set animation of logo
        PathTransition pt = new PathTransition();
        pt.setPath(new Circle(20));
        pt.setNode(logoImageView);
        pt.setCycleCount(Timeline.INDEFINITE);
        pt.setDuration(Duration.millis(1000));
        pt.setAutoReverse(true);
        
        logoImageView.setOnMousePressed(e -> pt.play());
        logoImageView.setOnMouseReleased(e -> pt.pause());
        
        titleBox.getChildren().addAll(empty, region1, titleLabel, region2, logoImageView);
        
        Label formTitleLabel = new Label("Dental Payment Entry Form");
        formTitleLabel.setStyle("-fx-font-size: 18px;" + "-fx-alignment: center;");
        VBox.setMargin(formTitleLabel, new Insets(15));
              
        HBox patientNameBox = new HBox(30);
        patientNameBox.setAlignment(Pos.CENTER);
        
        Label patientNameLabel = new Label("Patient Name");
        patientNameLabel.setAlignment(Pos.CENTER);
        
        TextField patientNameInput = new TextField();
        patientNameBox.getChildren().addAll(patientNameLabel, patientNameInput);
        
        topBox.getChildren().addAll(titleBox, formTitleLabel, patientNameBox);
        root.setTop(topBox);
        
        // Create center pane
        HBox centerBox = new HBox();
        centerBox.setPadding(new Insets(20));
        
        VBox servicesBox = new VBox();
        servicesBox.setAlignment(Pos.CENTER_LEFT);
        servicesBox.setSpacing(8);
        servicesBox.setPadding(new Insets(5,0,5,50));
        
        Label servicesLabel = new Label("Services");
        CheckBox cleaningCheckbox = new CheckBox("Cleaning");
        CheckBox cavityFillingCheckbox = new CheckBox("Cavity Filling");
        CheckBox xrayCheckbox = new CheckBox("X-ray");
        CheckBox fluorideCheckbox = new CheckBox("Fluoride");
        CheckBox rootCanalCheckbox = new CheckBox("Root Canal");
        CheckBox otherCheckbox = new CheckBox("Other");
        
        servicesBox.getChildren().addAll(servicesLabel, cleaningCheckbox, cavityFillingCheckbox,
                xrayCheckbox, fluorideCheckbox, rootCanalCheckbox, otherCheckbox);
        
        VBox pricesBox = new VBox();
        pricesBox.setAlignment(Pos.CENTER_RIGHT);
        pricesBox.setSpacing(8);
        pricesBox.setPadding(new Insets(5,50,5,0));
        
        Label pricesLabel = new Label("Prices(RM)");
        Label cleaningPricesLabel = new Label("35.00");
        Label cavityFillingPricesLabel = new Label("150.00");
        Label xrayPricesLabel = new Label("85.00");
        Label fluoridePricesLabel = new Label("50.00");
        Label rootCanalPricesLabel = new Label("255.00");
        TextField otherPricesInput = new TextField();
        otherPricesInput.setMaxSize(80, 10);

        pricesBox.getChildren().addAll(pricesLabel, cleaningPricesLabel, cavityFillingPricesLabel,
                xrayPricesLabel, fluoridePricesLabel, rootCanalPricesLabel, otherPricesInput);
        
        // Create a mapping for checkbox and price of services
        Map<CheckBox, Double> services = new HashMap<>();

        services.put(cleaningCheckbox, 35.00);
        services.put(cavityFillingCheckbox, 150.00);
        services.put(xrayCheckbox, 85.00);
        services.put(fluorideCheckbox, 50.00);
        services.put(rootCanalCheckbox, 255.00);
        
        HBox.setHgrow(servicesBox, Priority.ALWAYS);
        HBox.setHgrow(pricesBox, Priority.ALWAYS);
        centerBox.getChildren().addAll(servicesBox, pricesBox);
        centerBox.setBorder(new Border(new BorderStroke(Color.RED, Color.RED, Color.BLACK, Color.RED,
                BorderStrokeStyle.NONE, BorderStrokeStyle.NONE, BorderStrokeStyle.SOLID, BorderStrokeStyle.NONE,
                CornerRadii.EMPTY, new BorderWidths(2), new Insets(0))));
        root.setCenter(centerBox);

        // Create bottom pane
        VBox bottomBox = new VBox();
        bottomBox.setPadding(new Insets(20));
        bottomBox.setAlignment(Pos.CENTER);
        
        HBox totalBox = new HBox();
        totalBox.setAlignment(Pos.CENTER_RIGHT);
        
        Label totalLabel = new Label("Total");
        
        Label totalPriceLabel = new Label("");
        totalPriceLabel.setBorder(new Border(new BorderStroke(Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK,
                BorderStrokeStyle.SOLID, BorderStrokeStyle.SOLID, BorderStrokeStyle.SOLID, BorderStrokeStyle.SOLID,
                CornerRadii.EMPTY, new BorderWidths(1), new Insets(5,55,5,20))));
        totalPriceLabel.setPadding(new Insets(5));
        totalPriceLabel.setStyle("-fx-alignment: CENTER-RIGHT;");
        totalPriceLabel.setMinWidth(150);

        totalBox.getChildren().addAll(totalLabel, totalPriceLabel);

        // Calculate the total price of the services selected
        Button calculateButton = new Button("Calculate");
        calculateButton.setAlignment(Pos.CENTER);
        calculateButton.setOnAction(e -> {
        	total = 0;
        	// Calculate the total price for the selected services 
        	for (CheckBox service: services.keySet()) {
            	if (service.isSelected()) 
            		total += services.get(service);
            }
        	// Parse the price value of other service if checkbox for other is selected 
        	if (otherCheckbox.isSelected()) {
        		try {
                    total += Double.parseDouble(otherPricesInput.getText());
                } catch (NumberFormatException ex) {
                    otherPricesInput.setText("Invalid Price");
                    total = 0;
                }
        	}
        	totalPriceLabel.setText(String.format("%.2f", total));
        });
        
        HBox mediaBox = new HBox(30);
        mediaBox.setAlignment(Pos.CENTER_LEFT);
        
        Media media = new Media(new File("video.mp4").toURI().toString());
        MediaPlayer player = new MediaPlayer(media);
        player.setAutoPlay(true);  
        player.setCycleCount(MediaPlayer.INDEFINITE);
        MediaView view = new MediaView(player);
        view.setFitHeight(70);
        
        mediaBox.getChildren().add(view);
        
        bottomBox.getChildren().addAll(totalBox, calculateButton, mediaBox);
        root.setBottom(bottomBox);
        
        // Set up the scene and stage
        Scene scene = new Scene(root, 600, 600);
        
    	primaryStage.setTitle("Chan Dental Payment Application");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
