package storage;

import org.dom4j.*;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class XmlManager {

	private static final String XML_FILE_PATH = "db/tmdb.xml";
	protected Document doc;
	protected Element root;
	protected int taskcount;
	private static XmlManager instance = null;

	public static synchronized XmlManager getInstance() {
		if (instance == null) {
			try {
				instance = new XmlManager();
			} catch (Exception e) {
				System.out.println(e.toString());
			}
		}
		return instance;
	}

	/**
	 * Initialization
	 */
	public XmlManager() throws Exception {
		File dbfile = new File(XML_FILE_PATH);
		if (!dbfile.exists()) {
			doc = DocumentHelper.createDocument();
			Element root = doc.addElement("tasks");
			this.write(doc);
			taskcount = 0;
		} else {
			SAXReader reader = new SAXReader();
			doc = reader.read(XML_FILE_PATH);
			List list = doc.selectNodes("/tasks/task");
			taskcount = list.size();
		}
		root = doc.getRootElement();
	}
	
	public void clear() {
		try {
			FileWriter writer = new FileWriter(XML_FILE_PATH);
			writer.write("");
			writer.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	public void write(Document document) {

		// write to a file
		OutputFormat format = OutputFormat.createPrettyPrint();
		XMLWriter writer = null;

		try {
			writer = new XMLWriter(new FileWriter("db/tmdb.xml"), format);
			// writer = new XMLWriter(new FileWriter("db/tmdb.xml"));
			writer.write(document);
			writer.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

	public int newtask(Task t) {
		int id = taskcount + 1;
		Element task = root.addElement("task");
		task.addAttribute("taskid", Integer.toString(id));

		Element taskname = task.addElement("taskname");
		if (t.taskName != null) {
			taskname.setText(t.taskName);
		} else {
			taskname.setText("");
		}

		Element taskcategory = task.addElement("taskcategory");
		if (t.taskCategory != null) {
			taskcategory.setText(t.taskCategory);
		} else {
			taskcategory.setText("");
		}

		Element priority = task.addElement("priority");
		if (t.priority != null) {
			priority.setText(Integer.toString(t.priority));
		} else {
			priority.setText("");
		}

		Element taskcreated = task.addElement("taskcreated");
		if (t.taskCreated != null) {
			DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yyyy HH:mm:ss");
			taskcreated.setText(t.taskCreated.toString(formatter));
		} else {
			taskcreated.setText("");
		}

		Element taskupdated = task.addElement("taskupdated");
		if (t.taskUpdated != null) {
			DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yyyy HH:mm:ss");
			taskupdated.setText(t.taskUpdated.toString(formatter));
		} else {
			taskupdated.setText("");
		}

		Element isdone = task.addElement("isdone");
		if (t.isDone != null) {
			isdone.setText(t.isDone.toString());
		} else {
			isdone.setText("");
		}

		Element isdeleted = task.addElement("isdeleted");
		if (t.isDeleted != null) {
			isdeleted.setText(t.isDeleted.toString());
		} else {
			isdeleted.setText("");
		}

		Element tasktype = task.addElement("tasktype");
		if (t.taskType != null) {
			tasktype.setText(t.taskType);
		} else {
			tasktype.setText("");
		}

		this.write(doc);

		taskcount = taskcount + 1;
		
		return id;
	}

	public Task readTask(int taskid) {
		
		String xtaskName = null;
		String xtaskCategory = null;
		Integer xpriority = null;
		DateTime xtaskCreated = null;
		DateTime xtaskUpdated = null;
		Boolean xisDone = null;
		Boolean xisDeleted = null;
		String xtaskType = null;
		
		
		String xpath = "/tasks/task[@taskid=" + Integer.toString(taskid) + "]";
		Element task = (Element) doc.selectSingleNode(xpath);
		
		int nodeindex = 0;
		for (Iterator i = task.elementIterator(); i.hasNext();) {
			Element childelement = (Element) i.next();
			nodeindex = nodeindex + 1;
			
			if (nodeindex == 1) {
				xtaskName = childelement.getText();
			} else if (nodeindex == 2) {
				xtaskCategory = childelement.getText();
			} else if (nodeindex == 3) {
				xpriority = Integer.parseInt(childelement.getText());
			} else if (nodeindex == 4) {
				DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yyyy HH:mm:ss");
				xtaskCreated = formatter.parseDateTime(childelement.getText());
			} else if (nodeindex == 5) {
				DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yyyy HH:mm:ss");
				xtaskUpdated = formatter.parseDateTime(childelement.getText());
			} else if (nodeindex == 6) {
				xisDone = Boolean.valueOf(childelement.getText());
			} else if (nodeindex == 7) {
				xisDeleted = Boolean.valueOf(childelement.getText());
			} else if (nodeindex == 8) {
				xtaskType = childelement.getText();
			}
		}
		
		Task t = new Task(taskid, xtaskName, xtaskCategory, xtaskCreated, xtaskUpdated, xisDone, xisDeleted, xpriority, xtaskType);
		return t;
	}
	
	public List<Task> readTasklist () { 
		List<Task> taskList = new ArrayList <Task>();
		
		// iterate through child elements of root
        for ( Iterator i = root.elementIterator(); i.hasNext(); ) {
            Element task = (Element) i.next();
            int taskid = Integer.parseInt(task.attributeValue("taskid"));
            taskList.add(this.readTask(taskid));
        }
        
        return taskList;
	}
	
	public Boolean editTask (int taskid, String name, String value) {
		String xpath = "/tasks/task[@taskid=" + Integer.toString(taskid) + "]/"+ name +"";
		Element taskproperty = (Element) doc.selectSingleNode(xpath);
		
		taskproperty.setText(value);
		
		this.clear();
		this.write(doc);
		
		return true;
	}
}
