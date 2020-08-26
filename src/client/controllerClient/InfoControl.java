package client.controllerClient;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import client.moduleClient.Student;
import client.viewClient.InfoCollecterGui;

/**
* Class controls the Student Information Gui
* @author hamza
*
*/

public class InfoControl {
	
	private InfoCollecterGui theView;
	private String serverName;
	private int portNumber;
	private String stName;
	private int stId;
	private ClientCommunicate client;

	public InfoControl(String serverName, int portNumber) {
		this.serverName=serverName;
		this.portNumber=portNumber;
		this.theView = new InfoCollecterGui();
		theView.enter.addActionListener(new EnterListener());
		theView.quit.addActionListener(new QuitListener());
		
	}
	/**
	 * Action listener for submitting all information
	 * @author hamza
	 *
	 */
	class EnterListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			stName = theView.forName.getText();
			stId = Integer.parseInt(theView.forId.getText());
			client = new ClientCommunicate(serverName,portNumber);
			client.setUser(stName,stId); 
			client.communicateServerStudentScenario(1);
			theView.setVisible(false);
			MainGuiControl main = new MainGuiControl(serverName,portNumber,client);
		}
		
	}
	/**
	 * Action listener for quitting program
	 * @author hamza
	 *
	 */
	class QuitListener implements  ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			theView.setVisible(false);
			
		}
		
	}

	public static void main(String[] args) {
		InfoControl g = new InfoControl("localhost",8099);
	}
	
	

}
