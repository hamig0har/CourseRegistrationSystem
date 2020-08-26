package server.controllerServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import client.controllerClient.InfoControl;
import server.moduleServer.Course;
import server.moduleServer.CourseCatalogue;
import server.moduleServer.CourseOffering;
import server.moduleServer.Registration;
import server.moduleServer.Student;
import server.moduleServer.Users;
/**
 * Server class which communicates with Client
 * @author hamza
 *
 */
public class ServerCommunicate implements Runnable {
	
	private PrintWriter socketOut;
	private BufferedReader socketIn;
	private Users userList;
	private CourseCatalogue catalogue;
	private JDBCManager myApp;

	public ServerCommunicate(BufferedReader socketIn,PrintWriter socketOut,JDBCManager myApp) {
		catalogue = new CourseCatalogue();
		userList = new Users();
		this.myApp = myApp;
		this.socketIn = socketIn;
		this.socketOut = socketOut;
	}
	
	/**
	 * Communicates with client to get or send necessary information through a Socket
	 */
	public void communicateClient() {
		int choice = 0;
		String line ="";
		
		try {
			line = socketIn.readLine();
			choice = Integer.parseInt(line);
			System.out.println("Good 2 Choice="+ choice);
			switch(choice) {
			
			case 1:studentScenario(1);
				break;
				
			case 2:
				courseScenario(2);
				break;
				
			case 3:courseScenario(3);
				break;
				
			case 4:courseScenario(4);
				break;
			
			case 5:
				socketOut.write(catalogue.toString());
				System.out.println("Good 3");
				socketOut.println("\0");
				break;
			
			case 6:studentScenario(6);
				break;
			}
			
		} catch (IOException e) {
			System.out.println ("Error in communicateClient ServerCommuncate");
		}
		return;
	}
	/**
	 * Collects or sends information depending on the situation
	 * @param choice: the integer that represents the situation
	 */
	public void courseScenario(int choice){
		String courseName= "";
		int courseNum= 0;
		String stName = "";
		int stId= 0;
		try {
			courseName = socketIn.readLine();
			courseNum = Integer.parseInt(socketIn.readLine());
			
			switch(choice){
			
			case 2:
				socketOut.println(catalogue.searchCourseByName(courseName, courseNum));
				socketOut.write(catalogue.coursePreReqs(courseName,courseNum));
				socketOut.println("\0");
				socketOut.flush();
				break;
			case 3:
				try {
					stName = socketIn.readLine();
					stId = Integer.parseInt(socketIn.readLine());
					Student st = userList.searchStudent(stName, stId);
					st.checker();
					Course myCourse = catalogue.searchCat(courseName, courseNum);
					if(myCourse.getOfferingList().isEmpty() == true) {
						catalogue.createCourseOffering(myCourse, 1, 200);
					}
					CourseOffering co =myCourse.availibleCourseOffering();
					Registration r = new Registration();
					r.completeRegistration(st,co);
					System.out.println(st.myCourses());
					break;
				} catch (IOException e) {
					System.out.println("At case 3");
				}
			case 4:
				try {
					stName = socketIn.readLine();
					stId = Integer.parseInt(socketIn.readLine());
					Student st = userList.searchStudent(stName, stId);
					Course myCourse = catalogue.searchCat(courseName, courseNum);
					st.removeRegistration(myCourse);
					break;
				} catch (IOException e) {
					System.out.println("At case 4");
				}
				
			}
			
		} catch (IOException e) {
			System.out.println("Error in courseScenario serverCommunicate");
			}
	}
	
		
	/**
	 * Collects or sends information depending on the situation
	 * @param choice: the integer that represents the situation
	 */
	public void studentScenario(int choice) {
		String stName = "";
		int stId= 0;
		
			try {
				stName = socketIn.readLine();
				stId = Integer.parseInt(socketIn.readLine());
				
			} catch (IOException e) {
				System.out.println("Error in studentScenario serverCommunicate");
				}
			switch(choice) {
			case 1:
				Student st = new Student(stName,stId);
				userList.insert(st);
				//myApp.createTable();
				myApp.insertUser(stId,stName);
				System.out.println(userList.searchStudent(stName, stId));
				break;
				
			case 6:
				Student s = userList.searchStudent(stName, stId);
				socketOut.write(s.myCourses());
				socketOut.println("\0");
				socketOut.flush();
				break;
			}
		}
	/**
	 * Calls for the Server side to start communicating with client side through the socket
	 */
	@Override
	public void run() {
		while(true) {
		communicateClient();
		}
	}
		
}

