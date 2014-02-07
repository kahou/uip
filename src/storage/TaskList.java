package storage;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;

public class TaskList {

	private Task selectedTask;
	private List<Task> taskList = new ArrayList<Task>();
	protected XmlManager xm;

	public TaskList() {
		xm = XmlManager.getInstance();
		this.taskList = xm.readTasklist();
	}
	
	public Task getTaskByIndex(int index) {
		return taskList.get(index);
	}

	public void addTask(String taskName, String taskCategory,
			DateTime createdDt, DateTime updatedDt,
			boolean isDone, boolean isDeleted, Integer priority, String taskType) {

		Task newTask = new Task(taskName, taskCategory,
				createdDt, updatedDt, isDone, isDeleted, priority, taskType);

		taskList.add(newTask);

	}




	public Task getTask(Integer taskId) {

		return selectedTask;
	}

	public List<Task> getTaskList() {

		return taskList;
	}


	public void removeTask(Integer taskId) {

		for (int i = 0; i < taskList.size(); i++) {
			Task newTask;
			newTask = taskList.get(i);
			
			if(newTask.getTaskId()== taskId){
				newTask.setDeleted(true);
			}

		}

	
	}
}
