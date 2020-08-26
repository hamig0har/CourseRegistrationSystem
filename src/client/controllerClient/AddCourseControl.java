package client.controllerClient;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import client.viewClient.AddCourseGui;

/**
 * Class controls the Add course Gui
 * @author hamza
 *
 */
public class AddCourseControl{
	
	private AddCourseGui theView;
	private String serverName;
	private int portNumber;
	private String courseName;
	private int courseNum;
	private ClientCommunicate client;

	public AddCourseControl(String serverName, int portNumber,ClientCommunicate client) {
		this.serverName=serverName;
		this.portNumber=portNumber;
		this.client = client;
		this.theView = new AddCourseGui();
		theView.add.addActionListener(new AddListener());
		theView.mainMenu.addActionListener(new MainMenuListener());
	}
	/**
	 * Action Listener for adding the particular course
	 * @author hamza
	 *
	 */
	class AddListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			courseName = theView.forName.getText();
			courseNum = Integer.parseInt(theView.forNumber.getText());
			client.communicateServerCourseScenario(3, courseName, courseNum);
			theView.setVisible(false);
			MainGuiControl main = new MainGuiControl(serverName,portNumber,client);
		}
		
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
