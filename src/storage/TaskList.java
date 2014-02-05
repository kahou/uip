package storage;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;

public class TaskList {

	private Task selectedTask;
	private List<Task> taskList = new ArrayList<Task>();

	public TaskList() {

		DateTime createdDt = new DateTime();
		DateTime updatedDt = new DateTime();

		createdDt = DateTime.now();
		updatedDt = DateTime.now();
		DateTime endDt = new DateTime();
		DateTime startdDt = new DateTime();

		createdDt = DateTime.now();
		updatedDt = DateTime.now();

		addTask(1, "floating task 2", "meeting", startdDt, endDt, createdDt,
				updatedDt, false, false, 1);

		addTask(1, "task 1", "home", createdDt, updatedDt, false, false, 1);
		addTask(1, "task 2", "home", createdDt, updatedDt, false, false, 2);
		addTask(1, "task 3", "school", createdDt, updatedDt, false, false, 4);
		addTask(1, "task 4", "work", createdDt, updatedDt, false, false, 1);
		addTask(1, "deadline task 5", "school", endDt, createdDt, updatedDt,
				false, false, 2);

		addTask(1, "floating task 6", "meeting", startdDt, endDt, createdDt,
				updatedDt, false, false, 1);

	}

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

	}

	public void removeTask(Integer taskId) {

	}

	public Task getTask(Integer taskId) {

		return selectedTask;
	}

	public List<Task> getTaskList() {

		return taskList;
	}

}
