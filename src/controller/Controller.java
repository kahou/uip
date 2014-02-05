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
	
	/**
	 * 
	 * @param inputCommand
	 */
	public CommandAdd(CommandInfo inputCommand) {
		Task taskToAddTask = new Task();
		int taskType = decideTaskType(inputCommand);
		// Assert that taskType has taken the right value
		assert (taskType < 3 && taskType >= 0);
		switch (taskType) {
		case FLOATING:
			taskToAddTask = createFloatingTask(inputCommand);
			break;
		case DEADLINE:
			taskToAddTask = createDeadlineTask(inputCommand);
			break;
		case TIMED:
			taskToAddTask = createTimedTask(inputCommand);
			break;
		}
	}


	/**
	 * Creates a Timed Task
	 * 
	 * @param inputCommand
	 * @return Task
	 */
	private Task createTimedTask(CommandInfo inputCommand) {
		Task timedTaskToAdd = new TimedTask(0, inputCommand.getTaskName(),
				TaskCategory.TIMED, inputCommand.getStartDate(),
				inputCommand.getEndDate(), DateTime.now(), null, null, null,
				null, false, false);
		assert (timedTaskToAdd != null);
		return timedTaskToAdd;
	}

	/**
	 * Creates a Deadline Task
	 * 
	 * @param inputCommand
	 * @return Task
	 */
	private Task createDeadlineTask(CommandInfo inputCommand) {
		Task deadlineTaskToAdd = new DeadlineTask(0,
				inputCommand.getTaskName(), TaskCategory.DEADLINE,
				inputCommand.getStartDate(), DateTime.now(), null, null, null,
				null, false, false);
		assert (deadlineTaskToAdd != null);
		return deadlineTaskToAdd;
	}

	/**
	 * Creates a Floating Task
	 * 
	 * @param inputCommand
	 * @return Task
	 */
	private Task createFloatingTask(CommandInfo inputCommand) {
		Task floatingTaskToAdd = new FloatingTask(0,
				inputCommand.getTaskName(), TaskCategory.FLOATING,
				DateTime.now(), null, null, null, false, false);
		assert (floatingTaskToAdd != null);
		return floatingTaskToAdd;
	}

	
	/**
	 * Decides type of task based on input date params
	 * 
	 * @param inputCommand
	 * @return int for number of date/time specified
	 */
	private int decideTaskType(Task inputTask) {
		int typeCount = 0;
		if (inputTask.getTaskType() != null) {
			typeCount++;
		}
		if (inputTask.getTaskType() != null) {
			typeCount++;
		}
		return typeCount;
	}
	
	

}
