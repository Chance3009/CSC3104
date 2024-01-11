package lab3;

import java.util.Random;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class circlePane extends Pane {
	public final double radius = 10;
	public final double width = 250;
	public final double height = 150;
	private Circle circle = new Circle(radius);
	private Random random = new Random();
	private int count = 0;
	private long startTime = 0;
	
public circlePane() {
	spawnCircle();

	circle.setOnMouseClicked(e -> {
		if (count == 0) {
			startTime = System.currentTimeMillis();
		}

		if (count < 19) {
			spawnCircle();
		} else {
			long endTime = System.currentTimeMillis();
			long duration = endTime - startTime;
			circle.setVisible(false);
			Label timeLabel = new Label("Time spent is " + duration + " milliseconds");
			getChildren().add(timeLabel);
		}
		
		count++;
	});
	getChildren().add(circle); 
}
  
  protected void spawnCircle() {
	  circle.setFill(Color.rgb(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
	  circle.setCenterX(random.nextDouble(width - 2 * radius) + radius);
	  circle.setCenterY(random.nextDouble(height - 2 * radius) + radius);
  }
  
}
