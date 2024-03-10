import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ComputerPaint  extends Application {

    Color[] rainbowColor = {Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.BLUE, Color.PURPLE, Color.PINK};
    private BorderPane root;
    private Button close;
    private Text display;
    private Group tree;
    private Group smile;
    private Group rainbow;
    private CheckBox rainbowbox;
    private CheckBox smilebox;
    private RadioButton degree0;
    private RadioButton degree90;
    private RadioButton degree180;
    private RadioButton degree270;
    private Button changeText;
    private TextField entry;
    public static void main (String [] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        class closeButtonHandler implements EventHandler<ActionEvent>
        {
            @Override
            public void handle(ActionEvent e)
            {
                primaryStage.close();
            }
        }

        root = new BorderPane();

        Pane mainSecenary = new Pane();
        Rectangle ground = new Rectangle(0,300,300,100);
        ground.setFill(Color.DARKGREEN);

        tree = new Group();
        Rectangle trunk = new Rectangle(40, 220, 20, 100);
        trunk.setFill(Color.SADDLEBROWN);
        Ellipse leaves = new Ellipse(50, 220, 40, 50);
        leaves.setFill(Color.rgb(30,120,80));
        tree.getChildren().addAll(trunk, leaves);

        smile = new Group();
        Ellipse face = new Ellipse(210, 180, 70,70);
        face.setFill(Color.YELLOW);
        Ellipse eye1 = new Ellipse(185, 150, 8,15);
        Ellipse eye2 = new Ellipse(235, 150,8, 15);
        Arc mouth = new Arc(210,180,60,60,180,180);
        smile.getChildren().addAll(face, eye1,eye2, mouth);

        rainbow = new Group();
        for(int i = 0; i <7; i++) {
            int k = i*7;
            Ellipse random = new Ellipse(150, 300+k, 250, 250);
            random.setStroke(rainbowColor[i]);
            random.setStrokeWidth(7);
            random.setFill(Color.TRANSPARENT);
            rainbow.getChildren().addAll(random);
        }

        display = new Text(15,370,"");
        display.setFont(Font.font("Arial", 50));
        close = new Button("Close");
        close.setOnAction(new closeButtonHandler());
        HBox closeButton = new HBox(2, close);
        closeButton.setAlignment(Pos.BASELINE_RIGHT);
        mainSecenary.getChildren().addAll(ground, display, tree, smile, rainbow);


        Pane controlPanel = new Pane();
        Rectangle controlBox = new Rectangle(0,0,150,425);
        controlBox.setFill(Color.WHITE);

        Text message = new Text("Background");
        HBox messageHolder = new HBox(message);
        messageHolder.setAlignment(Pos.BASELINE_CENTER);

        rainbowbox = new CheckBox("Rainbow!");
        rainbowbox.setSelected(true);
        rainbowbox.setOnAction(new visibilty());
        smilebox = new CheckBox("Smiley Face!");
        smilebox.setSelected(true);
        smilebox.setOnAction(new visibilty());
        HBox checkBoxes = new HBox(40, rainbowbox, smilebox);

        ToggleGroup degreeButtons = new ToggleGroup();
        degree0 = new RadioButton("0 Degree");
        degree0.setToggleGroup(degreeButtons);
        degree0.setOnAction(new rotation());
        degree90 = new RadioButton("90 Degree");
        degree90.setToggleGroup(degreeButtons);
        degree90.setOnAction(new rotation());
        degree180 = new RadioButton("180 Degree");
        degree180.setToggleGroup(degreeButtons);
        degree180.setOnAction(new rotation());
        degree270 = new RadioButton("270 Degree");
        degree270.setToggleGroup(degreeButtons);
        degree270.setOnAction(new rotation());
        entry = new TextField();

        Text caption = new Text("Caption:");
        HBox captionHolder = new HBox(caption);
        captionHolder.setAlignment(Pos.BASELINE_CENTER);

        TextField entry = new TextField();
        HBox entryHolder = new HBox(entry);
        entryHolder.setAlignment(Pos.BASELINE_CENTER);

        changeText = new Button("Change text");
        HBox changeTextHolder = new HBox(changeText);
        changeTextHolder.setAlignment(Pos.BASELINE_CENTER);
        changeText.setOnAction(new visibilty());

        VBox controlButtons = new VBox(20,messageHolder, checkBoxes, degree0, degree90, degree180,
                degree270, captionHolder, entry, changeText);


        controlPanel.getChildren().addAll(controlBox, controlButtons);
        root.setCenter(mainSecenary);
        root.setLeft(controlPanel);
        Scene scene = new Scene(root);
        primaryStage.setTitle("FX SHAPES");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();

    }
    class visibilty implements EventHandler<ActionEvent>
    {
        @Override
        public void handle (ActionEvent e)
        {
            if (e.getSource() == changeText)
                display.setText(entry.getText());
            rainbow.setVisible(rainbowbox.isSelected());
            smile.setVisible(smilebox.isSelected());
        }
    }

    class rotation implements EventHandler<ActionEvent>
    {
        @Override
        public void handle (ActionEvent e)
        {
            if (e.getSource() == degree0)
                tree.setRotate(0);
            if (e.getSource() == degree90)
                tree.setRotate(90);
            if (e.getSource() == degree180)
                tree.setRotate(180);
            if (e.getSource() == degree270)
                tree.setRotate(270);
        }
    }

}
