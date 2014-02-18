package userinterface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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


public class TaskListView extends JPanel implements ActionListener{
	/**
	 * 
	 */
	//dont know why this row is needed.
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
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}