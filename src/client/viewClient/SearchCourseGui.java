package client.viewClient;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.*;
/**
 * Gui to search for a course
 * @author hamza
 *
 */
public class SearchCourseGui extends JFrame{
	
	Container mainContainer;
	
	public JButton search;
	public JButton mainMenu;
	
	public JTextField forName;
	public JTextField forNumber;
	public JTextArea presenter;
	JLabel enterName;
	JLabel enterNumber;
	JLabel title;
	
	public SearchCourseGui() {
		super("Search Course");
		setSize(520,520);
		
		search = new JButton("Search");
		mainMenu = new JButton("Return To Main");
		title= new JLabel("Search For Course");
		enterName= new JLabel("Enter Course Name");
		enterNumber= new JLabel("Enter Course Number");
		forName= new JTextField(7);
		forNumber= new JTextField(6);
		presenter = new JTextArea(22,50);
		
		JPanel topPanel = new JPanel();
		JPanel centerPanel = new JPanel();
		JPanel bottomPanel = new JPanel();
		
		mainContainer = getContentPane();
		mainContainer.setLayout(new BorderLayout(10,10));
		
		mainContainer.add(topPanel,BorderLayout.NORTH);
		mainContainer.add(centerPanel,BorderLayout.CENTER);
		mainContainer.add(bottomPanel,BorderLayout.SOUTH);
		
		topPanel.add(title);
		centerPanel.add(presenter);
		centerPanel.add(enterName);
		centerPanel.add(forName);
		centerPanel.add(enterNumber);
		centerPanel.add(forNumber);
		bottomPanel.add(search);
		bottomPanel.add(mainMenu);
		
		presenter.setEditable(false);
		setVisible(true);
		
	}

}
