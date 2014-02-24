package userinterface;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.*;
import javax.swing.table.*;


public class CalendarView extends JPanel implements ActionListener {
    Calendar calDate = GregorianCalendar.getInstance(); //the current date displayed on the calendar
    JPanel panelTable = new JPanel();

    Container pane = this;
    String months[] = {"January", "February","March", "April","May","June","July","August","September","October","November","December"};
    JLabel labelMonth = new JLabel(months[calDate.MONTH - 1]); //should not use current month, should be changeable

    public CalendarView() {

        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        //set starting calendar month

        calDate.set(Calendar.YEAR, Calendar.MONTH - 1, 0); //sets calDate to the first day of the current month


        //Declare Frame
        Container pane = this;

        //Declare Panels
        JPanel panelLblCurrentDate = new JPanel();
        JPanel panelLblMonth = new JPanel();

        //Declare Labels
        JLabel labelCurrentDate = new JLabel(String.valueOf(Calendar.DATE-1) + ", " + months[Calendar.MONTH-1] + ", " + String.valueOf(Calendar.YEAR));

        //Current date label and panel
        panelLblCurrentDate.setBorder(BorderFactory.createLineBorder(Color.black));
        panelLblCurrentDate.add(labelCurrentDate);
        pane.add(panelLblCurrentDate);

        //Backwards icon/button to change current month displayed
        java.net.URL backArrowURL = getClass().getResource("/resources/backArrow.gif");
        if (backArrowURL != null) {
            JButton buttonBackArrow = new JButton(new ImageIcon(backArrowURL));
            panelLblMonth.add(buttonBackArrow);
            buttonBackArrow.setBorder(BorderFactory.createEmptyBorder());
            buttonBackArrow.setContentAreaFilled(false);

            buttonBackArrow.addActionListener(new ActionListener() {	//will not go back to January for some reason
                public void actionPerformed(ActionEvent e) {
                    int tempMonth = calDate.get(1);
                    calDate.set(calDate.YEAR, tempMonth - 1);
                    //tableUpdate();
                    labelMonth.setText(months[calDate.get(1)]);	//gets the month, must use get method to get correct value
                    System.out.printf("BACKWARD");
                }
            });
        }


        //Month label and panel
        panelLblMonth.setBorder(BorderFactory.createLineBorder(Color.black));
        panelLblMonth.add(labelMonth);
        pane.add(panelLblMonth);

        //Forwards icon/button to change current month displayed
        java.net.URL forwardArrowURL = getClass().getResource("/resources/forwardArrow.gif");
        if (forwardArrowURL != null) {
            JButton buttonForwardArrow = new JButton(new ImageIcon(forwardArrowURL));
            panelLblMonth.add(buttonForwardArrow);
            buttonForwardArrow.setBorder(BorderFactory.createEmptyBorder());
            buttonForwardArrow.setContentAreaFilled(false);

            buttonForwardArrow.addActionListener(new ActionListener() {	//will go out of bounds past December
                //will change year to avoid that in the future
                public void actionPerformed(ActionEvent e) {
                    int tempMonth = calDate.get(1);
                    calDate.set(calDate.YEAR, tempMonth + 1);
                    //tableUpdate();
                    labelMonth.setText(months[calDate.get(1)]);	//gets the month, must use get method to get correct value
                    System.out.printf("FORWARD");
                }
            });
        }

        tableUpdate();


    }

    public void tableUpdate(){
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
        tableHeader.setReorderingAllowed(false);
        tableHeader.setResizingAllowed(false);


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
        calTable.setEnabled(false);
        panelTable.setBorder(BorderFactory.createLineBorder(Color.black));
        panelTable.add(tableHeader);
        panelTable.add(calTable);
        pane.add(panelTable);
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        // TODO Auto-generated method stub

    }
}
