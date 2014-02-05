package storage;

import org.joda.time.DateTime;

public class Task {

	private static final String DEFAULT_UNNAMED_TASK_NAME = "DEFAULT";
	protected Integer taskId;
	protected String taskName;
	protected String taskCategory;
	protected Integer priority;
	protected DateTime taskCreated;
	protected DateTime taskUpdated;
	protected Boolean isDone;
	protected Boolean isDeleted;

	public Task(int taskId, String taskName, String taskCategory,
			DateTime createdDt, DateTime updatedDt, boolean isDone,
			boolean isDeleted, Integer priority) {
		setTaskId(taskId);
		setTaskName(taskName);
		setTaskCategory(taskCategory);
		setTaskCreated(createdDt);
		setTaskUpdated(updatedDt);
		setPriority(priority);
		setDone(isDone);
		setDeleted(isDeleted);
	}

	/**
	 * To String
	 */
	public String toString() {
		String taskToString = "";
		if (taskId != null) {
			taskToString += "taskId=" + taskId;
		}
		if (taskName != null) {
			taskToString += "taskName=" + taskName;
		}
		if (taskCategory != null) {
			taskToString += "taskCategory=" + taskCategory;
		}
		if (taskCreated != null) {
			taskToString += "taskCreated=" + taskCreated.toString();
		}
		if (taskUpdated != null) {
			taskToString += "taskUpdated=" + taskUpdated.toString();
		}
		if (priority != null) {
			taskToString += "priotiy=" + priority.toString();
		}
		if (isDone != null) {
			taskToString += "isDone=" + isDone.toString();
		}
		if (isDeleted != null) {
			taskToString += "isDeleted=" + isDeleted.toString();
		}
		return taskToString;
	}

	/**
	 * Getters and Setters
	 */
	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public int getPriority() {
		return priority;
	}

	public String getTaskName() {
		return taskName;
	}

	/**
	 * Setter for Task Name
	 * 
	 * @param taskName
	 *            null and empty strings defaults to default unnamed task name
	 */
	public void setTaskName(String taskName) {
		if (isTaskNameNullOrEmpty(taskName)) {
			this.taskName = DEFAULT_UNNAMED_TASK_NAME;
		} else {
			this.taskName = taskName;
		}
	}

	protected boolean isTaskNameNullOrEmpty(String taskName) {
		return taskName == null || taskName.isEmpty();
	}

	public String getTaskCategory() {
		return taskCategory;
	}

	public void setTaskCategory(String taskCategory) {
		this.taskCategory = taskCategory;
	}

	public DateTime getTaskUpdated() {
		return this.taskUpdated;
	}

	public void setTaskUpdated(DateTime taskUpdated) {
		this.taskUpdated = taskUpdated;
	}

	public boolean isDone() {
		return isDone;
	}

	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public DateTime getTaskCreated() {
		return taskCreated;
	}

	public void setTaskCreated(DateTime taskCreated) {
		this.taskCreated = taskCreated;
	}

	public DateTime getEndDateTime() {
		return null;
	}

	public void setEndDateTime(DateTime dateTime) {
		// do nothing
	}

	public DateTime getStartDateTime() {
		return null;
	}

	public void setStartDateTime(DateTime dateTime) {
		// do nothing
	}
}