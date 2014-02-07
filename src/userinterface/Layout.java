package userinterface;

import java.awt.*;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;

public class Layout extends JFrame {
	
	public static void main(String[] args){
		 SwingUtilities.invokeLater(new Runnable() {

	            public void run() {
	                Layout ex = new Layout();
	               
	            }
	        });
	}
	
	public Layout(){
		
		JFrame window = new JFrame();
		window.setSize(900, 700);
		
		JTabbedPane tabbedPane = new JTabbedPane();
		
		
		JPanel mainPane = new JPanel();
		JMenuBar menubar = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenu file2 = new JMenu("Edit");
        JMenu file3 = new JMenu("Window");
        //JPanel taskList = new JPanel();
        
        mainPane.setLayout(new BoxLayout(mainPane, BoxLayout.LINE_AXIS));
        
		
        menubar.add(file);
        menubar.add(file2);
        menubar.add(file3);
        setJMenuBar(menubar);
        
        window.add(menubar, BorderLayout.NORTH);
        
        
        TaskList tasklist1 = new TaskList();
        //add TaskList here
        
        mainPane.add(tasklist1);
       
        //add calendar here
        //mainPane.add(new JTextArea());
        mainPane.add(new CalendarLayout());
        
        tabbedPane.addTab("Calendar", mainPane);
        window.add(tabbedPane);
        JLabel statusbar = new JLabel("Statusbar");
        statusbar.setPreferredSize(new Dimension(-1, 22));
        statusbar.setBorder(LineBorder.createGrayLineBorder());
        window.add(statusbar, BorderLayout.SOUTH);

        
        window.setTitle("BorderLayout");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
	}
	
	
}
