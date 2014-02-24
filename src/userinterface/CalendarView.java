package userinterface;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.ResourceBundle;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class CalendarView extends JPanel implements ActionListener {

	ResourceBundle messages;

	public CalendarView() {

		Internationlization internationlization = new Internationlization();
		messages = internationlization.getInternationlizationBundle();

		String months[] = { messages.getString("january"),
				messages.getString("february"), messages.getString("march"),
				messages.getString("april"), messages.getString("may"),
				messages.getString("june"), messages.getString("july"),
				messages.getString("august"), messages.getString("september"),
				messages.getString("october"), messages.getString("november"),
				messages.getString("december") };

		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		// Declare Frame
		Container pane = this;

		// Declare Panels
		JPanel panelLblCurrentDate = new JPanel();
		JPanel panelLblMonth = new JPanel();
		JPanel panelLeftMonth = new JPanel(); // buttons used to change the
												// current month being viewed
		JPanel panelRightMonth = new JPanel();
		JPanel panelTable = new JPanel();

		// Declare Labels
		JLabel labelCurrentDate = new JLabel(String.valueOf(Calendar.DATE - 1)
				+ ", " + months[Calendar.MONTH - 1] + ", "
				+ String.valueOf(Calendar.YEAR));
		JLabel labelMonth = new JLabel(months[Calendar.MONTH]); // should not
																// use current
																// month, should
																// be changeable

		// Current date label and panel
		panelLblCurrentDate.setBorder(BorderFactory
				.createLineBorder(Color.black));
		panelLblCurrentDate.add(labelCurrentDate);
		pane.add(panelLblCurrentDate);

		// Month label and panel
		panelLblMonth.setBorder(BorderFactory.createLineBorder(Color.black));
		panelLblMonth.add(labelMonth);
		pane.add(panelLblMonth);

		// Table set up
		DefaultTableModel tableModel = new DefaultTableModel();
		JTable calTable = new JTable(tableModel);
		String[] columnNames = { messages.getString("sun"),
				messages.getString("mon"), messages.getString("tues"),
				messages.getString("weds"), messages.getString("thurs"),
				messages.getString("fri"), messages.getString("sat") };

		for (int i = 0; i < 7; i++) {
			tableModel.addColumn(columnNames[i]);
		}
		tableModel.setRowCount(5);
		calTable.setRowHeight(450 / tableModel.getRowCount());
		JTableHeader tableHeader = calTable.getTableHeader(); // display days of
																// the week

		Calendar calDate = GregorianCalendar.getInstance();
		calDate.set(Calendar.YEAR, Calendar.MONTH, 0); // sets calDate to the
														// first day of the
														// current month
		// should use month at the top of the calendar in the future
		int firstDay = calDate.DAY_OF_WEEK;

		int dateSet = 1;
		int j = firstDay - 1; // puts the first day of the month on the proper
								// day of the week
		for (int i = 0; i < 5; i++) {
			for (; j < 7; j++) {
				if (dateSet <= calDate.getActualMaximum(calDate.DAY_OF_MONTH)) {
					tableModel.setValueAt(dateSet, i, j);
					dateSet++;
				}
			}
			j = 0;
		}

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
