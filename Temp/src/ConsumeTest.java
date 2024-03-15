import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.Random;

import static javafx.application.Application.launch;

public class ConsumeTest extends Application {

    Circle c1;
    Rectangle r1;

    Pane root;

    @Override
    public void start (Stage PrimaryStage) {

        root = new Pane();
        root.setOnMouseClicked(new paneEvent());

        r1 = new Rectangle(0,0,500,500);
        r1.setFill(Color.AQUA);
        r1.setOpacity(0.5);



        c1 = new Circle(250,250,100);
        c1.setFill(Color.PINK);

        c1.setOnMouseClicked(new circleEvent());

        root.getChildren().addAll(c1,r1);

        Scene scene = new Scene(root);

        Stage primaryStage = new Stage();
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public class circleEvent implements EventHandler<MouseEvent> {

        @Override
        public void handle(MouseEvent e) {
            Random r = new Random();
            Color random = Color.rgb(r.nextInt(256),r.nextInt(256),r.nextInt(256));
            c1.setFill(random);
            e.consume();
        }

    }

    public class paneEvent implements EventHandler<MouseEvent> {
        @Override
        public void handle(MouseEvent e) {
            Random r = new Random();
            Color random = Color.rgb(r.nextInt(256),r.nextInt(256),r.nextInt(256));
            r1.setFill(random);
        }
    }

    public static void main (String [] args) {
        launch(args);
    }
}
