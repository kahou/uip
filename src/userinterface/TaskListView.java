package userinterface;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.ResourceBundle;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import org.joda.time.DateTime;

import storage.Task;
import storage.TaskList;
import controller.MainController;

/**
 * A view that manages everything related to creating and listing Tasks in the
 * sidebar.
 */
public class TaskListView extends JPanel implements ActionListener {
	/**
	 * don't know why this row is needed.
	 */
	private static final long serialVersionUID = 1L;

	private JPanel taskListView;
	private JPanel taskMenu;
	private MainController controller;

	ResourceBundle messages;

	public TaskListView() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		Internationlization internationlization = new Internationlization();
		messages = internationlization.getInternationlizationBundle();

		/**
		 * Create and add a TaskList to the pane.
		 */
		taskMenu = this.setupTaskList();
		this.add(taskMenu);

		/**
		 * Configuring and creating taskListView. Configuring and creating a
		 * scrolling panel that will house the list of tasks.
		 */
		taskListView = new JPanel();
		taskListView.setLayout(new BoxLayout(this.taskListView,
				BoxLayout.Y_AXIS));
		this.addTasks();

		JScrollPane scrollPane = new JScrollPane(taskListView,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		this.add(scrollPane);
	}

	/**
	 * Generates a panel with buttons for creating and scrollbox for sorting
	 * tasks
	 * 
	 * @return A panel with buttons, labels and scrollboxes.
	 */
	private JPanel setupTaskList() {
		JPanel tempPanel = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;

		/**
		 * Create and set constraints for the "New task" button. Populate the
		 * task window with the current taskListView. Add the button to the
		 * pane.
		 */
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.ipady = 20; // make this component tall
		c.weightx = 1;
		JButton newTask = new JButton(messages.getString("newtask"));
		newTask.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddTaskView et = new AddTaskView();
			}
		});

		tempPanel.add(newTask, c);

		/**
		 * Create and set the constraints for the "Sort by" label. Add the label
		 * to the pane.
		 */
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 1;
		JLabel sortLabel = new JLabel(messages.getString("sortby"),
				JLabel.CENTER);
		tempPanel.add(sortLabel, c);

		/**
		 * Create the sort values drop-down menu and set the constraints for it.
		 * Add the label to the pane..
		 */
		c.gridx = 2;
		c.gridy = 1;
		String[] sortValues = { messages.getString("starred"),
				messages.getString("priority"), messages.getString("color") };
		tempPanel.add(new JComboBox(sortValues), c);

		c.ipady = 10;
		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = GridBagConstraints.REMAINDER;

		JLabel tasksLabel = new JLabel(messages.getString("tasks"));
		Font font;
		font = new Font(tasksLabel.getFont().getFontName(), Font.BOLD,
				tasksLabel.getFont().getSize());
		tasksLabel.setFont(font);
		tempPanel.add(tasksLabel, c);

		return tempPanel;
	}

	private void addTasks() {
		TaskList taskList = TaskList.getInstance();

		for (Task tempTask : taskList.getTaskList()) {
			TaskView newTaskView = new TaskView(tempTask);
			taskListView.add(newTaskView);
			taskListView.add(Box.createRigidArea(new Dimension(0, 5)));
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
	public void saveData (AddTaskView addTask){
		TaskList t1 = new TaskList();
		//AddTaskView task = new AddTaskView();
		//String tn = AddTaskView.text1.getText();
		t1.addTask("tname", "category", new DateTime(), new DateTime(), false, false, 0, "type",new DateTime(),new DateTime());
		}
}
