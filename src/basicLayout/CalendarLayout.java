package basicLayout;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.*;
import javax.swing.table.*;


public class CalendarLayout extends JPanel implements ActionListener {
	
	public CalendarLayout() {
		String months[] = {"January", "February","March", "April","May","June","July","August","September","October","November","December"};
		  
		  //Declare Frame
		  JFrame calFrame = new JFrame("CalendarFrame");
		  calFrame.setBounds(0, 0, 500, 500);
		  calFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  Container pane = calFrame.getContentPane();
		  
		  //Declare Panels
		  JPanel panelLblCurrentDate = new JPanel(null);
		  JPanel panelLblMonth = new JPanel(null);
		  JPanel panelLeftMonth = new JPanel(null); //buttons used to change the current month being viewed
		  JPanel panelRightMonth = new JPanel(null);
		  JPanel panelTable = new JPanel(null);
		  
		  //Declare Labels
		  JLabel labelCurrentDate = new JLabel(String.valueOf(Calendar.DATE-1) + ", " + months[Calendar.MONTH-1] + ", " + String.valueOf(Calendar.YEAR));
		  JLabel labelMonth = new JLabel(months[Calendar.MONTH]); //should not use current month, should be changeable
		  
		  //Current date label and panel
		  panelLblCurrentDate.setBounds(0, 0, 500, 25);
		  panelLblCurrentDate.setBorder(BorderFactory.createLineBorder(Color.black));
		  panelLblCurrentDate.add(labelCurrentDate);
		  labelCurrentDate.setBounds(250 - labelCurrentDate.getPreferredSize().width/2, 0, 500, 25); //centered
		  pane.add(panelLblCurrentDate);
		   
		  //Month label and panel  
		  panelLblMonth.setBounds(0, 25, 500, 25);
		  panelLblMonth.setBorder(BorderFactory.createLineBorder(Color.black));
		  panelLblMonth.add(labelMonth);
		  labelMonth.setBounds(250 - labelMonth.getPreferredSize().width/2, 25, 500, 25); //centered
		  pane.add(panelLblMonth);
		  
		  //Table set up
		  DefaultTableModel tableModel = new DefaultTableModel();
		  JTable calTable = new JTable(tableModel);
		  String[] columnNames = {"SUN", "MON", "TUE", "WED", "THU", "FRI","SAT"};
		  
		  
		  for(int i = 0; i < 7; i++){
		   tableModel.addColumn(columnNames[i]);
		  }
		  tableModel.setRowCount(5);
		  calTable.setRowHeight(450/tableModel.getRowCount());
		  JTableHeader tableHeader = calTable.getTableHeader(); //display days of the week
		  
		  
		  Calendar calDate = GregorianCalendar.getInstance();
		  calDate.set(Calendar.YEAR, Calendar.MONTH, 0); //sets calDate to the first day of the current month
		              //should use month at the top of the calendar in the future
		  int firstDay = calDate.DAY_OF_WEEK;    
		  
		  int dateSet = 1;
		  int j =firstDay - 1; //puts the first day of the month on the proper day of the week
		  for(int i = 0; i < 5; i++){
		   for(; j < 7; j++){
		    if(dateSet <= calDate.getActualMaximum(calDate.DAY_OF_MONTH)){
		     tableModel.setValueAt(dateSet, i, j);
		     dateSet++;
		    }
		   }
		   j=0;
		  }
		  
		  panelTable.setBounds(0, 50, 500, 450);
		  panelTable.setBorder(BorderFactory.createLineBorder(Color.black));
		  panelTable.add(tableHeader);
		  panelTable.add(calTable);
		  tableHeader.setBounds(0, 50, 500, 25);
		  calTable.setBounds(0, 75, 500, 450);
		  pane.add(panelTable);
		  
		  
		  //Display Frame
		  calFrame.pack();
		  calFrame.setVisible(true);
	}

	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
