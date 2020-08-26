package client.viewClient;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.*;
/**
 * Gui for adding a course
 * @author hamza
 *
 */
public class AddCourseGui extends JFrame{

Container mainContainer;
	
	public JButton add;
	public JButton mainMenu;
	
	public JTextField forName;
	public JTextField forNumber;
	JLabel enterName;
	JLabel enterNumber;
	JLabel title;
	
	public AddCourseGui() {
		super("Add Course");
		setSize(450,150);
		
		add = new JButton("Add");
		mainMenu = new JButton("Return To Main");
		title= new JLabel("Add a Course");
		enterName= new JLabel("Enter Course Name");
		enterNumber= new JLabel("Enter Course Number");
		forName= new JTextField(7);
		forNumber= new JTextField(6);
		
		JPanel topPanel = new JPanel();
		JPanel centerPanel = new JPanel();
		JPanel bottomPanel = new JPanel();
		
		mainContainer = getContentPane();
		mainContainer.setLayout(new BorderLayout(10,10));
		
		mainContainer.add(topPanel,BorderLayout.NORTH);
		mainContainer.add(centerPanel,BorderLayout.CENTER);
		mainContainer.add(bottomPanel,BorderLayout.SOUTH);
		
		topPanel.add(title);
		centerPanel.add(enterName);
		centerPanel.add(forName);
		centerPanel.add(enterNumber);
		centerPanel.add(forNumber);
		bottomPanel.add(add);
		bottomPanel.add(mainMenu);
		
		setVisible(true);
		
	}

}
