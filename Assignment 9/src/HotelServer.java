/**
 * Program Name: HotelServer
 * Author: Karnbir Randhawa
 * Course: CPSC 1181
 * Date: April 7th, 2024
 * JDK: Liberica JDK 21 Full
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class HotelServer {

    static Hotel hotel;
    static Socket client;

    /**
     * Enables server to handle multiple clients at once via multithreading
     */
    private static class multiThread implements Runnable {
        /**
         * Lets client connection run as a thread, if a client crashes, the server persists.
         */
        @Override
        public void run() {
            try {
                System.out.println("Client Connected");
                doService(); //let serving a client run as a thread
                System.out.println("Client Disconnected");
            } catch (IOException e) {
                System.out.println("Client Crashed, continuing...");
            }
        }
    }

    /**
     * This is a multithreaded hotel server that lets clients login, see available dates, and book/cancel reservations
     */
    public static void main(String[] args) throws IOException {
        //Start server socket, initialize hotel and run all client connections as threads
        ServerSocket server = new ServerSocket(1181);
        hotel = new Hotel();
        while (true) {
            client = server.accept();
            Thread t1 = new Thread(new multiThread());
            t1.start();
        }
    }

    /**
     * Serve the client
     * @throws IOException if client crashes
     */
    public static void doService() throws IOException {
        //setup input and output to and from  the client socket
        DataInputStream in = new DataInputStream(client.getInputStream());
        DataOutputStream out = new DataOutputStream(client.getOutputStream());

        out.writeUTF("Welcome to the Hotel");
        out.flush();

        String userRequest = in.readUTF(); //read first message from client

        String name = "";
        //if first message from client doesn't tell us who the client is, reject the client
        if (userRequest.equalsIgnoreCase("USER")) {
            name = in.readUTF();
            out.writeUTF("Hello, " + name);
            out.flush();
        } else {
            out.writeUTF("ERROR: You must first identify yourself with USER command, terminating connection...");
            out.flush();
            client.close();
        }

        //once client has identified themselves, serve them until we close the connection
        while (!client.isClosed()) {

            //what the user has selected from the client menu
            userRequest = in.readUTF();

            if (userRequest.equalsIgnoreCase("RESERVE")) {
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
                out.writeUTF(hotel.toString()); //tells client availability of the hotel
                out.flush();
            } else if (userRequest.equalsIgnoreCase("CANCEL")) {
                if(hotel.cancelReservation(name)) {
                    out.writeUTF("Reservations successfully cancelled for " + name);
                    out.flush();
                } else {
                    out.writeUTF("Reservations not canceled for " + name +", no current reservation");
                    out.flush();
                }
            } else if (userRequest.equalsIgnoreCase("QUIT")) {
                out.writeUTF("Closing Connection");
                out.flush();
                client.close();
            } else { //if client sends a command that isn't on the menu, disconnect
                out.writeUTF("Invalid command: Closing Connection");
                out.flush();
                client.close();
            }
        }
    }
}