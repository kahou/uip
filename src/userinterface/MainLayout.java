package userinterface;

import java.awt.*;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.LineBorder;

import storage.Task;
import storage.TaskList;

import javax.swing.plaf.metal.*;
import javax.swing.plaf.basic.*;
import javax.swing.plaf.multi.*;
import javax.swing.plaf.synth.*;

public class MainLayout extends JFrame {

	final static String LOOKANDFEEL = "Metal";
	final static String THEME = "Default";

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			public void run() {
				MainLayout ex = new MainLayout();
			}
		});
	}

	public MainLayout() {
		
		//Set the look and feel.
        initLookAndFeel();
        //Make sure we have nice window decorations.
        JFrame.setDefaultLookAndFeelDecorated(true);

		JFrame window = new JFrame();
		window.setSize(900, 700);

		JTabbedPane tabbedPane = new JTabbedPane();

		JPanel mainPane = new JPanel();
		
		
		mainPane.setLayout(new BoxLayout(mainPane, BoxLayout.LINE_AXIS));

		
		window.add(menubar, BorderLayout.NORTH);

		TaskListView tasklist1 = new TaskListView();
		// add TaskListView here

		mainPane.add(tasklist1);

		// add calendar here
		// mainPane.add(new JTextArea());
		mainPane.add(new CalendarView());

		tabbedPane.addTab("Calendar", mainPane);
		window.add(tabbedPane);
		JLabel statusbar = new JLabel("Statusbar");
		statusbar.setPreferredSize(new Dimension(-1, 22));
		statusbar.setBorder(LineBorder.createGrayLineBorder());
		window.add(statusbar, BorderLayout.SOUTH);

		window.setTitle("BorderLayout");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocationRelativeTo(null);
		window.setVisible(true);

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
