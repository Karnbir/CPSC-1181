import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class JavaFX  extends Application {

    Button deposit,withdrawl;
    TextField field;
    Text bank;
    static Socket server;
    static DataInputStream in;
    static DataOutputStream out;

    public static void main (String [] args) {
        try {
            server = new Socket("localhost",1181);
            in = new DataInputStream(server.getInputStream());
            out = new DataOutputStream(server.getOutputStream());
            launch(args);
        } catch (IOException e) {
            System.out.println("ERROR: Couldn't connect to server");
        }
    }

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        HBox top = new HBox();
        Text welcome = new Text("Welcome to Communist Bank");
        top.getChildren().addAll(welcome);

        VBox centre = new VBox(5);
        field = new TextField("Enter Amount");

        HBox centreButtons = new HBox(20);
        deposit = new Button("Deposit");
        deposit.setOnAction(new ButtonEvent());
        withdrawl = new Button("Withdrawl");
        withdrawl.setOnAction(new ButtonEvent());
        centreButtons.getChildren().addAll(deposit,withdrawl);
        centre.getChildren().addAll(field,centreButtons);
        centreButtons.setAlignment(Pos.CENTER);


        HBox bottom = new HBox(5);
        bottom.setAlignment(Pos.CENTER);
        Text status = new Text("Status");
        bank = new Text("");
        bottom.getChildren().addAll(status,bank);

        root.setTop(top);
        root.setCenter(centre);
        root.setBottom(bottom);

        Scene scene = new Scene(root,200,200);

        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setTitle("JavaFX Bank");
    }

    public class ButtonEvent implements EventHandler<ActionEvent> {
        @Override
        public void handle (ActionEvent e) {
            try {
                if (e.getSource() == deposit) {
                    out.writeUTF("Deposit");
                    out.flush();
                    out.writeInt(Integer.parseInt(field.getText()));
                    out.flush();
                    bank.setText(in.readUTF());
                }
                if (e.getSource() == withdrawl) {
                    out.writeUTF("Withdrawl");
                    out.flush();
                    out.writeInt(Integer.parseInt(field.getText()));
                    out.flush();
                    bank.setText(in.readUTF());
                }
            } catch (IOException i) {
                bank.setText("ERROR: Couldn't communicate to the bank");
            }
        }
    }
}