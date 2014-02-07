package storage;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

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
	protected String taskType;
	protected XmlManager xm;

	/*
	 * Init without taskID
	 */
	public Task (String taskName, String taskCategory,
			DateTime createdDt, DateTime updatedDt, boolean isDone,
			boolean isDeleted, Integer priority, String taskType) {
		
		xm = XmlManager.getInstance();
		
		this.taskName = taskName;
		this.taskCategory = taskCategory;
		this.priority = priority;
		this.taskCreated = createdDt;
		this.taskUpdated = updatedDt;
		this.isDone = isDone;
		this.isDeleted = isDeleted;
		this.taskType = taskType;
		this.taskId = xm.newtask(this);
		
		
	}
	
	/*
	 * Init for reading xml
	 */
	public Task(int taskId, String taskName, String taskCategory,
			DateTime createdDt, DateTime updatedDt, boolean isDone,
			boolean isDeleted, Integer priority, String taskType) {
		
		xm = XmlManager.getInstance();
		
		this.taskId = taskId;
		this.taskName = taskName;
		this.taskCategory = taskCategory;
		this.priority = priority;
		this.taskCreated = createdDt;
		this.taskUpdated = updatedDt;
		this.isDone = isDone;
		this.isDeleted = isDeleted;
		this.taskType = taskType;
	
	}

=======

	public Task(int taskId, String taskName, String taskCategory,
			DateTime createdDt, DateTime updatedDt, boolean isDone,
			boolean isDeleted, Integer priority, String taskType) {
		setTaskId(taskId);
		setTaskName(taskName);
		setTaskCategory(taskCategory);
		setTaskCreated(createdDt);
		setTaskUpdated(updatedDt);
		setPriority(priority);
		setDone(isDone);
		setDeleted(isDeleted);
		setTaskType(taskType);
	}

	public void setTaskType(String taskType2) {
		this.taskType = taskType2;
		
	}
	
	public String getTaskType() {
		return taskType;
		
	}
>>>>>>> master
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
		if (taskType != null) {
			taskToString += "taskType=" + taskType;
		}
		return taskToString;
	}

	/**
	 * Getters and Setters
	 */
	public void setTaskType(String taskType2) {
		this.taskType = taskType2;
		
		xm.editTask(this.taskId, "tasktype", this.taskType);
	}
	
	public String getTaskType() {
		return taskType;
		
	}
	
	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
		
		xm.editTask(this.taskId, "priority", Integer.toString(this.priority));
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
		
		xm.editTask(this.taskId, "taskname", this.taskName);
=======
	}

	protected boolean isTaskNameNullOrEmpty(String taskName) {
		return taskName == null || taskName.isEmpty();
>>>>>>> master
	}

	public String getTaskCategory() {
		return taskCategory;
	}

	public void setTaskCategory(String taskCategory) {
		this.taskCategory = taskCategory;
		
		xm.editTask(this.taskId, "taskcategory", this.taskCategory);
	}

	public DateTime getTaskUpdated() {
		return this.taskUpdated;
	}

	public void setTaskUpdated(DateTime taskUpdated) {
		this.taskUpdated = taskUpdated;
		
		DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yyyy HH:mm:ss");
		xm.editTask(this.taskId, "taskUpdated", this.taskUpdated.toString(formatter));
	}

	public boolean isDone() {
		return isDone;
	}

	public void setDone(boolean isDone) {
		this.isDone = isDone;
		
		xm.editTask(this.taskId, "isDone", this.isDone.toString());
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
		xm.editTask(this.taskId, "isDeleted", this.isDeleted.toString());
	}

	public DateTime getTaskCreated() {
		return taskCreated;
	}

	public void setTaskCreated(DateTime taskCreated) {
		this.taskCreated = taskCreated;
		
		DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yyyy HH:mm:ss");
		xm.editTask(this.taskId, "taskCreated", this.taskCreated.toString(formatter));
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
	
	protected boolean isTaskNameNullOrEmpty(String taskName) {
		return taskName == null || taskName.isEmpty();
	}
}
