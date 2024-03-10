import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class JavaFXTree extends Application {

    @Override
    public void start(Stage primaryStage) {

        Pane viewport = new Pane();
        VBox controlPanel = new VBox(5);
        controlPanel.setPrefSize(200,400);

        Button close = new Button("Close");
        HBox bottom = new HBox(close);
        bottom.setAlignment(Pos.BOTTOM_RIGHT);

        BorderPane root = new BorderPane();

        root.setCenter(viewport);
        root.setLeft(controlPanel);
        root.setBottom(bottom);

        Rectangle ground = new Rectangle(0,350,600,100);
        ground.setFill(Color.DARKGREEN);

        Rectangle trunk = new Rectangle(100,270,20,100);
        trunk.setFill(Color.SADDLEBROWN);

        Ellipse leaves = new Ellipse(110,250,40,60);
        leaves.setFill(Color.rgb(30,120,80));

        Color [] colors = {Color.RED,Color.ORANGE,Color.YELLOW,Color.GREEN,Color.BLUE,Color.INDIGO,Color.PURPLE};
        int offset = 0;

        for (Color c: colors) {
            Ellipse temp = new Ellipse(200,330,300 - offset,300 - offset);
            temp.setFill(Color.TRANSPARENT);
            temp.setStroke(c);
            temp.setStrokeWidth(10);
            viewport.getChildren().addAll(temp);
            offset += 10;
        }

        Group smile = new Group();
        smile.getChildren().add(new Circle(250,120,100,Color. YELLOW));
        smile.getChildren().add(new Arc(250,120,80,80,180,180));
        smile.getChildren().add(new Ellipse(210,80,10,20));
        smile.getChildren().add(new Ellipse(290,80,10,20));

        Rectangle clip = new Rectangle(0,0,400,430);
        viewport.setClip(clip);

        viewport.getChildren().addAll(ground,trunk,leaves,smile);


        Text background = new Text("Background");
        HBox bgText = new HBox(background);
        bgText.setPadding(new Insets (10));
        bgText.setAlignment(Pos.CENTER);

        CheckBox rainbow = new CheckBox("Rainbow");
        CheckBox smileBox = new CheckBox("Smile");

        HBox checkBoxes = new HBox(10,rainbow,smileBox);
        checkBoxes.setAlignment(Pos.CENTER);

        RadioButton $0Degree = new RadioButton("0 Degree");
        RadioButton $90Degree = new RadioButton("90 Degree");
        RadioButton $180Degree = new RadioButton("180 Degree");
        RadioButton $270Degree = new RadioButton("270 Degree");

        VBox radioButtons = new VBox(10,$0Degree,$90Degree,$180Degree,$270Degree);
        radioButtons.setPadding(new Insets(20,5,20,5));

        Text caption = new Text("Caption");
        TextField textBox = new TextField();
        Button changeText = new Button("Change text");

        HBox captionAlign = new HBox(caption);
        HBox textBoxAlign = new HBox(textBox);
        HBox changeTextAlign = new HBox(changeText);

        captionAlign.setAlignment(Pos.CENTER);
        textBoxAlign.setAlignment(Pos.CENTER);
        changeTextAlign.setAlignment(Pos.CENTER);

        controlPanel.getChildren().addAll(bgText,checkBoxes,radioButtons,captionAlign,textBoxAlign,changeTextAlign);



        Scene scene = new Scene(root,600,456);
        primaryStage.setTitle("FXShapes");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main (String [] args) {
        launch(args);
    }
}
