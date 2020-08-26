package client.controllerClient;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import client.controllerClient.InfoControl.EnterListener;
import client.controllerClient.InfoControl.QuitListener;
import client.viewClient.InfoCollecterGui;
import client.viewClient.SearchCourseGui;
/**
 * Class controls the Search course Gui
 * @author hamza
 *
 */
public class SearchGuiControl {
	
	private SearchCourseGui theView;
	private String serverName;
	private int portNumber;
	private String courseName;
	private int courseNum;
	private ClientCommunicate client;
	
	public SearchGuiControl(String serverName, int portNumber, ClientCommunicate client) {
		this.serverName=serverName;
		this.portNumber=portNumber;
		this.client = client;
		this.theView = new SearchCourseGui();
		theView.search.addActionListener(new SearchListener());
		theView.mainMenu.addActionListener(new MainMenuListener());
	}
	/**
	 * Action Listener for searching for a course
	 * @author hamza
	 *
	 */
	class SearchListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			theView.presenter.setEditable(true);
			courseName = theView.forName.getText();
			courseNum = Integer.parseInt(theView.forNumber.getText());
			client.communicateServerCourseScenario(2, courseName, courseNum,theView);
			theView.presenter.setEditable(false);
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
