/**
 * Program Name: Scenery.java
 * Author: Karnbir Randhawa
 * Date: February 21, 2024
 * Course: CPSC 1181
 * JDK: BellSoft Liberica JDK 21 Full
 */

import javafx.animation.Animation;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Scenery extends Application {

    /**
     * This method launches the JavaFX stage
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * This method creates the JavaFX scene featuring trees, a rainbow, and a cat
     */
    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();

        Rectangle ground = new Rectangle(0, 400, 600, 100);
        ground.setFill(Color.DARKGREEN);
        root.getChildren().add(ground);

        Tree t1 = new Tree (100, 420);
        root.getChildren().addAll(t1.getAllNodes());

        Tree t2 = new Tree(200, 440, 100, 100, Color.rgb(100, 100, 80));
        root.getChildren().addAll(t2.getAllNodes());

        Tree t3 = new Tree(250, 440, 100, 250, Color.rgb(120, 120, 10));
        root.getChildren().addAll(t3.getAllNodes());

        //generate rainbow
        Color [] rainbow = {Color.RED,Color.ORANGE,Color.YELLOW,Color.BLUE,Color.INDIGO,Color.PURPLE};
        int offset = 0;
        for (Color c : rainbow) {
            Ellipse temp = new Ellipse(300,420,360-offset,360-offset);
            temp.setFill(Color.TRANSPARENT);
            temp.setStrokeWidth(7);
            temp.setStroke(c);
            root.getChildren().add(temp);
            offset += 7; //to make sure colours don't overlap
        }

        Cat simba = new Cat(420,400);
        root.getChildren().addAll(simba.getAllNodes());

        Scene scene = new Scene(root, 600, 500);
        primaryStage.setTitle("JavaFX Trees");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}