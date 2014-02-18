package controller;

import java.util.ArrayList;
import java.util.List;

import storage.Task;
import storage.TaskList;
import storage.XmlManager;
import userinterface.TaskListView;

public class TaskController {
	
	private static TaskController instance = null;

	public static synchronized TaskController getInstance() {
		if (instance == null) {
			try {
				instance = new TaskController();
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
		for(int i=0; i<tasklist.getListSize(); i++) {
			tlview.model.addElement(tasklist.getTaskByIndex(i).getTaskName());
		}
		//Init tasklist
		tlview.tlist.setModel(tlview.model);
		tlview.taskpanel.add(tlview.tlist);	
	}	

}
