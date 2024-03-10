import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class JavaFXTree extends Application {
    private Group rainbow, smile, tree;
    private CheckBox rainbowCB, smileCB;
    private Button changeText;
    private TextField textField;
    private Text text;
    private RadioButton $0Degree, $90Degree, $180Degree, $270Degree;
    private ToggleGroup radioToggleGroup;

    @Override
    public void start(Stage primaryStage) {

        Pane viewport = new Pane();
        VBox controlPanel = new VBox(5);
        controlPanel.setPrefSize(200, 400);

        class Close implements EventHandler<ActionEvent> {
            @Override
            public void handle(ActionEvent e) {
                primaryStage.close();
            }
        }

        Button close = new Button("Close");
        close.setOnAction(new Close());
        HBox bottom = new HBox(close);
        bottom.setAlignment(Pos.BOTTOM_RIGHT);

        BorderPane root = new BorderPane();

        root.setCenter(viewport);
        root.setLeft(controlPanel);
        root.setBottom(bottom);

        Rectangle ground = new Rectangle(0, 350, 400, 100);
        ground.setFill(Color.DARKGREEN);

        Font font = new Font(48);

        text = new Text("");
        text.setFont(font);
        text.setFill(Color.WHITE);
        text.setX(100);
        text.setY(420);

        Rectangle trunk = new Rectangle(100, 270, 20, 100);
        trunk.setFill(Color.SADDLEBROWN);

        Ellipse leaves = new Ellipse(110, 250, 40, 60);
        leaves.setFill(Color.rgb(30, 120, 80));

        tree = new Group(trunk, leaves);

        Color[] colors = {Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.BLUE, Color.INDIGO, Color.PURPLE};
        int offset = 0;

        rainbow = new Group();

        for (Color c : colors) {
            Ellipse temp = new Ellipse(200, 330, 300 - offset, 300 - offset);
            temp.setFill(Color.TRANSPARENT);
            temp.setStroke(c);
            temp.setStrokeWidth(10);
            rainbow.getChildren().add(temp);
            offset += 10;
        }
        rainbow.setVisible(false);

        smile = new Group();
        smile.getChildren().add(new Circle(250, 120, 100, Color.YELLOW));
        smile.getChildren().add(new Arc(250, 120, 80, 80, 180, 180));
        smile.getChildren().add(new Ellipse(210, 80, 10, 20));
        smile.getChildren().add(new Ellipse(290, 80, 10, 20));
        smile.setVisible(false);

        Rectangle clip = new Rectangle(0, 0, 400, 430);
        viewport.setClip(clip);

        viewport.getChildren().addAll(ground, tree, rainbow, smile, text);


        Text background = new Text("Background");
        HBox bgText = new HBox(background);
        bgText.setPadding(new Insets(10));
        bgText.setAlignment(Pos.CENTER);

        rainbowCB = new CheckBox("Rainbow");
        rainbowCB.setOnAction(new CheckBoxEvent());
        smileCB = new CheckBox("Smile");
        smileCB.setOnAction(new CheckBoxEvent());


        HBox checkBoxes = new HBox(10, rainbowCB, smileCB);
        checkBoxes.setAlignment(Pos.CENTER);

        radioToggleGroup = new ToggleGroup();
        RadioBoxEvent rbe = new RadioBoxEvent();

        $0Degree = new RadioButton("0 Degree");
        $0Degree.setToggleGroup(radioToggleGroup);
        $0Degree.setOnAction(rbe);
        $90Degree = new RadioButton("90 Degree");
        $90Degree.setToggleGroup(radioToggleGroup);
        $90Degree.setOnAction(rbe);
        $180Degree = new RadioButton("180 Degree");
        $180Degree.setToggleGroup(radioToggleGroup);
        $180Degree.setOnAction(rbe);
        $270Degree = new RadioButton("270 Degree");
        $270Degree.setOnAction(rbe);
        $270Degree.setToggleGroup(radioToggleGroup);


        VBox radioButtons = new VBox(10, $0Degree, $90Degree, $180Degree, $270Degree);
        radioButtons.setPadding(new Insets(20, 5, 20, 5));

        Text caption = new Text("Caption");
        textField = new TextField();
        changeText = new Button("Change text");
        changeText.setOnAction(new TextChanger());

        HBox captionAlign = new HBox(caption);
        HBox textBoxAlign = new HBox(textField);
        HBox changeTextAlign = new HBox(changeText);

        captionAlign.setAlignment(Pos.CENTER);
        textBoxAlign.setAlignment(Pos.CENTER);
        changeTextAlign.setAlignment(Pos.CENTER);

        controlPanel.getChildren().addAll(bgText, checkBoxes, radioButtons, captionAlign, textBoxAlign, changeTextAlign);


        Scene scene = new Scene(root, 600, 456);
        primaryStage.setTitle("FXShapes");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    private class CheckBoxEvent implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent e) {
            if (e.getSource() == rainbowCB) {
                if (rainbowCB.isSelected()) {
                    rainbow.setVisible(true);
                } else {
                    rainbow.setVisible(false);
                }
            }

            if (e.getSource() == smileCB) {
                if (smileCB.isSelected()) {
                    smile.setVisible(true);
                } else {
                    smile.setVisible(false);
                }
            }
        }
    }

    private class RadioBoxEvent implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent e) {
            if ($0Degree.isSelected()) {
                tree.setRotate(0);
            }
            if ($90Degree.isSelected()) {
                tree.setRotate(90);
            }
            if ($180Degree.isSelected()) {
                tree.setRotate(180);
            }
            if ($270Degree.isSelected()) {
                tree.setRotate(270);
            }
        }
    }

    private class TextChanger implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent e) {
            text.setText(textField.getText());
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
