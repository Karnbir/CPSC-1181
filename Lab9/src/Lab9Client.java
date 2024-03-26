import java.io.*;
import java.net.*;
import java.util.Scanner;

/**
 * The purpose of the client is to send a radius to the server to have the
 * area of a circle computed. The radius is obtained from the user.
 * The client communicates to the server that it's done sending radius and the server
 * acknwledges that the client is done with the computations.
 */

public class Lab9Client implements AreaConstants {

	/**
	* The localhost is used.
	* No serious error checking is done.
	* precondition: the one argument that there might be,
	* is either the server's domain name or the server's IP Address
	* @param args the line commands
	*/
	public static void main(String[] args) {
	
		Socket socket;
		DataOutputStream toServer = null;
		DataInputStream fromServer = null;
		String serverHost = "localhost"; // could have used "127.0.0.1"
        
		 try {
			socket = new Socket(serverHost, PORT);
			fromServer = new DataInputStream(socket.getInputStream());
			toServer = new DataOutputStream(socket.getOutputStream());
		}
		catch (SecurityException e) {
			System.err.println("a security manager exists");
			System.err.println("its checkConnect doesn't allow the connection.... bye");
		}
		catch (UnknownHostException e) {
			System.out.println("the IP address of the host could not be found...cannot go on, bye");
		}
		catch (IOException e) {
			System.err.println("cannot seem to be able to connect to the server");
			System.err.println("the server IP address I was hoping to connect to is");
			System.err.println(" \"" + serverHost + "\"");
			System.err.println("without a SERVER, I'm toast ... no point going on so bye, bye");
		}
		buildUI(toServer, fromServer);
	} 

	/**
	* Processes the messages coming from the server
	*
	*   from server -> client
	*   AREA d
	*     d is the area computed in the server
	*   reports (shows) this result on the GUI
	*
	*   from server -> client
	*   DONE
	*     nothing else is going to be sent to the client anymore
	*     the server is done serving
	*   As a result of the DONE, we remove the action listener of
	*   the rField and we set the rField to non-editable
	*/
	public static void startRequest(DataOutputStream toServer, DataInputStream fromServer) {
		System.out.println("startRequest method");
		boolean done = false;
		try {
			while (!done) {
				System.out.println("Waiting for area");
				int msg = fromServer.readInt();
				if (msg == AREA) {
					double area = fromServer.readDouble();
					System.out.println(String.format("area = %.2f \n", area));
					done = true;

				}
				else if (msg == DONE) {
					done = true;

					System.out.println("... finished ... ");
				}
				else {
					throw new IOException("unknown message=" + String.valueOf(msg) + " from server");
				}
			} // while
		} // try
		catch (IOException e) {
			System.out.println(e.getCause().getMessage() + "\n");
		} // catch
	} 

	private static void buildUI(DataOutputStream toServer, DataInputStream fromServer) {
		double radius = 1;
		Scanner scan = new Scanner(System.in);

		while (radius > 0) {
			try {
				System.out.println("Please enter the radius: ");
				radius = scan.nextDouble();

				if (radius < 0) {
					toServer.writeInt(QUIT);
					System.out.println("telling server that I want to quit");
				} else {
					System.out.println("sending to server radius = " + radius);
					toServer.writeInt(RADIUS);
					toServer.writeDouble(radius);
				}
				toServer.flush();
				System.out.println("calling the startRequest");
				startRequest(toServer, fromServer);
			}
			catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
