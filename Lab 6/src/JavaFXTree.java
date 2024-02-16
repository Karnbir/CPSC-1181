import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class JavaFXTree extends Application {

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setResizable(false);

        Rectangle ground = new Rectangle(0,300,300,100);
        ground.setFill(Color.DARKGREEN);

        Rectangle trunk = new Rectangle(140,220,20,100);
        trunk.setFill(Color.SADDLEBROWN);

        Ellipse leaves = new Ellipse(150,220,40,60);
        leaves.setFill(Color.rgb(30,120,80));

        Color [] colors = {Color.RED,Color.ORANGE,Color.YELLOW,Color.GREEN,Color.BLUE,Color.INDIGO,Color.PURPLE};
        int offset = 0;

        Pane root = new Pane();

        for (Color c: colors) {
            Ellipse temp = new Ellipse(150,330 + offset,300,300);
            temp.setFill(Color.TRANSPARENT);
            temp.setStroke(c);
            temp.setStrokeWidth(10);
            root.getChildren().addAll(temp);
            offset += 10;
        }

        root.getChildren().addAll(ground,trunk,leaves);

        Scene scene = new Scene(root,300,400);

        primaryStage.setTitle("FXShapes");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main (String [] args) {
        launch(args);
    }
}
