package userinterface;

import java.awt.BorderLayout;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
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
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;

public class MainLayout extends JFrame {
	int height = 0;
	int width = 0;
	int inlineLeft = 0;
	int inlineTop = 0;
	JFrame window;
	Internationlization internationlization;
	int num = 0;
	ResourceBundle messages;

	String language = "en";
	String country = "US";

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {

			public void run() {
				MainLayout ex = new MainLayout();

			}
		});
	}

	/*
	 * 
	 * Getters
	 */

	public int getHeight() {
		return this.height;
	}

	public int getWidth() {
		return this.width;
	}

	public int getInlineTop() {
		return this.inlineTop;
	}

	public int getInlineLeft() {
		return this.inlineLeft;
	}

	/*
	 * 
	 * Setters
	 */
	public void setNewSize(int height, int width) {
		this.height = height;
		this.width = width;
	}

	public void setNewInline(int inlineLeft, int inlineTop) {
		this.inlineLeft = inlineLeft;
		this.inlineTop = inlineTop;
	}

	// Loads all the properties from the properties file
	private void LoadConfig() {

		File configFile = new File("src/config.properties");

		try {
			FileReader reader = new FileReader(configFile);
			Properties props = new Properties();
			props.load(reader);
			this.height = Integer.parseInt(props.getProperty("height"));
			this.width = Integer.parseInt(props.getProperty("width"));
			this.inlineLeft = Integer.parseInt(props.getProperty("inlineLeft"));
			this.inlineTop = Integer.parseInt(props.getProperty("inlineTop"));
			reader.close();
		} catch (FileNotFoundException ex) {
			// file does not exist
		} catch (IOException ex) {
			// I/O error
		}
	}

	// Saves the current position and size of the window
	private void SaveConfig() {
		File configFile = new File("src/config.properties");
		try {
			FileOutputStream out = new FileOutputStream(configFile);
			Properties props = new Properties();
			props.setProperty("height", Integer.toString(getHeight()));
			props.setProperty("width", Integer.toString(getWidth()));
			props.setProperty("inlineTop", Integer.toString(getInlineTop()));
			props.setProperty("inlineLeft", Integer.toString(getInlineLeft()));
			props.store(out, "");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Constructor
	public MainLayout() {

		// load all configs from property file
		this.LoadConfig();

		Internationlization internationlization = new Internationlization();
		internationlization.setLanguage(language);
		internationlization.setCountry(country);
		Internationlization internationlization2 = new Internationlization();

		messages = internationlization2.getInternationlizationBundle();

		window = new JFrame();
		window.setLocation(this.inlineTop, this.inlineLeft);
		window.setSize(this.width, this.height);

		JPanel mainPane = new JPanel();
		JMenuBar menubar = new JMenuBar();
		JMenu file = new JMenu(messages.getString("File"));
		JMenu file2 = new JMenu(messages.getString("Edit"));
		JMenu file3 = new JMenu(messages.getString("Window"));

		menubar.add(file);
		menubar.add(file2);
		menubar.add(file3);

		setJMenuBar(menubar);

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
				setNewSize(window.getBounds().height, window.getBounds().width);
			}

			@Override
			public void componentHidden(ComponentEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void componentMoved(ComponentEvent arg0) {
				// changes the inline varialbes on change
				setNewInline(window.getBounds().x, window.getBounds().y);
				System.out.println(window.getBounds().x + ","
						+ window.getBounds().y);

			}

			@Override
			public void componentShown(ComponentEvent arg0) {
				// TODO Auto-generated method stub

			}
		});

		window.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				SaveConfig();
			}
		});

	}

	/*
	 * @Override public void actionPerformed(ActionEvent arg0) {
	 * 
	 * num++; if (num > 2) { num = 0; } String[][] langArray = { { "en", "US" },
	 * { "sv", "SE" }, { "zh", "CN" }, }; System.out.print(langArray[num][0] +
	 * langArray[num][1]);
	 * 
	 * language = langArray[num][0]; country = langArray[num][1];
	 * internationlization = new Internationlization();
	 * 
	 * messages = internationlization.getInternationlizationBundle();
	 * 
	 * }
	 */

}
