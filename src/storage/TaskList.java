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
		/*
=======

	public TaskList() {

>>>>>>> master
		DateTime createdDt = new DateTime();
		DateTime updatedDt = new DateTime();

		createdDt = DateTime.now();
		updatedDt = DateTime.now();
		
		DateTime endDt = new DateTime();
		DateTime startdDt = new DateTime();

		createdDt = DateTime.now();
		updatedDt = DateTime.now();*/
/*
=======
		updatedDt = DateTime.now();

>>>>>>> master
		addTask(1, "timed task 2", "meeting", startdDt, endDt, createdDt,
				updatedDt, false, false, 1);

		addTask(1, "task 1", "home", createdDt, updatedDt, false, false, 1);
		addTask(1, "task 2", "home", createdDt, updatedDt, false, false, 2);
		addTask(1, "task 3", "school", createdDt, updatedDt, false, false, 4);
		addTask(1, "task 4", "work", createdDt, updatedDt, false, false, 1);
		addTask(1, "deadline task 5", "school", endDt, createdDt, updatedDt,
				false, false, 2);

		addTask(1, "timed task 6", "meeting", startdDt, endDt, createdDt,
				updatedDt, false, false, 1);
*/
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


	public void removeTask(Integer taskId) {

		for (int i = 0; i < taskList.size(); i++) {
			Task newTask;
			newTask = taskList.get(i);
			
			if(newTask.getTaskId()== taskId){
				newTask.setDeleted(true);
			}

		}

	
	}

	public Task getTask(Integer taskId) {

		return selectedTask;
	}

	public List<Task> getTaskList() {

		return taskList;
	}
	
	/*
=======

	}

>>>>>>> master
	public void addTask(int taskId, String taskName, String taskCategory,
			DateTime endDt, DateTime createdDt, DateTime updatedDt,
			boolean isDone, boolean isDeleted, Integer priority) {

		DeadlineTask newTask = new DeadlineTask(taskId, taskName, taskCategory,
				endDt, createdDt, updatedDt, isDone, isDeleted, priority);

		taskList.add(newTask);

	}

	public void addTask(int taskId, String taskName, String taskCategory,
			DateTime createdDt, DateTime updatedDt, boolean isDone,
			boolean isDeleted, Integer priority) {

		FloatingTask newTask = new FloatingTask(taskId, taskName, taskCategory,
				createdDt, updatedDt, isDone, isDeleted, priority);

		taskList.add(newTask);

	}

	public void addTask(int taskId, String taskName, String taskCategory,
			DateTime startDt, DateTime endDt, DateTime createdDt,
			DateTime updatedDt, boolean isDone, boolean isDeleted,
			Integer priority) {

		TimedTask newTask = new TimedTask(taskId, taskName, taskCategory,
				startDt, endDt, createdDt, updatedDt, isDone, isDeleted,
				priority);

		taskList.add(newTask);

	}*/
=======
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

	public Task getTask(Integer taskId) {

		return selectedTask;
	}

	public List<Task> getTaskList() {

		return taskList;
	}
>>>>>>> master

}
