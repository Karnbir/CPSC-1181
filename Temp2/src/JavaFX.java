import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Cell;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.Random;

public class JavaFX extends Application {
    double x,y;
    HBox cVbox;
    Line line;
    Circle circle;
    public void start (Stage primaryStage){
        BorderPane root = new BorderPane();

        VBox vbox = new VBox(10);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(20));

        Button x = new Button("Click me");
        x.setOnAction(new ButtonEvent());

        circle = new Circle(100, Color.PINK);

        ToggleGroup radioGroup = new ToggleGroup();

        RadioButton rectangle = new RadioButton("Rectangle");
        rectangle.setToggleGroup(radioGroup);
        RadioButton circlez = new RadioButton("Circle");
        circlez.setToggleGroup(radioGroup);


        vbox.getChildren().addAll(rectangle,circlez);



        HBox cHbox = new HBox(10);
        cHbox.setAlignment(Pos.CENTER);
        //cHbox.getChildren().addAll(circle);
        cVbox = new HBox();
        cVbox.setAlignment(Pos.CENTER);
        cVbox.getChildren().add(cHbox);

        cVbox.setOnMouseDragged(new mouseEvent());





        vbox.getChildren().addAll(x);

        root.setLeft(vbox);
        root.setCenter(cVbox);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public class ButtonEvent implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent e) {
            Random r = new Random();
            circle.setFill(Color.rgb(r.nextInt(256),r.nextInt(256),r.nextInt(256)));
        }
    }

    public class mouseEvent implements EventHandler<MouseEvent> {
        @Override
        public void handle(MouseEvent e) {
            if (x == 0) {
                x = e.getX();
                y = e.getY();
            } else {
                line = new Line(x,y,e.getX(),e.getY());
                cVbox.getChildren().add(line);
                x=0;
            }
        }
    }

    public static void main (String [] args){
        launch(args);
    }
}
