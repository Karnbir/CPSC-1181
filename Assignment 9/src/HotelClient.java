import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class HotelClient {

    public static void main(String[] args) throws IOException {

        Socket server = new Socket("localhost", 1181);
        DataInputStream in = new DataInputStream(server.getInputStream());
        DataOutputStream out = new DataOutputStream(server.getOutputStream());
        System.out.println(in.readUTF());

        System.out.println("Please enter your name");
        out.writeUTF("USER");
        out.flush();

        //send name to server
        Scanner input = new Scanner(System.in);
        out.writeUTF(input.nextLine());
        out.flush();
        //read hello n from server
        System.out.println(in.readUTF());

        while (!server.isClosed()) {
            System.out.println("Please enter one of the following : \n Reserve, Cancel, Available, or Quit");
            input = new Scanner(System.in);
            String choice = input.nextLine();
            out.writeUTF(choice);
            out.flush();

            if (choice.equalsIgnoreCase("Reserve")) {
                System.out.println("Please enter the start day");
                out.writeInt(input.nextInt());
                out.flush();
                System.out.println("Please enter the last day");
                out.writeInt(input.nextInt());
                out.flush();
            }

            System.out.println(in.readUTF());

            if (!choice.equalsIgnoreCase("Reserve") && !choice.equalsIgnoreCase("Cancel") &&
                    !choice.equalsIgnoreCase("Available")) {
               server.close();
            }
        }
    }
}
