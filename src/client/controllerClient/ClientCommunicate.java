package client.controllerClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import client.moduleClient.Student;
import client.viewClient.SearchCourseGui;
import client.viewClient.ViewAllGui;
import client.viewClient.ViewStCourses;
import server.controllerServer.ServerCommunicate;

/**
 * Class that communicates with server
 * @author hamza
 *
 */
public class ClientCommunicate {
	
	protected BufferedReader socketInput;
	protected PrintWriter socketOutput;
	protected Socket aSocket;
	protected Student user;
	
	public ClientCommunicate(String serverName, int portNumber) {
		user = new Student ("",0);
		try {
			aSocket=new Socket(serverName,portNumber);
			socketInput= new BufferedReader(new InputStreamReader(aSocket.getInputStream()));
			socketOutput=new PrintWriter(aSocket.getOutputStream(),true);
		} catch (IOException e) {
			System.out.println("At Client Communicate");
		}
	}
	/**Communictes with server for Viewing All courses
	 * @param switchScenario the number that represents a particular situation
	 * @param theView the Gui on which the information needs to be presented on 
	 */
	public void communicateServer(int switchScenario, ViewAllGui theView) {
		
		if(switchScenario==5) {
			theView.presenter.setEditable(true);
			socketOutput.println(switchScenario);
			String response = "";
			while(true) {
				try {
					response = socketInput.readLine();
					if(response.contains("\0")) {
						break;
					}
					theView.presenter.append("\n"+response);
			}catch (IOException e) {
					e.printStackTrace();
				}
				
			}
			socketOutput.flush();
			theView.presenter.setEditable(false);
		}
		else {
			System.out.println("case 5 client");
		}
		
		
	}
	/**Communicates with server for sending information about the user
	 * @param switchScenario the number that represents a particular situation
	 */
	public void communicateServerStudentScenario(int switchScenario) {
		
		if(switchScenario == 1) {
			socketOutput.println(switchScenario);
			socketOutput.println(user.getStudentName());
			socketOutput.println(user.getStudentId());
			socketOutput.flush();
		}
		
	}
	/**Communicates with server for Viewing All Student courses
	 * @param switchScenario the number that represents a particular situation
	 * @param theView the Gui on which the information needs to be presented on 
	 */
	public void communicateServerStudentScenario(int switchScenario, ViewStCourses theView) {
		if (switchScenario == 6) {
			socketOutput.println(switchScenario);
			socketOutput.println(user.getStudentName());
			socketOutput.println(user.getStudentId());
			
			String response="";
			while(true) {
				try {
					response = socketInput.readLine();
					if(response.contains("\0")) {
						break;
					}
					theView.presenter.append("\n"+response);
				} catch (IOException e) {
					System.out.println("Case 6 Client Communicate");
				}
			}
			socketOutput.flush();
			theView.presenter.setEditable(false);	
			
		}
	}
	/**Communicates with server for Adding or dropping a course
	 * 
	 * @param switchScenario the number that represents a particular situation
	 * @param name Course name
	 * @param num Course number
	 */
	public void communicateServerCourseScenario(int switchScenario, String name, int num) {
		
			
		if(switchScenario == 3) {
			socketOutput.println(switchScenario);
			socketOutput.println(name);
			socketOutput.println(num);
			socketOutput.println(user.getStudentName());
			socketOutput.println(user.getStudentId());
			socketOutput.flush();
		}
		else if(switchScenario == 4) {
			socketOutput.println(switchScenario);
			socketOutput.println(name);
			socketOutput.println(num);
			socketOutput.println(user.getStudentName());
			socketOutput.println(user.getStudentId());
			socketOutput.flush();
		}
			
	}
	/**
	 * Communicates with Server to search for a course
	 * @param switchScenario the number that represents a particular situation
	 * @param name the name of the course
	 * @param num the number of the course
	 * @param theView The gui the Information needs to be presented on
	 */
	public void communicateServerCourseScenario (int switchScenario, String name, int num, SearchCourseGui theView) {
		
		if(switchScenario == 2) {
		socketOutput.println(switchScenario);
		socketOutput.println(name);
		socketOutput.println(num);
		try {
			String response=socketInput.readLine();
			theView.presenter.append("\n"+"\n"+response);
			while(true) {
				response = socketInput.readLine();
				if(response.contains("\0")) {
					socketOutput.flush();
					break;
				}
				theView.presenter.append("\n"+response);
			}
			socketOutput.flush();
			
		} catch (IOException e) {
			System.out.println("case 2");
		}
		
		}
		
		
	}
	/**
	 * Gets the user
	 * @return the user
	 */
	public Student getStudent() {
		return user;
	}
	/**
	 * Sets the user
	 * @param stName the name of the user
	 * @param stId the id of the user
	 */
	public void setUser(String stName, int stId) {
		user.setStudentName(stName);
		user.setStudentId(stId);
	}
		
}


