import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
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

    public static void main (String [] args) {
        try {
            Socket server = new Socket(localhost,1181);
            DataInputStream in = new DataInputStream(server.getInputStream());
            DataOutputStream out = new DataOutputStream(server.getOutputStream());
            launch(args);
        } catch (IOException e) {
            System.out.println("ERROR: Couldn't connect to server");
        } finally {
            server.close();
        }
    }

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        HBox top = new HBox();
        Text welcome = new Text("Welcome to Communist Bank");
        top.getChildren().addAll(welcome);

        VBox centre = new VBox(new Insets(5));
        TextField field = new TextField("Enter Amount");

        HBox centreButtons = new HBox(new Insets(20));
        Button deposit = new Button("Deposit");
        deposit.setOnAction(new ButtonEvent());
        Button withdrawl = new Button("Withdrawl");
        withdrawl.setOnAction(new ButtonEvent());
        centreButtons.getChildren().addAll(deposit,withdrawl);
        centre.getChildren().addAll(field,centreButtons);
        centreButtons.setPos(Centre);

        HBox bottom = new HBox(new Inset(5));
        bottom.setPos("centre");
        Text status = new Text("Status");
        Text bank = new Text("");
        bottom.getchildren.addAll(status,bank);

        root.setTop(top);
        root.setCenter(centre);
        root.setBottom(bottom);

        Scene scene = new Scene(root);

        primaryStage.setStage(root,600,600);
        primaryStage.start();
        primaryStage.show();
        primaryStage.setTitle("JavaFX Bank");
    }

    public void ButtonEvent implements EventHandler<ActionEvent> {
        @Override
        public void handle (ActionEvent e) {
            if (e.getSource == deposit) {
                server.writeUTF("Deposit");
                server.flush();
                server.writeInt(field);
                server.flush();
                bank.setText(in.readUTF());
            }
            if (e.getSource == withdrawl) {
                server.writeUTF("Withdrawl");
                server.flush();
                server.writeInt(field);
                server.flush();
                bank.setText(in.readUTF());
            }
        }
    }
}