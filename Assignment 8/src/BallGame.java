/**
 * Program Name: BallGame
 * Author: Karnbir Randhawa
 * Date: March 21, 2024
 * Course: CPSC 1181
 * JDK: BellSoft Liberica JDK 21 Full
 */
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
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
    int ballSpeed = 1;
    boolean paused = false;
    Text misses,hits,gameOver;
    int hitCount,missCount;
    Ellipse circle;
    Pane center;
    Button reset,pause;
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
        center.getChildren().add(background);

        circle = new Ellipse(-50,160,50,50);
        circle.setFill(Color.WHITE);
        center.getChildren().add(circle);

        circle.setOnMouseClicked(new BallClick());

        //bottom pane that includes pause and reset button
        HBox bottom = new HBox(10);
        bottom.setPadding(new Insets(10));

        ButtonHandler buttonEvent = new ButtonHandler();
        pause = new Button("Pause");
        pause.setOnAction(buttonEvent);
        reset = new Button("Reset");
        reset.setOnAction(buttonEvent);
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

    private class BallAnimation extends AnimationTimer {
        @Override
        public void handle(long now) {
            //circle move
            circle.setCenterX(circle.getCenterX() + ballSpeed);

            //reset circle
            if (circle.getCenterX() > 450) {
                misses.setText("Misses: " + Integer.toString(++missCount));
                circle.setCenterX(-50);
            }

            //game over
            if (missCount == 5) {
                gameOver = new Text(130,160,"Game Over");
                gameOver.setFill(Color.WHITE);
                gameOver.setFont(new Font(28));
                center.getChildren().add(gameOver);
                animation.stop();
            }
        }
    }

    private class ButtonHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent e) {

            if (e.getSource() == reset) {
                ballSpeed = 1;

                hits.setText("Hits: " + Integer.toString(hitCount = 0));
                misses.setText("Misses: " + Integer.toString(missCount = 0));

                center.getChildren().remove(gameOver);
                circle.setCenterX(-50);
                animation.start();

            }

            if (e.getSource() == pause) {
                if (missCount == 5) {
                }
                else if (!paused) {
                    animation.stop();
                    paused = true;
                } else {
                    animation.start();
                    paused = false;
                }
            }
        }
    }

    public class BallClick implements EventHandler<MouseEvent> {
        @Override
        public void handle (MouseEvent e) {
            if(!paused) {
                hits.setText("Hits: " + Integer.toString(++hitCount));
                circle.setCenterX(-50);
                ballSpeed += 1;
            }
        }
    }

    public static void main (String [] args) {
        launch(args);
    }
}