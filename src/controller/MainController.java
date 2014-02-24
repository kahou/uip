package controller;

import storage.TaskList;
import userinterface.MainLayout;
import userinterface.TaskListView;

import javax.swing.*;

public class MainController {
	
	private static MainController instance = null;

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

}
