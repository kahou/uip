package userinterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ResourceBundle;


import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class MainMenu extends JMenuBar{
	JPanel mainPane;
	JMenuBar menubar;
	JMenu menuFile;
	JMenu menuEdit;
	JMenu menuSettings;
	JMenu settingsChangeLanguage;
	JMenuItem languageEN;
	JMenuItem languageSV;
	JMenuItem languageCN;
	
	public MainMenu(ResourceBundle messages){
		

		//Menu initialization.
		menuFile = new JMenu(messages.getString("File"));
		menuEdit = new JMenu(messages.getString("Edit"));
		menuSettings = new JMenu(messages.getString("Window"));
		
		settingsChangeLanguage = new JMenu("Change Language");
		ImageIcon changeLangIcon = new ImageIcon("n");
		MenuAction LangEnAct = new MenuAction(messages.getString("ChangeToEn"),changeLangIcon,"Change Language to English.",1);
		languageEN = new JMenuItem(LangEnAct);

		MenuAction LangSvAct = new MenuAction(messages.getString("ChangeToSv"),changeLangIcon,"Change Language to Swedish.",2);	
		languageSV = new JMenuItem(LangSvAct);
		languageCN = new JMenuItem("Change to Chinese");
		
		
		
		languageEN.getAccessibleContext().setAccessibleDescription("Press this button to change language to English.");
		languageSV.getAccessibleContext().setAccessibleDescription("Press this button to change language to English.");
		languageCN.getAccessibleContext().setAccessibleDescription("Press this button to change language to English.");
		

		this.add(menuFile);
		this.add(menuEdit);
		this.add(menuSettings);
		menuSettings.add(settingsChangeLanguage);
		settingsChangeLanguage.add(languageEN);
		settingsChangeLanguage.add(languageSV);
		settingsChangeLanguage.add(languageCN);
		
		

	}
	
		
}
