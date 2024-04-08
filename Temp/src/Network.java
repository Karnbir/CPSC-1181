import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Network {

    public static void main (String [] args) {

        try {
            //make socket
            Socket s = new Socket("localhost",11181);

            //hook scanner up to inputstream
            DataInputStream in = new DataInputStream(s.getInputStream());

            //hook printWriter up to outputstream
            DataOutputStream out = new DataOutputStream(s.getOutputStream());

            //prepare a message for printWriter to send
            out.writeUTF("Karnbir");
            out.flush(); //send message

            //read response from server

                System.out.println(in.readUTF());

                s.close();

        } catch (IOException e) {
            System.out.println("Exception caught");
        }

    }
}
