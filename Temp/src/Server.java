import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Server {

    public static void main (String [] args) throws IOException {
        ServerSocket server = new ServerSocket(11181);
        try {
            while (true) {
                Socket socket = server.accept();
                service(socket);
            }
        }
        finally {
            server.close();
    }

    }

    public static void service(Socket userSocket) throws IOException {

        DataInputStream input = new DataInputStream(userSocket.getInputStream());
        //StringTokenizer line = new StringTokenizer(input.readUTF());

        DataOutputStream out = new DataOutputStream(userSocket.getOutputStream());

        String name = input.readUTF();

        name = "Hello " + name;
        out.writeUTF(name);
        out.flush();
            //if (line.nextToken().equalsIgnoreCase("specs")) {
                //out.println("MacBook Pro 16 inch");
                //out.flush();
                //line.nextToken();
            //}
        }
}
