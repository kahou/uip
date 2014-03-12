package userinterface;
import javax.swing.JFrame;

import javax.swing.*;
import javax.swing.JTextField;

import java.awt.*;

/*
 * 
 * Class Description: It is created so as to serve as a pop up window
 * for the description option under the Help menu option
 */

public class Description extends JFrame {
	
	/*
	 * The constructor
	 */
	
	public Description(){
		this.add(new DescriptionPanel());
		this.pack();
		/*this.setResizable(false); //the size of the frame cannot be changed
		this.setSize(300, 350); //setting the size of the frame
		this.setTitle("Description"); //the title of the window
        Container pane = this.getContentPane();

        pane.setLayout(new GridLayout(0,1)); //only two objects can be in each row
   
        
        //Text area is created
        JTextArea textArea = new JTextArea(24, 80);
        this.add(textArea); //the text area is added
        textArea.setText("\nThis program is a calendar with a to-do list.\nThe program i designed for the "
        		+ "course User Interface \nProgramming I in spring semester 2014."
        		+ "\nYou can see a calendar of the months of the year and \nyou can"
        		+ "dd a task in a specific day and time that \nyou want.");
        textArea.setEditable(false);  //the text area cannot be edited
        */
	  
}

    class DescriptionPanel extends JPanel {

        public DescriptionPanel() {
            setBorder(BorderFactory.createLineBorder(Color.black));
        }

        public Dimension getPreferredSize() {
            return new Dimension(650, 350);
        }

        public Dimension getSize() {
            return new Dimension(650, 350);
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            // Draw Text
            g.drawString("This program is a calendar with a to-do list.", 24, 20);
            g.drawString("A program I designed for the course User Interface Programming I in spring semester 2014.", 24, 40);
            g.drawString("You can see a calendar of the months of the year and you can", 24, 60);
            g.drawString("add a task in a specific day and time that you want.", 24, 80);
        }
    }
}