import java.io.IOException;
import java.net.ServerSocket;

public class Server {
    public static void main (String [] args) throws IOException {
        ServerSocket server = new ServerSocket(1181);
        while (true) {
            Socket client = server.accept();
            Thread t1 = new Thread(new Service(client));
            t1.start();
        }
    }
}
