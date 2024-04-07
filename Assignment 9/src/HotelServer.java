import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class HotelServer {
    static Hotel hotel;
    static Socket client;

    private static class multiThread implements Runnable {
        @Override
        public void run() {
            try {
                doService();
            } catch (IOException e) {
//                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) throws IOException {

        ServerSocket server = new ServerSocket(1181);
        hotel = new Hotel();
        while (true) {
            client = server.accept();
            Thread t1 = new Thread(new multiThread());
            t1.start();
        }
    }

    public static void doService() throws IOException {
        DataInputStream in = new DataInputStream(client.getInputStream());
        DataOutputStream out = new DataOutputStream(client.getOutputStream());
        String name = "";

        out.writeUTF("Welcome to the Hotel");
        out.flush();

        while (client.isConnected()) {
            String userRequest = in.readUTF();

            if (userRequest.equalsIgnoreCase("USER")) {
                name = in.readUTF();
                out.writeUTF("Hello, " + name);
                out.flush();

            }
            else if (userRequest.equalsIgnoreCase("RESERVE")) {
                int start = in.readInt();
                int last = in.readInt();
                if (hotel.requestReservation(name,start,last)) {
                    out.writeUTF("Reservation made: " + name + " from " + start + " through " + last);
                    out.flush();
                } else {
                    out.writeUTF("Reservation unsuccessful: " + name + " from " + start + " through " + last);
                    out.flush();
                }

            } else if (userRequest.equalsIgnoreCase("AVAILABLE")) {
                out.writeUTF(hotel.toString());
                out.flush();
            } else if (userRequest.equalsIgnoreCase("CANCEL")) {
            } else if (userRequest.equalsIgnoreCase("QUIT")) {
                out.writeUTF("Closing Connection");
                out.flush();
                client.close();
            } else {
                out.writeUTF("Invalid command: Closing Connection");
                out.flush();
                client.close();
            }
        }
    }
}