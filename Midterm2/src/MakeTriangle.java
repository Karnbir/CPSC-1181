import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

public class MakeTriangle extends Application {
    double x1,y1,x2,y2,x3,y3;
    int counter = 1;
    private Pane root;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        root = new Pane();

        root.setOnMouseClicked(new MouseClick());

        Scene scene = new Scene(root, 300, 400);
        primaryStage.setTitle("Click for Triangle");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public class MouseClick implements EventHandler<MouseEvent> {

        @Override
        public void handle (MouseEvent e) {
            if (counter == 1) {
                x1 = e.getX();
                y1 = e.getY();
            }

            if (counter == 2) {
                x2 = e.getX();
                y2 = e.getY();
            }

            if (counter == 3) {
                counter = 0;
                x3 = e.getX();
                y3 = e.getY();

                Polygon x = new Polygon(x1,y1,x2,y2,x3,y3);
                x.setFill(Color.TRANSPARENT);
                x.setStroke(Color.BLACK);
                root.getChildren().add(x);
            }
            counter++;
        }

    }
}