import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {
    private CheckBox boldCheckBox;
    private final String initialMessage = "Hello, World";
    private final int fontSize = 72;
    private TextField messageTextField;
    private Text message;

    private RadioButton noLineRB;
    private RadioButton underlineRB;
    private RadioButton strikeThroughRB;
    private ToggleGroup textLineGroup ;

    @Override
    public void start(Stage primaryStage) {
        message = new Text(25, 175, initialMessage);
        message.setFont(Font.font("Arial", fontSize));
        messageTextField = new TextField(initialMessage);
        messageTextField.setPrefWidth(300);
        Button updateMessageButton = new Button("Update Message");

        boldCheckBox = new CheckBox("Bold");










        noLineRB = new RadioButton("No Line");
        underlineRB = new RadioButton("Underline");
        strikeThroughRB = new RadioButton("Strikethrough");

        //vbox for buttons
        VBox vbox = new VBox(5,noLineRB,underlineRB,strikeThroughRB);
        vbox.setAlignment(Pos.CENTER_LEFT);

        vbox.getChildren().addAll();

        HBox hbox = new HBox();
        hbox.setAlignment(Pos.CENTER);
        hbox.getChildren().add(messageTextField);



        vbox.setPadding(new Insets(10));
        hbox.setPadding(new Insets (10));

        VBox updateButton = new VBox(5,updateMessageButton,boldCheckBox);
        updateButton.setAlignment(Pos.TOP_RIGHT);
        updateButton.setPadding(new Insets(10));

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(hbox);
        borderPane.setLeft(vbox);
        borderPane.setRight(updateButton);
        borderPane.setBottom(message);



        //textLineGroup = new ToggleGroup();

        MessageEventHandler meh = new MessageEventHandler();
        updateMessageButton.setOnAction(meh);
        messageTextField.setOnAction(meh);
        boldCheckBox.setOnAction(meh);
        noLineRB.setOnAction(meh);
        underlineRB.setOnAction(meh);
        strikeThroughRB.setOnAction(meh);


        updateMessageButton.setOnAction(new MessageEventHandler());
        Pane root = new Pane();
        root.getChildren().addAll(borderPane);
        Scene scene = new Scene(root, 200, 100);
        primaryStage.setTitle("Text Bruh");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private class MessageEventHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent e) {
            message.setText(messageTextField.getText());
            FontWeight fw = FontWeight.NORMAL;
            if (boldCheckBox.isSelected()) {
                fw = FontWeight.BOLD;
            }
            message.setFont(Font.font("Arial",fw,72));
            message.setStrikethrough(strikeThroughRB.isSelected());
            message.setUnderline(underlineRB.isSelected());
        }
    }
}
