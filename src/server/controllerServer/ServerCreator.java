package server.controllerServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * Class to create the server that communicates with multiple clients
 * @author hamza
 *
 */
public class ServerCreator {
	
	private ServerSocket serverSocket;
	private PrintWriter socketOut;
	private Socket aSocket;
	private BufferedReader socketIn;
	private ExecutorService pool;
	private JDBCManager myApp;
	
	public ServerCreator(int port) {
		try {
			serverSocket= new ServerSocket(port);
			myApp = new JDBCManager();
			myApp.initializeConnection();
			pool = Executors.newCachedThreadPool();
		} catch (IOException e) {
			System.out.println("At server creator");
		}
		
		
	}
	/**
	 * Forms a connection with the client
	 */
	public void runServer() {
		try {
			while(true) {
			aSocket = serverSocket.accept();
			System.out.println("Connection Accepted");
			socketIn = new BufferedReader(new InputStreamReader(aSocket.getInputStream()));
			socketOut = new PrintWriter(aSocket.getOutputStream(), true);
			ServerCommunicate communicator=new ServerCommunicate(socketIn,socketOut,myApp);
			pool.execute(communicator);
			}
		} catch (IOException e) {
			
			System.out.println("Error at servercommunicate constructor");
		}
		
	}

	public static void main(String[] args) {
		
		ServerCreator s = new ServerCreator(8099);
		s.runServer();
	

	}

}
