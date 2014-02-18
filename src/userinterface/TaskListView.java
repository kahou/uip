package userinterface;

import org.joda.time.DateTime;
import storage.Task;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import controller.TaskController;

/**
 * A view that manages everything related to creating and listing Tasks in the sidebar.
 */
public class TaskListView extends JPanel implements ActionListener{
	/**
	 * don't know why this row is needed.
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args){

	}

	public JList tlist;
	public DefaultListModel model;
	public JPanel taskpanel;

	public TaskListView(){
		//create the panels needed
		JPanel taskMenu = new JPanel();
		this.taskpanel = new JPanel();



		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setPreferredSize(null);
		this.setMaximumSize(new Dimension(200,600));
		this.setBorder(BorderFactory.createLineBorder(Color.black));

		taskMenu.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		taskMenu.setPreferredSize(new Dimension(200,150));

		taskpanel.setPreferredSize(new Dimension(200,400));
		taskpanel.add(new JLabel("Tasks"));


		this.model= new DefaultListModel();
		this.tlist = new JList();

		TaskController.getInstance().loadandshowTaskList(this);


		//------------------------------------------------------
		//set the constraints for the "New task" button and add the button to taskMenu panel.
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 2;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 20;      //make this component tall
		c.weightx = 0.0;
		JButton newTask = new JButton("New Task");
		taskMenu.add(newTask,c);
		//------------------------------------------------------
		//set the constraints for the Sort by label.
		c.gridx = 0;
		c.gridy = 1;
		JLabel sortLabel = new JLabel("Sort by:", JLabel.CENTER);
		taskMenu.add(sortLabel,c);

		//------------------------------------------------------
		//set the constraints for the Sort by label.
		c.gridx = 2;
		c.gridy = 1;
		String[] sortValues = {"Starred","Priority","Color"};
		taskMenu.add(new JComboBox(sortValues),c);

		//add the menu and the tasks to the TaskListView Panel.
        this.add(taskMenu);
        this.add(taskpanel);

        newTask.addActionListener(new ActionListener() {
        	  public void actionPerformed(ActionEvent e) {
        		  AddTaskView et = new AddTaskView();
        	  }
        	} );
	}

    /**
     * Generates a panel with buttons for creating and scrollbox for sorting tasks
     * @return A panel with buttons, labels and scrollboxes.
     */
    private JPanel setupTaskList() {
        JPanel tempPanel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;

        /**
         * Create and set constraints for the "New task" button.
         * Populate the task window with the current taskListView.
         * Add the button to the pane.
         */
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.ipady = 20;      //make this component tall
        c.weightx = 1;
        JButton newTask = new JButton("New Task");
        newTask.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AddTaskView et = new AddTaskView();
            }
        });

        tempPanel.add(newTask, c);

        /**
         * Create and set the constraints for the "Sort by" label.
         * Add the label to the pane.
         */
        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = 1;
        JLabel sortLabel = new JLabel("Sort by:", JLabel.CENTER);
        tempPanel.add(sortLabel,c);


        /**
         * Create the sort values drop-down menu and set the constraints for it.
         * Add the label to the pane..
         */
        c.gridx = 2;
        c.gridy = 1;
        String[] sortValues = {"Starred","Priority","Color"};
        tempPanel.add(new JComboBox(sortValues),c);

        c.ipady = 10;
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = GridBagConstraints.REMAINDER;

        JLabel tasksLabel = new JLabel("Tasks");
        Font font;
        font = new Font(tasksLabel.getFont().getFontName(), Font.BOLD, tasksLabel.getFont().getSize());
        tasksLabel.setFont(font);
        tempPanel.add(tasksLabel, c);

        return tempPanel;
    }

    /**
     * Randomly generates numberOfTasks amount of tasks and adds them to the tasks view.
     */
    private void addTasks(int numberOfTasks) {
        for (Integer i = 1; i <= numberOfTasks; i++) {
            Task tempTask = new Task("Task no:  " +  i, "Category",
                    DateTime.now(), DateTime.now(), false,
                false, 3, "Type");

           TaskView newTaskView = new TaskView(tempTask);
           taskListView.add(newTaskView);
           taskListView.add(Box.createRigidArea(new Dimension(0, 5)));
        }
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}


}
