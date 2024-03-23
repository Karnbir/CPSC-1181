/**
 * Program Name: BallGame
 * Author: Karnbir Randhawa
 * Date: March 22, 2024
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
import java.util.Random;

public class BallGame extends Application {
    /**
     * This program is a JavaFX game where users are challenged to click the circle as many times as they can until they
     * miss 5 times
     *
     * MY ADDITION: I set the color of the circle to change based on the amount of successful hits
     */
    int ballSpeed;
    boolean paused = false, hyperMode = false;
    Text misses, hits, gameOver;
    int hitCount, missCount;
    Ellipse circle;
    Pane center;
    Button reset, pause;
    BallAnimation animation;
    Helper helper;

    /**
     * Sets up the JavaFX panes, stage, and scene
     * @param PrimaryStage the primary stage for this application, onto which
     * the application scene can be set.
     * Applications may create other stages, if needed, but they will not be
     * primary stages.
     */
    public void start(Stage PrimaryStage) {
        BorderPane root = new BorderPane();
        animation = new BallAnimation();
        helper = new Helper();

        //top pane that includes hits and misses counter
        HBox top = new HBox(10);
        top.setPadding(new Insets(10));

        hits = new Text("Hits: " + hitCount);
        hits.setFill(Color.WHITE);

        misses = new Text("Misses: " + missCount);
        misses.setFill(Color.WHITE);

        top.getChildren().addAll(hits, misses);

        //center pane where everything will happen
        center = new Pane();
        Rectangle background = new Rectangle(0, -40, 400, 400);

        gameOver = new Text(130, 160, "Game Over");
        gameOver.setFill(Color.WHITE);
        gameOver.setFont(new Font(28));

        circle = new Ellipse(-50, 160, 50, 50);
        helper.circleColorChange();
        circle.setOnMouseClicked(new BallClick());

        center.getChildren().addAll(background, gameOver, circle);

        helper.reset();

        //bottom pane that includes pause and reset button
        HBox bottom = new HBox(10);
        bottom.setPadding(new Insets(10));

        ButtonHandler buttonEvent = new ButtonHandler();
        pause = new Button("Pause");
        pause.setOnAction(buttonEvent);
        reset = new Button("Reset");
        reset.setOnAction(buttonEvent);
        bottom.getChildren().addAll(pause, reset);
        bottom.setAlignment(Pos.CENTER_RIGHT);


        //BorderPane
        root.setCenter(center);
        root.setTop(top);
        root.setBottom(bottom);

        //JavaFX
        Scene scene = new Scene(root, 400, 440);
        PrimaryStage.setScene(scene);
        PrimaryStage.setTitle("Ball Game");
        PrimaryStage.setResizable(false);
        PrimaryStage.show();
    }

    private class BallAnimation extends AnimationTimer {

        /**
         * Responsible for animation of the ball
         * @param now
         *            The timestamp of the current frame given in nanoseconds. This
         *            value will be the same for all {@code AnimationTimers} called
         *            during one frame.
         */
        @Override
        public void handle(long now) {
            //circle move
            circle.setCenterX(circle.getCenterX() + ballSpeed);

            //reset circle position on miss
            if (circle.getCenterX() > 450) {
                misses.setText("Misses: " + ++missCount);
                circle.setCenterX(-50);
            }

            //game over
            if (missCount == 5) {
                gameOver.setOpacity(100);
                animation.stop();
            }

            //set circle to change colors rapidly (WARNING: Do not play if you are prone to Photosensitive Epileptic Seizures)
            if (hyperMode) {
                Random r = new Random();
                circle.setFill(Color.rgb(r.nextInt(256), r.nextInt(256), r.nextInt(256)));
            }
        }
    }

    private class ButtonHandler implements EventHandler<ActionEvent> {

        /**
         * Handles the logic for pause and reset button click
         * @param e the event which occurred
         */
        @Override
        public void handle(ActionEvent e) {

            //reset logic is handled in helper function
            if (e.getSource() == reset) {
                helper.reset();
            }

            //code for pause button
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
        /**
         * When user clicks on circle, increment the hit count and increase the circle speed
         * @param e the event which occurred
         */
        @Override
        public void handle(MouseEvent e) {

            //successful circle click logic
            if (!paused) {
                hits.setText("Hits: " + ++hitCount);
                circle.setCenterX(-50);
                ballSpeed += 1;
                helper.circleColorChange();
            }
        }
    }

    /**
     * Helper class for some code reuse and organization
     */
    private class Helper {

        /**
         * Logic to reset the state of the game
         */
        public void reset() {
            ballSpeed = 1;
            hits.setText("Hits: " + (hitCount = 0));
            misses.setText("Misses: " + (missCount = 0));
            gameOver.setOpacity(0);
            circle.setCenterX(-50);
            circleColorChange();
            animation.start();
        }

        /**
         * Logic to change the color of the circle
         */
        public void circleColorChange() {
            if (hitCount < 1) {
                hyperMode = false;
                circle.setFill(Color.BLUE);
            }
            else if (hitCount < 2) {
                circle.setFill(Color.YELLOW);
            }
            if (hitCount > 3) {
                hyperMode = true;
            }
        }

        /**
         * Code to launch the JavaFX Scene
         */
        public static void main(String[] args) {
            launch(args);
        }
    }
}