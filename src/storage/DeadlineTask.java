package storage;

import org.joda.time.DateTime;

public class DeadlineTask extends Task {

	private DateTime endDateTime;

	/**
	 * Constructor with TaskCategory taskCategory
	 * 
	 * @param taskId
	 * @param taskName
	 * @param taskCategory
	 * @param endDt
	 * @param createdDt
	 * @param updatedDt
	 * @param isDone
	 * @param isDeleted
	 */
	public DeadlineTask(int taskId, String taskName, String taskCategory,
			DateTime createdDt, DateTime updatedDt,
			boolean isDone, boolean isDeleted, Integer priority, DateTime startDt, DateTime endDt) {
		super(taskId, taskName, taskCategory, createdDt, updatedDt, isDone,
				isDeleted, priority, "DeadlineTask",startDt,endDt);
		setEndDateTime(endDt);
	}

	/**
	 * Return endDateTime for startDateTime
	 */
	public DateTime getStartDateTime() {
		return endDateTime;
	}

	public DateTime getEndDateTime() {
		return endDateTime;
	}

	public void setEndDateTime(DateTime endDateTime) {
		this.endDateTime = endDateTime;
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
		if (endDateTime != null) {
			taskToString += "endDateTime=" + endDateTime.toString();
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

	private String getTimeString(DateTime date) {
		String timeString = "";

		if (date.getMinuteOfHour() == 0) {
			timeString = date.toString("h aa");
		} else {
			timeString = date.toString("h.mm aa");
		}

		return timeString;
	}

}