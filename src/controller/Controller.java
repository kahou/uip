package controller;

import java.util.ArrayList;
import java.util.List;

import storage.Task;
import storage.TaskList;

public class Controller {

	private List<Task> newList;
	private TaskList taskList = new TaskList();

	private List<String> taskNameList = new ArrayList<String>();

	public List<String> getNameList() {
		newList = taskList.getTaskList();

		for (int i = 0; i < newList.size(); i++) {
			Task newTask;
			newTask = newList.get(i);
			taskNameList.add(newTask.getTaskName());

		}

		for (int i = 0; i < taskNameList.size(); i++) {
			System.out.println(taskNameList.get(i));

		}

		return taskNameList;
	}

}