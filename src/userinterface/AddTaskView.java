package userinterface;
import storage.Task;

import javax.swing.*;

import org.joda.time.DateTime;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AddTaskView implements ActionListener {
	public AddTaskView(){
		
		//creation of a new frame
		JFrame popUp = new JFrame();
        popUp.pack();
        popUp.setResizable(false);
        popUp.setSize(600, 400); //setting the size of the frame
        popUp.setTitle("Add a new task"); //the title of the window
        Container pane = popUp.getContentPane();

        pane.setLayout(new GridLayout(0,2)); //only two objects can be in each row
   
        JLabel TaskNameLabel = new JLabel("Task name"); //label task name      
        pane.add(TaskNameLabel); //adding the label task name
        
        
        //create text areas
        JTextArea text1 = new JTextArea ("Write text here");  
        pane.add(text1); //adding the text area
     
	     
	   //creation of the label task category
		 JLabel taskcategory = new JLabel ("Category");
		 pane.add(taskcategory); //adding the label
	        
	     //create text areas
	     JTextArea text3 = new JTextArea ("Write text here");
	     pane.add(text3);   //adding the text area
		
	     
	   //creation of the label task start-time
		 JLabel startTime = new JLabel ("Start-time");
		 pane.add(startTime); //adding the label
	        
	     //create text areas
	     JTextArea text4 = new JTextArea ("Write text here");
	     pane.add(text4);   //adding the text area
	     
	     //creation of the label task end-time
		 JLabel endTime = new JLabel ("End-time");
		 pane.add(endTime); //adding the label
	        
	     //create text areas
	     JTextArea text5 = new JTextArea ("Write text here");
	     pane.add(text5);   //adding the text area
	    
	 	//creation of the label task description
		 JLabel priority = new JLabel ("Task Priority");
		 pane.add(priority); //adding the label
	        
	     //create text areas
	     JTextArea text2 = new JTextArea ("Write text here");
	     pane.add(text2);   //adding the text area
	     
	     //create a button to save the task
        JButton saveButton = new JButton("Save");
        pane.add(saveButton); //adding the button
        
        
       /*
        *   String t1 = text1.getText();
  	    String t2 = text3.getText();
  	    DateTime date = text4.getText();
        */
       
        
        //add an action to the save button
        saveButton.addActionListener(new ActionListener() { 
      	  public void actionPerformed(ActionEvent e) { 
      		//TaskListView.saveData(t1,t2,);
      	  } 
      	} );
      
        
        
        //keep the window visible
        popUp.setVisible(true);
       
        
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}




