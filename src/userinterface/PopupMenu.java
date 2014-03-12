package userinterface;

import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

@SuppressWarnings("serial")
public class PopupMenu extends JPopupMenu {
	public PopupMenu(){
		
		ImageIcon icon = new ImageIcon("n");
		MenuAction itemAct = new MenuAction("Add new Task",icon,"Press here to add a task",1337);
		MenuAction item2Act = new MenuAction("Delete Task",icon,"Press here to delete this task",1338);
		MenuAction item3Act = new MenuAction("Edit Task",icon,"Press here to Edit this task",1339);
		
		JMenuItem item = new JMenuItem(itemAct);
		JMenuItem item2 = new JMenuItem(item2Act);
		JMenuItem item3 = new JMenuItem(item3Act);
		
		this.add(item);
		this.add(item2);
		this.add(item3);
	}
}
