import java.io.*;
import java.net.*;

/**
 * Given a socket that is opened already, it sets up the ComputationService
 * so that it can receive radius from the client and so that it can compute the
 * area of a circle. The computed area is sent to the Client.
 * Once the client indicates that there is no more data being sent, the
 * socket is closed.
 */

public class Lab9Service implements AreaConstants, Runnable {
	// the instance variables socket, fromClient, and toClient are
	// needed because of the interface Runnable that has a method run
	// that takes no arguments
	private Socket socket;
	private DataInputStream fromClient;
	private DataOutputStream toClient;
	@Override
	public void run() {
		doService();
	}

	/**
	* Receives an open socket so that input/output streams can be attached
	* @param s the socket that is opened
	*/
	public Lab9Service(Socket s)
	{
		socket = s;
		//doService();
	}

	/**
	* Runs the code which is in its thread:
	*  - sets up the DataInputStream and the DataOutputStream
	*  - calls for the commands from the client to be executed
	*  - cleans up
	*/
	public void doService()
	{
		try
		{
          
			// create the data input and output streams
			// we put them here instead of in the constructor so that
			// we do not have to put a try catch in the constructor
			fromClient = new DataInputStream(socket.getInputStream());
			toClient = new DataOutputStream(socket.getOutputStream());

			executeCmds();
           
		}
		catch (IOException | NullPointerException exception)
		{
			System.out.println("An exception is generated");
		}
	}

	/**
	* Executes the commands coming from the client
	*
	*   from client -> server
	*   QUIT
	*   stops executing (client) commands
	*   and responds to the client by sending DONE
	*
	*   from client -> server
	*   RADIUS r
	*      r is the radius of a circle
	*   computes the area given the radius r  which the client sent
	*   and responds to the client by sending AREA d
	*
	*/
	public void executeCmds() throws IOException
	{
		int cmd;
		do {
			cmd = fromClient.readInt();
			System.out.println("The cmd is: " + cmd);
			if (cmd == QUIT)
			{
				System.out.println("QUIT command received from client");
				toClient.writeInt(DONE);
				toClient.flush();
			}
			else if (cmd == RADIUS)
			{
				System.out.println("RADIUS command received from client");
				computeArea();
			}
			else
			{
				String unknownCmd = String.valueOf(cmd);
				throw new IOException("unrecognizable command=" + unknownCmd + " from client");
			}
		} while (cmd != QUIT);
	} 

	/**
	* Receives from the client the argument of RADIUS which
	* is the value of the radius. Computes the area and sends
	* the command AREA with the computed area to the client.
	*/
	public void computeArea() throws IOException
	{
		double r = fromClient.readDouble();
		System.out.println("radius (from a client) = " + r);
		double area = r * r * Math.PI;
		System.out.println("area computed = " + area);

		toClient.writeInt(AREA);
		toClient.writeDouble(area);
		toClient.flush();
	}  
} 

