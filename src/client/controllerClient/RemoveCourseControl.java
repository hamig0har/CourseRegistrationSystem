package client.controllerClient;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import client.viewClient.RemoveCourseGui;

/**
 * Class controls the Remove course Gui
 * @author hamza
 *
 */
public class RemoveCourseControl{
	
	private RemoveCourseGui theView;
	private String serverName;
	private int portNumber;
	private String courseName;
	private int courseNum;
	private ClientCommunicate client;

	public RemoveCourseControl(String serverName, int portNumber,ClientCommunicate client) {
		this.serverName=serverName;
		this.portNumber=portNumber;
		this.client = client;
		this.theView = new RemoveCourseGui();
		theView.remove.addActionListener(new RemoveListener());
		theView.mainMenu.addActionListener(new MainMenuListener());
		
	}
	/**
	 * Action Listener for dropping a particular course
	 * @author hamza
	 *
	 */
	class RemoveListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			courseName = theView.forName.getText();
			courseNum = Integer.parseInt(theView.forNumber.getText());
			client.communicateServerCourseScenario(4, courseName, courseNum);
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
