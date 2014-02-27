package userinterface;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

import controller.MainController;

public class MainLayout extends JFrame {

	JFrame window;
	Internationlization internationlization;
	int num = 0;
	ResourceBundle messages;
	MainController controller;

	

	// Constructor
	public MainLayout() {

		// load all configs from property file
		controller = MainController.getInstance();
		controller.LoadConfig();

		Internationlization internationlization = new Internationlization();
		internationlization.setLanguage(controller.getLanguage());
		internationlization.setCountry(controller.getCountry());
		Internationlization internationlization2 = new Internationlization();

		messages = internationlization2.getInternationlizationBundle();

		window = new JFrame();
		window.setLocation(controller.getInlineLeft(),controller.getInlineTop());
		window.setSize(controller.getWidth(), controller.getHeight());
	
		
		
		//Menu initialization.
		JPanel mainPane = new JPanel();
		JMenuBar menubar = new MainMenu(messages);

		
		this.setJMenuBar(menubar);

		mainPane.setLayout(new BoxLayout(mainPane, BoxLayout.LINE_AXIS));

		TaskListView tasklist1 = new TaskListView();

		// add TaskListView and calendar here
		mainPane.add(tasklist1);
		mainPane.add(new CalendarView());

		/*
		 * JButton changeLanguage = new JButton("Change Language");
		 * changeLanguage.addActionListener(this); mainPane.add(changeLanguage);
		 */

		JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.addTab(messages.getString("calendar"), mainPane);

		// Create the statusbar
		/*
		 * JLabel statusbar = new JLabel("Statusbar");
		 * statusbar.setPreferredSize(new Dimension(-1, 22));
		 * statusbar.setBorder(LineBorder.createGrayLineBorder());
		 */
		window.add(menubar, BorderLayout.NORTH);
		window.add(tabbedPane);
		// window.add(statusbar, BorderLayout.SOUTH);

		window.setTitle("BorderLayout");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);

		window.addComponentListener(new ComponentListener() {
			@Override
			public void componentResized(ComponentEvent e) {
				controller.setNewSize(window.getBounds().height, window.getBounds().width);
			}

			@Override
			public void componentHidden(ComponentEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void componentMoved(ComponentEvent arg0) {
				// changes the inline varialbes on change
				controller.setNewInline(window.getBounds().x, window.getBounds().y);

			}

			@Override
			public void componentShown(ComponentEvent arg0) {
				// TODO Auto-generated method stub

			}
		});

		window.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				controller.SaveConfig();
			}
		});

	}

	
	  
	 

}
