package userinterface;

import org.joda.time.DateTime;

import controller.Controller;
import storage.Task;
import storage.TaskList;
import storage.XmlManager;
import controller.Controller;

public class MainProgram {

	// Use the main method to run the application
	//

	private static Controller controller2 = new Controller();

	public static void main(String[] args) {
				
		controller2.getNameList();
		TaskList l = controller2.getTaskList();
		l.addTask("Hello Task", "Hello", DateTime.now(), DateTime.now(), false, false, 1, "FinishTask");
		Task t = l.getTaskByIndex(0);
		t.setTaskName("I'm task1");

		// Create a Window
		//
		// UserInterface demo = new UserInterface(); // The variable can be of a
		// parent class
		controller2.getNameList();
	}
}
