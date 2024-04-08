import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client2_1 {
    public static void main (String [] args) throws IOException {
        Socket mySocket = new Socket("localhost",1181); //connect to our server

        //DataInputStream + DataOutputStream replace Scanner + PrintWriter
        DataInputStream in = new DataInputStream(mySocket.getInputStream());
        DataOutputStream out = new DataOutputStream(mySocket.getOutputStream());

        //Convert my name to binary data to be sent to the client
        out.writeUTF("Karnbir");
        out.flush(); //flush it to the server

        System.out.println(in.readUTF()); //Convert incoming data to ASCII and print it

        //mySocket.close(); //never disconnect >:)
    }
}
