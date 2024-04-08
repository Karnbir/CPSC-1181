import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Sever2 {
    static Socket client;


    public static void main(String[] args) throws IOException {
        class multiThread implements Runnable {
            @Override
            public void run() {
                doService(client); //send new client socket to doService
            }
        }
        //start server on port 1181
        ServerSocket server = new ServerSocket(1181);
        while (true) {
            client = server.accept(); //listen for new connection and make socket
            Thread thread = new Thread(new multiThread());
            thread.start();
        }
    }

    public static void doService(Socket userSocket){
        try {
            //DataInputStream + DataOutputStream replace Scanner + PrintWriter
            DataInputStream in = new DataInputStream(userSocket.getInputStream());
            DataOutputStream out = new DataOutputStream(userSocket.getOutputStream());

            String name = in.readUTF(); //read UTF converts the binary data coming in to ASCII

            //Convert our string to binary data (UTF) to be sent to the client
            out.writeUTF("Hello " + name + " its nice to meet you");
            out.flush(); //flush it to the user
        } catch (Exception e) {}
    }
}