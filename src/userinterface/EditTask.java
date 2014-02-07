package userinterface;
import javax.swing.*;
import java.awt.*;


public class EditTask {
	public EditTask(){
		JFrame popUp = new JFrame();
        popUp.pack();
        popUp.setResizable(false);
        popUp.setSize(630, 490);

        Container pane = popUp.getContentPane();

        pane.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.gridx = 6;
        c.gridy = 6;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.ipady = 10;
        c.weightx = 1;
        JButton saveButton = new JButton("Save");
        pane.add(saveButton);

        popUp.setVisible(true);
	}
	
}
