package client.viewClient;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
/**
 * Gui for viewing all student courses
 * @author hamza
 *
 */
public class ViewStCourses extends JFrame{

	Container mainContainer;

	public JButton mainMenu;
	public JTextArea presenter;
	JLabel title;
	
	public ViewStCourses() {
		super("View Student Courses");
		setSize(500,275);
		
		mainMenu = new JButton("Return to Main");
		title= new JLabel("Your Courses");
		presenter = new JTextArea(8,50);
		presenter.setEditable(false);
		JScrollPane bars=  new JScrollPane(presenter,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		JPanel topPanel = new JPanel();
		JPanel centerPanel = new JPanel();
		JPanel bottomPanel = new JPanel();
		
		mainContainer = getContentPane();
		mainContainer.setLayout(new BorderLayout(10,10));
		
		mainContainer.add(topPanel,BorderLayout.NORTH);
		mainContainer.add(centerPanel,BorderLayout.CENTER);
		mainContainer.add(bottomPanel,BorderLayout.SOUTH);
		
		topPanel.add(title);
		centerPanel.add(bars);
		bottomPanel.add(mainMenu);
		
		setVisible(true);
	}
}

