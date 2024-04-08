import java.io.*;
import java.net.*;
import java.util.Date;

/**
 * The purpose of the server is to compute the area when a radius is sent by a client.
 * The Labo9Server should serve many clients.
 * The client communicates to the server that it's done sending radius and the server
 * acknwledges that the client is done with the computations.
 */
public class Lab9Server implements AreaConstants{

    // let's put the main program of the application here
    public static void main(String[] args) throws IOException
    {

		ServerSocket serverSocket = new ServerSocket(PORT);
		System.out.println("Server started");
	        
	        try
		{
			while(true)
			{
				System.out.println("Waitin...");
				Socket socket = serverSocket.accept();
			
				System.out.println("Client connected.");

				Lab9Service service = new Lab9Service(socket);
				service.doService();

			} 
		}
		finally
		{
			serverSocket.close();
		}
       
	} 
}
