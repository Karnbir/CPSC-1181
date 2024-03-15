/**
 * Program Name: BallGame
 * Author: Karnbir Randhawa
 * Date: March 21, 2024
 * Course: CPSC 1181
 * JDK: BellSoft Liberica JDK 21 Full
 */

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class BallGame extends Application {
    int hitCount,missCount;

    public void start(Stage PrimaryStage) {
        BorderPane root = new BorderPane();

        //top pane that includes hits and misses counter
        HBox top = new HBox(10);
        top.setPadding(new Insets(10));
        Text hits = new Text("Hits: " + Integer.toString(hitCount));
        hits.setFill(Color.WHITE);
        Text misses = new Text("Misses: " + Integer.toString(missCount));
        misses.setFill(Color.WHITE);
        top.getChildren().addAll(hits,misses);

        //center pane where everything will happen
        Pane center = new Pane();
        Rectangle background = new Rectangle(0,-40,400,400);
        center.getChildren().addAll(background);

        //bottom pane that includes pause and reset button
        HBox bottom = new HBox(10);
        bottom.setPadding(new Insets(10));
        Button pause = new Button("Pause");
        Button reset = new Button("Reset");
        bottom.getChildren().addAll(pause,reset);
        bottom.setAlignment(Pos.CENTER_RIGHT);


        root.setCenter(center);
        root.setTop(top);
        root.setBottom(bottom);

        Scene scene = new Scene(root,400,440);
        PrimaryStage.setScene(scene);
        PrimaryStage.setTitle("Ball Game");
        PrimaryStage.setResizable(false);
        PrimaryStage.show();
    }

    public static void main (String [] args) {
        launch(args);
    }
}