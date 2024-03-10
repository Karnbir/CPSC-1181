import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class ColorButtonsFX extends Application {
    private Button redButton;
    private Button blueButton;
    private Rectangle background;
    private Ellipse moon;
    private CheckBox moonColor;
    /**
 * Main method to start the JavaFX application.
 * @param args command line arguments
 */
public static void main(String[] args) {
    launch(args);
}

/**
 * This method initializes the JavaFX stage and its components.
 */
@Override
public void start(Stage primaryStage) {
    ColorChanger event = new ColorChanger();

    // create buttons and add action listener
    Button redButton = new Button("RED!");
    redButton.setLayoutX(50);
    redButton.setLayoutY(350);
    redButton.setOnAction(event);

    Button blueButton = new Button("BLUE!");
    blueButton.setLayoutX(150);
    blueButton.setLayoutY(350);
    blueButton.setOnAction(event);

    // create checkbox and add action listener
    CheckBox moonColor = new CheckBox("Moon Color");
    moonColor.setLayoutX(250);
    moonColor.setLayoutY(350);
    moonColor.setOnAction(event);

    moonColor.setTextFill(Color.WHITE);

    // create background rectangle and moon ellipse
    Rectangle background = new Rectangle(0, 0, 400, 400);
    Ellipse moon = new Ellipse(200, 100, 50, 50);
    moon.setFill(Color.LIGHTGRAY);

    // create root pane and add components
    Pane root = new Pane();
    root.getChildren().addAll(background, moon, redButton, blueButton, moonColor);

    // create scene and set stage properties
    Scene scene = new Scene(root, 400, 400);
    primaryStage.setTitle("FX Change Color");
    primaryStage.setScene(scene);
    primaryStage.show();
}

/**
 * This inner class handles the action events for the buttons and checkbox.
 */
private class ColorChanger implements EventHandler<ActionEvent> {

    /**
     * This method changes the color of the moon and background based on the
     * selection of the checkbox.
     * @param e the action event
     */
    @Override
    public void handle(ActionEvent e) {
        if (moonColor.isSelected()) {
            moon.setFill(Color.YELLOW);
        } else {
            moon.setFill(Color.GRAY);
        }
        if (e.getSource() == redButton) {
            background.setFill(Color.RED);
        }
        if (e.getSource() == blueButton) {
            background.setFill(Color.BLUE);
        }
    }
}
}