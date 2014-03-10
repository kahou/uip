package controller;

import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import storage.TaskList;
import userinterface.MainLayout;
import userinterface.TaskListView;

import javax.swing.*;

/**
 * 
 * MainController is the class that will control the whole program
 *	There can only be 1 instance of this class.
 */
public class MainController {
	
	private static MainController instance = null;
	private int height = 0;
	private int width = 0;
	private int inlineLeft = 0;
	private int inlineTop = 0;
	private String language = "en";
	private String country = "US";
	private static MainLayout mainLayout;
	private TaskList taskList = TaskList.getInstance();
	
	 


	public static synchronized MainController getInstance() {
		if (instance == null) {
			try {
				instance = new MainController();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return instance;
	}
	/*
	 * This is the main for the program.
	 */
	public static void main(String[] args) {
		mainLayout = new MainLayout();
		/*SwingUtilities.invokeLater(new Runnable() {

			public void run() {
				MainLayout layout = new MainLayout();

			}
		});*/
	}
	
	/**
	 * ReloadGui closes the old window and starts up a new.
	 * @author Jesper Andersson
	 */
	public void ReloadGui(){
		MainLayout temp = new MainLayout();
		mainLayout.setVisible(false); //you can't see me!
		mainLayout.dispose();
		mainLayout = temp;
		
	}
	
	/**
	 * Load tasks from db and show in the tasklistview
	 * @param tasklistview
	 */
	public void loadandshowTaskList(TaskListView tlview) {
		//Get tasklist
		TaskList tasklist = TaskList.getInstance();
		//Load to list model
        /*
		for(int i=0; i<tasklist.getListSize(); i++) {
			tlview.model.addElement(tasklist.getTaskByIndex(i).getTaskName());
		}
		//Init tasklist
		tlview.tlist.setModel(tlview.model);
		tlview.taskpanel.add(tlview.tlist);
			*/
	}
	
	/*
	 * 
	 * Getters
	 */
	public String getLanguage() {
		return this.language;
	}
	public String getCountry() {
		return this.country;
	}

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
	public TaskList getTaskList(){
		return taskList;
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
	public void setNewLanguage(String language, String country){
		this.language = language;
		this.country = country;
	}
	
	/**
	 * LoadConfig takes all the variables from the property file and saves them into the corresponding variable.
	 * @author Jesper Andersson
	 */
	public void LoadConfig() {

		File configFile = new File(System.getProperty("user.home")+System.getProperty("file.separator")+"config.properties");

		try {
			FileReader reader = new FileReader(configFile);
			Properties props = new Properties();
			props.load(reader);
			this.height = Integer.parseInt(props.getProperty("height"));
			this.width = Integer.parseInt(props.getProperty("width"));
			this.inlineLeft = Integer.parseInt(props.getProperty("inlineLeft"));
			this.inlineTop = Integer.parseInt(props.getProperty("inlineTop"));
			this.language = props.getProperty("language");
			this.country = props.getProperty("country");
			reader.close();
		} catch (FileNotFoundException ex) {
			// file does not exist
		} catch (IOException ex) {
			// I/O error
		}
	}
	// Saves the current position and size of the window
	/**
	 * SaveConfig takes all the variables and saves them to the property.
	 * @author Jesper Andersson
	 */
		public void SaveConfig() {
			File configFile = new File(System.getProperty("user.home")+System.getProperty("file.separator")+"config.properties");
			try {
				FileOutputStream out = new FileOutputStream(configFile);
				Properties props = new Properties();
				props.setProperty("height", Integer.toString(this.height));
				props.setProperty("width", Integer.toString(this.width));
				props.setProperty("inlineTop", Integer.toString(this.inlineTop));
				props.setProperty("inlineLeft", Integer.toString(this.inlineLeft));
				props.setProperty("language", language);
				props.setProperty("country", country);
				props.store(out, "");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	
	

}
