package storage;

import org.joda.time.DateTime;

public class FloatingTask extends Task {

	public FloatingTask(int taskId, String taskName, String taskCategory,
			DateTime createdDt, DateTime updatedDt, boolean isDone,
			boolean isDeleted, Integer priority, DateTime startDt, DateTime endDt) {
		super(taskId, taskName, taskCategory, createdDt, updatedDt, isDone,
				isDeleted, priority, "FloatingTask",startDt,endDt);
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
		if (taskType != null) {
			taskToString += "taskType=" + taskType;
		}
		return taskToString;
	}

}