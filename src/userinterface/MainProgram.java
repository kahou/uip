package userinterface;

import controller.Controller;

public class MainProgram {

	// Use the main method to run the application
	//

	private static Controller controller2 = new Controller();

	public static void main(String[] args) {

		// Create a Window
		//
		// UserInterface demo = new UserInterface(); // The variable can be of a
		// parent class
		controller2.getNameList();
	}
}
