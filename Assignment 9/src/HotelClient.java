/**
 * Program Name: HotelClient
 * Author: Karnbir Randhawa
 * Course: CPSC 1181
 * Date: April 7th, 2024
 * JDK: Liberica JDK 21 Full
 */

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class HotelClient {
    /**
     * This is a program that connects to HotelServer.java
     */
    public static void main(String[] args) {

        //try to connect to server
        try {
            Socket server = new Socket("localhost", 1181);
            DataInputStream in = new DataInputStream(server.getInputStream());
            DataOutputStream out = new DataOutputStream(server.getOutputStream());
            talkToServer(server, in, out);
        } catch (IOException e) {
            System.out.println("Server is unreachable");
        }
    }

    /**
     * This follows the spec that HotelServer.java expects and prints a menu for you to interact with the server to
     * do things such as see available days, book reservations, and cancel reservations
     * @param server is the socket connection to HotelServer.java
     */
    public static void talkToServer(Socket server, DataInputStream in, DataOutputStream out) throws IOException {
        //read welcome message from server
        System.out.println(in.readUTF());

        //tell server we are going to send our name
        System.out.println("Please enter your name");
        out.writeUTF("USER");
        out.flush();

        //send name to server
        Scanner input = new Scanner(System.in);
        out.writeUTF(input.nextLine());
        out.flush();

        //read message from server
        System.out.println(in.readUTF());

        //keep printing menu while server connection is active
        while (!server.isClosed()) {
            //tell server our choice
            System.out.println("Please enter one of the following : \nReserve, Cancel, Available, or Quit");
            input = new Scanner(System.in);
            String choice = input.nextLine();
            out.writeUTF(choice);
            out.flush();

            //additional input for reserve function
            if (choice.equalsIgnoreCase("Reserve")) {
                System.out.println("Please enter the start day");
                out.writeInt(input.nextInt());
                out.flush();
                System.out.println("Please enter the last day");
                out.writeInt(input.nextInt());
                out.flush();
            }

            //read message from server
            System.out.println(in.readUTF());

            //quit
            if (!choice.equalsIgnoreCase("Reserve") && !choice.equalsIgnoreCase("Cancel") &&
                    !choice.equalsIgnoreCase("Available")) {
                server.close();
            }
        }
    }
}