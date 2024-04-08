/**
 * Useful constants for the
 * - Lab9Server class
 * - Lab9Service class
 * - Client class
 */

public interface AreaConstants {
    
	int PORT = 1185;

	// RADIUS is sent from the client -> server
	//     RADIUS d
	// where d is a double
	int RADIUS = 0;

	// QUIT is sent from the client -> server
	//     QUIT
	int QUIT = 1;

	// AREA is sent from the server -> client
	//     AREA d
	// where d is a double
	// AREA is sent in response to the client's RADIUS
	int AREA = 2;
	
	// DONE sent from the server -> client
	//     DONE
	// DONE is sent in response to the client's QUIT
	int DONE = 3;
}
