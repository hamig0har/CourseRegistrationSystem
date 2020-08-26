package client.viewClient;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.*;
/**
 * Gui for the main window
 * @author hamza
 *
 */
public class MainGui extends JFrame {
	
	Container mainContainer;
	
	public JButton searchCourse;
	public JButton addCourse;
	public JButton removeCourse;
	public JButton viewAll;
	public JButton viewStCourses;
	public JButton quit;
	
	JLabel choose;
	JLabel space;
	
	public MainGui() {
		super("Main Menu");
		setSize(450,250);
		
		searchCourse = new JButton("Search for a Course");
		addCourse = new JButton("Add a Course");
		removeCourse = new JButton("Drop a Course");
		viewAll = new JButton("View all Courses Availible");
		viewStCourses = new JButton("View your Courses");
		quit = new JButton("QUIT");
		choose = new JLabel("Choose an Option");
		space = new JLabel("\n");


		
		JPanel topPanel = new JPanel();
		JPanel centerPanel = new JPanel();
		JPanel bottomPanel = new JPanel();
		
		mainContainer = getContentPane();
		mainContainer.setLayout(new BorderLayout(10,10));
		
		mainContainer.add(topPanel,BorderLayout.NORTH);
		mainContainer.add(centerPanel,BorderLayout.CENTER);
		mainContainer.add(bottomPanel,BorderLayout.SOUTH);
		
		topPanel.add(choose);
		centerPanel.add(searchCourse);
		centerPanel.add(space);
		centerPanel.add(addCourse);
		
		centerPanel.add(removeCourse);
		
		centerPanel.add(viewAll);
		
		centerPanel.add(viewStCourses);
		
		bottomPanel.add(quit);
		
		setVisible(true);
		
	}

}
