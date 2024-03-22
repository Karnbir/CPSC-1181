/**
 * Program Name: BallGame
 * Author: Karnbir Randhawa
 * Date: March 21, 2024
 * Course: CPSC 1181
 * JDK: BellSoft Liberica JDK 21 Full
 */

import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class BallGame extends Application {
    Text misses,hits;
    int hitCount,missCount;
    Ellipse circle;

    Pane center;

    BallAnimation animation;

    public void start(Stage PrimaryStage) {
        BorderPane root = new BorderPane();

        //top pane that includes hits and misses counter
        HBox top = new HBox(10);
        top.setPadding(new Insets(10));
        hits = new Text("Hits: " + Integer.toString(hitCount));
        hits.setFill(Color.WHITE);
        misses = new Text("Misses: " + Integer.toString(missCount));
        misses.setFill(Color.WHITE);
        top.getChildren().addAll(hits,misses);

        //center pane where everything will happen
        center = new Pane();
        Rectangle background = new Rectangle(0,-40,400,400);
        center.getChildren().addAll(background);

        circle = new Ellipse(-50,160,50,50);
        circle.setFill(Color.WHITE);
        center.getChildren().addAll(circle);

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

        animation = new BallAnimation();
        animation.start();

        Scene scene = new Scene(root,400,440);
        PrimaryStage.setScene(scene);
        PrimaryStage.setTitle("Ball Game");
        PrimaryStage.setResizable(false);
        PrimaryStage.show();
    }

    public class BallAnimation extends AnimationTimer {
        @Override
        public void handle(long now) {
            //circle move
            circle.setCenterX(circle.getCenterX()+ 10);


            //reset circle
            if (circle.getCenterX() > 450) {
                misses.setText("Misses: " + Integer.toString(++missCount));
                circle.setCenterX(-50);
            }


            //game over
            if (missCount == 5) {
                Text gameOver = new Text(130,160,"Game Over");
                gameOver.setFill(Color.WHITE);
                gameOver.setFont(new Font(28));
                center.getChildren().add(gameOver);
                animation.stop();
            }
        }
    }

    public static void main (String [] args) {
        launch(args);
    }
}