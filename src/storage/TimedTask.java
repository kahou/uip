package storage;

import org.joda.time.DateTime;

public class TimedTask extends Task {

	private DateTime startDateTime;
	private DateTime endDateTime;

	/**
	 * Full Constructor with TaskCategory taskCategory
	 * 
	 * @param taskId
	 * @param taskName
	 * @param taskCategory
	 * @param startDt
	 * @param endDt
	 * @param createdDt
	 * @param updatedDt
	 * 
	 * @param isDone
	 * @param isDeleted
	 */
	public TimedTask(int taskId, String taskName, String taskCategory,
			DateTime startDt, DateTime endDt, DateTime createdDt,
			DateTime updatedDt, boolean isDone, boolean isDeleted,
			Integer priority) {
		super(taskId, taskName, taskCategory, createdDt, updatedDt, isDone,
				isDeleted, priority);
		setStartDateTime(startDt);
		setEndDateTime(endDt);

	}

	public DateTime getStartDateTime() {
		return startDateTime;
	}

	public void setStartDateTime(DateTime startDateTime) {
		this.startDateTime = startDateTime;
	}

	public DateTime getEndDateTime() {
		return endDateTime;
	}

	public void setEndDateTime(DateTime endDateTime) {
		this.endDateTime = endDateTime;
	}

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
		if (startDateTime != null) {
			taskToString += "startDateTime=" + startDateTime.toString();
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
		return taskToString;
	}

	private boolean dateIsEqual(DateTime date1, DateTime date2) {
		if (date1.getDayOfYear() == date2.getDayOfYear()
				&& date1.getYear() == date2.getYear()) {
			return true;
		}
		return false;
	}

	private String getDateString(DateTime date) {
		return date.toString("dd MMM yy");
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