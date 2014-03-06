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
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.metal.*;
import javax.swing.plaf.basic.*;
import javax.swing.plaf.multi.*;
import javax.swing.plaf.synth.*;

import controller.MainController;
/**
 * 
 * MainLayout is the main gui class that contains everything the gui has.
 * 
 *
 */
public class MainLayout extends JFrame {

	JFrame window;
	Internationlization internationlization;
	int num = 0;
	ResourceBundle messages;
	MainController controller = MainController.getInstance();

	final static String LOOKANDFEEL = "Metal";
	final static String THEME = "Default";



	// Constructor
	public MainLayout() {

		// load all configs from property file
		controller.LoadConfig();

		Internationlization internationlization = new Internationlization();
		internationlization.setLanguage(controller.getLanguage());
		internationlization.setCountry(controller.getCountry());
		Internationlization internationlization2 = new Internationlization();

		messages = internationlization2.getInternationlizationBundle();
		
		//Set the look and feel.
        initLookAndFeel();
        //Make sure we have nice window decorations.
        JFrame.setDefaultLookAndFeelDecorated(true);
		

		window = this;
		this.setLocation(controller.getInlineLeft(),controller.getInlineTop());
		this.setSize(controller.getWidth(), controller.getHeight());


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

		this.add(menubar, BorderLayout.NORTH);
		this.add(tabbedPane);
		this.setTitle(messages.getString("calendar"));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

		this.addComponentListener(new ComponentListener() {
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

	private static void initLookAndFeel() {
		String lookAndFeel = null;

		if (LOOKANDFEEL != null) {
			if (LOOKANDFEEL.equals("Metal")) {
				lookAndFeel = "javax.swing.plaf.metal.MetalLookAndFeel";
			}
			else if (LOOKANDFEEL.equals("System")) {
				lookAndFeel = UIManager.getSystemLookAndFeelClassName();
			}
			else if (LOOKANDFEEL.equals("Motif")) {
				lookAndFeel = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";
			}
			else if (LOOKANDFEEL.equals("GTK")) {
				lookAndFeel = "com.sun.java.swing.plaf.gtk.GTKLookAndFeel";
			}
			else {
				System.err.println("Unexpected value of LOOKANDFEEL specified: " + LOOKANDFEEL);
				lookAndFeel = UIManager.getCrossPlatformLookAndFeelClassName();
			}

			try {
				UIManager.setLookAndFeel(lookAndFeel);

				// If L&F = "Metal", set the theme
				if (LOOKANDFEEL.equals("Metal")) {
					if (THEME.equals("DefaultMetal")) {
						MetalLookAndFeel.setCurrentTheme(new DefaultMetalTheme());
					} else {
						MetalLookAndFeel.setCurrentTheme(new OceanTheme());
					}
					UIManager.setLookAndFeel(new MetalLookAndFeel());
				}
			}
			catch (ClassNotFoundException e) {
				System.err
						.println("Couldn't find class for specified look and feel:"
								+ lookAndFeel);
				System.err
						.println("Did you include the L&F library in the class path?");
				System.err.println("Using the default look and feel.");
			}
			catch (UnsupportedLookAndFeelException e) {
				System.err.println("Can't use the specified look and feel ("
						+ lookAndFeel + ") on this platform.");
				System.err.println("Using the default look and feel.");
			}
			catch (Exception e) {
				System.err.println("Couldn't get specified look and feel ("
						+ lookAndFeel + "), for some reason.");
				System.err.println("Using the default look and feel.");
				e.printStackTrace();
			}
		}
	}




}