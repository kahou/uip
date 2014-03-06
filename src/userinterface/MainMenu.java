package userinterface;

import java.util.ResourceBundle;


import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 * This class is the main menu that contains the items that you can see in the menu.
 * @author Jesper Andersson
 * 
 */
public class MainMenu extends JMenuBar{
	JPanel mainPane;
	JMenuBar menubar;
	JMenu menuFile;
	JMenu menuEdit;
	JMenu menuSettings;
	JMenu menuLookandfeel;
	JMenu settingsChangeLanguage;
	JMenuItem languageEN;
	JMenuItem languageSV;
	JMenuItem languageCN;
	JMenuItem lfMetal;
	JMenuItem lfSystem;
	
	/**
	 * The constructor for MainMenu
	 * @author Jesper Andersson
	 * @param messages - The resourceBundle that contains our supported languages.
	 */
	public MainMenu(ResourceBundle messages){
		

		//Menu initialization.
		menuFile = new JMenu(messages.getString("File"));
		menuEdit = new JMenu(messages.getString("Edit"));
		menuSettings = new JMenu(messages.getString("Window"));
		menuLookandfeel = new JMenu(messages.getString("Look and Feel"));
		
		settingsChangeLanguage = new JMenu(messages.getString("ChangeLang"));
		ImageIcon changeLangIcon = new ImageIcon("n");
		
		MenuAction LangEnAct = new MenuAction(messages.getString("ChangeToEn"),changeLangIcon,"Change Language to English.",1);
		languageEN = new JMenuItem(LangEnAct);

		MenuAction LangSvAct = new MenuAction(messages.getString("ChangeToSv"),changeLangIcon,"Change Language to Swedish.",2);	
		languageSV = new JMenuItem(LangSvAct);

		languageCN = new JMenuItem("Change to Chinese");
		
		ImageIcon changeLFIcon = new ImageIcon("lf");
		MenuAction LFMetalAct = new MenuAction(messages.getString("ChangeToMetal"),changeLFIcon,"Change L&F to Metal.",3);
		lfMetal = new JMenuItem(LFMetalAct);
		
		MenuAction LFSystemAct = new MenuAction(messages.getString("ChangeToSystem"),changeLFIcon,"Change L&F to System.",4);
		lfSystem = new JMenuItem(LFSystemAct);
		
		
		
		languageEN.getAccessibleContext().setAccessibleDescription("Press this button to change language to English.");
		languageSV.getAccessibleContext().setAccessibleDescription("Press this button to change language to English.");
		languageCN.getAccessibleContext().setAccessibleDescription("Press this button to change language to English.");
		lfMetal.getAccessibleContext().setAccessibleDescription("Change Look and Feel to Metal.");
		lfSystem.getAccessibleContext().setAccessibleDescription("Change Look and Feel to System.");
		
		MenuAction LangZhAct = new MenuAction(messages.getString("ChangeToZh"),changeLangIcon,"Change Language to Chinese.",3);
		languageCN = new JMenuItem(LangZhAct);
		

		this.add(menuFile);
		this.add(menuEdit);
		this.add(menuLookandfeel);
		menuLookandfeel.add(lfMetal);
		menuLookandfeel.add(lfSystem);
		this.add(menuSettings);
		menuSettings.add(settingsChangeLanguage);
		settingsChangeLanguage.add(languageEN);
		settingsChangeLanguage.add(languageSV);
		settingsChangeLanguage.add(languageCN);
		
		
	}
	
		
}
