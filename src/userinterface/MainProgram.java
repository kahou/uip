package userinterface;

import controller.TaskController;
import org.joda.time.DateTime;

import storage.Task;
import storage.TaskList;

public class MainProgram {

	// Use the main method to run the application
	//

	private static TaskController taskController = new TaskController();

	public static void main(String[] args) {
				
		taskController.getNameList();
		TaskList l = taskController.getTaskList();
		l.addTask("Hello Task", "Hello", DateTime.now(), DateTime.now(), false, false, 1, "FinishTask");
		Task t = l.getTaskByIndex(0);
		t.setTaskName("I'm task1");

		// Create a Window
		//
		// UserInterface demo = new UserInterface(); // The variable can be of a
		// parent class
		taskController.getNameList();
	}
}
