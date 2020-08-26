package client.controllerClient;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import client.viewClient.MainGui;

/**
 * Class controls the Main window Gui
 * @author hamza
 *
 */
public class MainGuiControl{
	
	private MainGui theView;
	private String serverName;
	private int portNumber;
	private ClientCommunicate client;


	public MainGuiControl(String serverName, int portNumber,ClientCommunicate client) {
		this.serverName = serverName;
		this.portNumber = portNumber;
		this.client = client;
		this.theView = new MainGui();
		theView.searchCourse.addActionListener(new SearchListener());
		theView.addCourse.addActionListener(new AddCourseListener());
		theView.removeCourse.addActionListener(new RemoveCourseListener());
		theView.viewAll.addActionListener(new ViewAllListener());
		theView.viewStCourses.addActionListener(new ViewStListener());
		theView.quit.addActionListener(new QuitListener());
	}
	/**
	 * Action Listener for searching for a course
	 * @author hamza
	 *
	 */
	class SearchListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			SearchGuiControl searchMenu = new SearchGuiControl(serverName, portNumber,client);
			theView.setVisible(false);
		}
		
	}
	/**
	 * Action Listener for adding a course
	 * @author hamza
	 *
	 */
	class AddCourseListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			AddCourseControl searchMenu = new AddCourseControl(serverName, portNumber,client);
			theView.setVisible(false);
			
		}
		
	}
	/**
	 * Action Listener for dropping a course
	 * @author hamza
	 *
	 */
	class RemoveCourseListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			RemoveCourseControl removeMenu = new RemoveCourseControl(serverName, portNumber,client);
			theView.setVisible(false);
			
		}
		
	}
	/**
	 * Action Listener for viewing all courses
	 * @author hamza
	 *
	 */
	class ViewAllListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			ViewAllControl viewAll = new ViewAllControl(serverName, portNumber,client);
			theView.setVisible(false);	
		}
		
	}
	/**
	 * Action Listener for viewing student courses
	 * @author hamza
	 *
	 */
	class ViewStListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			ViewStControl viewStCourses = new ViewStControl(serverName, portNumber,client);
			theView.setVisible(false);
		}
		
	}
	/**
	 * Action listener for quitting program
	 * @author hamza
	 *
	 */
	class QuitListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			theView.setVisible(false);
		}
		
	}

}
