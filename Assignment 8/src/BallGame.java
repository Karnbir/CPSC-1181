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
    int ballSpeed;
    boolean paused = false;
    Text misses,hits,gameOver;
    int hitCount,missCount;
    Ellipse circle;
    Pane center;
    Button reset,pause;
    BallAnimation animation;
    Helper helper;

    public void start(Stage PrimaryStage) {
        BorderPane root = new BorderPane();
        animation = new BallAnimation();

        //top pane that includes hits and misses counter
        HBox top = new HBox(10);
        top.setPadding(new Insets(10));

        hits = new Text("Hits: " + hitCount);
        hits.setFill(Color.WHITE);

        misses = new Text("Misses: " + missCount);
        misses.setFill(Color.WHITE);

        top.getChildren().addAll(hits,misses);

        //center pane where everything will happen
        center = new Pane();
        Rectangle background = new Rectangle(0,-40,400,400);

        gameOver = new Text(130,160,"Game Over");
        gameOver.setFill(Color.WHITE);
        gameOver.setFont(new Font(28));

        circle = new Ellipse(-50,160,50,50);
        circle.setFill(Color.WHITE);
        circle.setOnMouseClicked(new BallClick());

        center.getChildren().addAll(background,gameOver,circle);

        helper = new Helper();
        helper.reset();

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
                misses.setText("Misses: " + ++missCount);
                circle.setCenterX(-50);
            }

            //game over
            if (missCount == 5) {
                gameOver.setOpacity(100);
                animation.stop();
            }
        }
    }

    private class ButtonHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent e) {

            if (e.getSource() == reset) {
                helper.reset();
            }

            if (e.getSource() == pause && missCount != 5) {
                if (!paused) {
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
                hits.setText("Hits: " + ++hitCount);
                circle.setCenterX(-50);
                ballSpeed += 1;
            }
        }
    }

    private class Helper {
        public void reset() {
            ballSpeed = 1;
            hits.setText("Hits: " + (hitCount = 0));
            misses.setText("Misses: " + (missCount = 0));
            gameOver.setOpacity(0);
            circle.setCenterX(-50);
            animation.start();
        }
    }

    public static void main (String [] args) {
        launch(args);
    }
}