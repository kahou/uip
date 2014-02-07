package userinterface;
import storage.Task;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;


public class AddTaskView {
	public AddTaskView(){
		JFrame popUp = new JFrame();
        popUp.pack();
        popUp.setResizable(false);
        popUp.setSize(630, 490);

        Container pane = popUp.getContentPane();

        pane.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.weightx = GridBagConstraints.HORIZONTAL;
        c.weighty = GridBagConstraints.VERTICAL;

        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.ipady = 10;
        JLabel TaskNameLabel = new JLabel("Task name");
        pane.add(TaskNameLabel, c);


        c.gridx = 6;
        c.gridy = 6;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.ipady = 10;
        JButton saveButton = new JButton("Save");
        pane.add(saveButton, c);

        popUp.setVisible(true);
	}
	
}
