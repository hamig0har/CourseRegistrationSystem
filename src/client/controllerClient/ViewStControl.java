package client.controllerClient;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import client.viewClient.ViewStCourses;
/**
 * Class controls the View Student Courses Gui
 * @author hamza
 *
 */
public class ViewStControl{
	
	private ViewStCourses theView;
	private String serverName;
	private int portNumber;
	private ClientCommunicate client;

	public ViewStControl(String serverName, int portNumber, ClientCommunicate client) {
		this.serverName=serverName;
		this.portNumber=portNumber;
		this.client = client;
		this.theView = new ViewStCourses();
		theView.mainMenu.addActionListener(new MainMenuListener());
		client.communicateServerStudentScenario(6,theView);
	}
	/**
	 * Class for going back to main Menu
	 * @author hamza
	 *
	 */
	class MainMenuListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			theView.setVisible(false);
			MainGuiControl main = new MainGuiControl(serverName,portNumber,client);
			
		}
	}
}
