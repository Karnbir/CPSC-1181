import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;

public class MouseDraggedDemo extends Application {
    private Ellipse ellipse;
    private double x;
    private double y;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();
        ellipse = new Ellipse(-10, -10, -10, -10);
        root.getChildren().add(ellipse);
        root.setOnMousePressed(new MousePressEventHandler());
        root.setOnMouseDragged(new MouseDragEventHandler());
        Scene scene = new Scene(root, 300, 400);
        primaryStage.setTitle("Lines");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private class MousePressEventHandler implements EventHandler<MouseEvent> {
        @Override
        public void handle(MouseEvent e) {
            x =e.getX();
            y =e.getY();
            ellipse.setCenterX(x);
            ellipse.setCenterY(y);
            ellipse.setRadiusX(0);
            ellipse.setRadiusY(0);
        }
    }

    private class MouseDragEventHandler implements EventHandler<MouseEvent> {
        @Override
        public void handle(MouseEvent e) {
            ellipse.setRadiusX(Math.abs(e.getX()-x));
            ellipse.setRadiusY(Math.abs(e.getY()-y));
        }
    }
}