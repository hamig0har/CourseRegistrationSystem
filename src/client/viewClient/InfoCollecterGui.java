package client.viewClient;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 * Gui to collect student information
 * @author hamza
 *
 */
public class InfoCollecterGui extends JFrame{
	
	Container mainContainer;

	public JButton enter;
	public JButton quit;
	JLabel name;
	JLabel id;
	public JTextField forName;
	public JTextField forId;
	JLabel title;
	
	public InfoCollecterGui() {
		super("Student Info");
		setSize(350,175);
		
		quit = new JButton("QUIT");
		enter = new JButton ("Submit");
		name= new JLabel("Enter Name");
		id= new JLabel("Enter Student ID");
		forName = new JTextField(20);
		forId= new JTextField(15);
		title = new JLabel("Your Information");
		
		JPanel topPanel = new JPanel();
		JPanel centerPanel = new JPanel();
		JPanel bottomPanel = new JPanel();
		
		mainContainer = getContentPane();
		mainContainer.setLayout(new BorderLayout(10,10));
		
		mainContainer.add(topPanel,BorderLayout.NORTH);
		mainContainer.add(centerPanel,BorderLayout.CENTER);
		mainContainer.add(bottomPanel,BorderLayout.SOUTH);
		
		topPanel.add(title);
		centerPanel.add(name);
		centerPanel.add(forName);
		centerPanel.add(id);
		centerPanel.add(forId);
		bottomPanel.add(enter);
		bottomPanel.add(quit);
		
		
		setVisible(true);
		
	}
	

	

}
