package client.controllerClient;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import client.viewClient.ViewAllGui;
/**
 * Class controls the View All Course Gui
 * @author hamza
 *
 */
public class ViewAllControl {
	
	private ViewAllGui theView;
	private String serverName;
	private int portNumber;
	private ClientCommunicate client;

	public ViewAllControl(String serverName, int portNumber, ClientCommunicate client) {
		this.serverName=serverName;
		this.portNumber=portNumber;
		this.client = client;
		this.theView = new ViewAllGui();
	    theView.mainMenu.addActionListener(new MainMenuListener());
		client.communicateServer(5,theView);
		System.out.println("All done");
		
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
