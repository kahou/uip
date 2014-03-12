package userinterface;


import java.util.ResourceBundle;

import storage.Task;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import storage.TaskList;

@SuppressWarnings("serial")
public class DetailedTaskView extends JPanel {
	public Object[][] info = TaskList.getInstance().getTaskListAsObjectArray();

	public DetailedTaskView(ResourceBundle messages){
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		PopupMenu popupMenu = new PopupMenu();
		String[] columnNames = {messages.getString("Id"),messages.getString("Name"),messages.getString("Category"),messages.getString("Priority"),messages.getString("Done?"),messages.getString("StartTime"), messages.getString("EndTime")	};
		JTable tabell = new JTable(info,columnNames);

		tabell.setAutoCreateRowSorter(true);
		tabell.setComponentPopupMenu(popupMenu);

		this.add(new JScrollPane(tabell));
	}
}
