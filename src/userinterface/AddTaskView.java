package userinterface;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JSpinner.DefaultEditor;
import javax.swing.JTextArea;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import storage.TaskList;

import com.standbysoft.component.date.swing.JDatePicker;

import controller.MainController;

public class AddTaskView implements ActionListener {

	private JTextArea taskNameField;
	private JTextArea taskCategoryField;
	private JTextArea startTimeField;
	private JTextArea endTimeField;
	private JTextArea priorityField;
	private Container pane;
	private JFrame startDatePanel;
	private JDatePicker startDatePicker;
	private JSpinner startTimePicker;
	private String startDateInput;
	private String startTimeInput;
	private JButton startTimeButton;
	private DateTime startDt;

	private JFrame endDatePanel;
	private JDatePicker endDatePicker;
	private JSpinner endTimePicker;
	private String endDateInput;
	private String endTimeInput;
	private JButton endTimeButton;
	private DateTime endDt;

	private JSpinner priorityPicker;

	private String taskName;
	private String taskCategory;
	private String taskPriority;

	public AddTaskView() {

		// creation of a new frame
		JFrame popUp = new JFrame();
		popUp.pack();
		popUp.setResizable(false);
		popUp.setSize(600, 400); // setting the size of the frame
		popUp.setTitle("Detailed task view"); // the title of the window
		pane = popUp.getContentPane();

		pane.setLayout(new GridLayout(0, 2)); // only two objects can be in each
		// row

		JLabel TaskNameLabel = new JLabel("Task Name"); // label
		// task
		// name
		pane.add(TaskNameLabel); // adding the label task name

		// create text areas
		taskNameField = new JTextArea("");
		pane.add(taskNameField); // adding the text area

		// creation of the label task category
		JLabel taskcategory = new JLabel("Task Category");
		pane.add(taskcategory); // adding the label

		// create text areas
		taskCategoryField = new JTextArea("");
		pane.add(taskCategoryField); // adding the text area

		// creation of the label task start-time
		JLabel startTime = new JLabel("Task Start Time");
		pane.add(startTime); // adding the label
		;
		DateTimeFormatter fmt = DateTimeFormat
				.forPattern("MMM d, yyyy HH:mm:ss");

		startTimeButton = new JButton("");
		pane.add(startTimeButton); // adding the button

		// add an action to the save button
		startTimeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				startDatePanel = new JFrame();
				Container startDatePane;

				startDatePanel.pack();
				startDatePanel.setResizable(false);
				startDatePanel.setSize(200, 100); // setting the size of the
				// frame
				startDatePanel.setTitle("Detailed task view"); // the title of
				// the
				startDatePane = startDatePanel.getContentPane();

				startDatePane.setLayout(new GridLayout(0, 2)); // only two
				// objects can
				// be in each
				// row
				// window

				startDatePicker = new JDatePicker(false);
				startDatePanel.add(startDatePicker);

				SpinnerModel model = new SpinnerDateModel();
				startTimePicker = new JSpinner(model);
				JComponent editor = new JSpinner.DateEditor(startTimePicker,
						"HH:mm:ss");
				startTimePicker.setEditor(editor);

				startDatePanel.add(startTimePicker);

				JButton startTimeSaveButton = new JButton("Save");
				startDatePanel.add(startTimeSaveButton); // adding the button
				startTimeSaveButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						startDateInput = startDatePicker
								.getSelectedDateAsText();
						System.out.println(startDateInput);

						try {
							startTimePicker.commitEdit();
						} catch (ParseException pe) {
							// Edited value is invalid, spinner.getValue() will
							// return
							// the last valid value, you could revert the
							// spinner to show that:
							JComponent editor = startTimePicker.getEditor();
							if (editor instanceof DefaultEditor) {
								((DefaultEditor) editor).getTextField()
										.setValue(startTimePicker.getValue());
							}
							// reset the value to some known value:
							// startTimePicker.setValue(fallbackValue);
							// or treat the last valid value as the current, in
							// which
							// case you don't need to do anything.
						}

						Date newDate = (Date) startTimePicker.getValue();
						newDate.getHours();
						startTimeInput = Integer.toString(newDate.getHours())
								+ ":" + Integer.toString(newDate.getMinutes())
								+ ":" + Integer.toString(newDate.getSeconds());
						System.out.println(startTimeInput);

						startTimeButton.setText(startDateInput + " "
								+ startTimeInput);
						DateTimeFormatter formatter = DateTimeFormat
								.forPattern("MMM d, yyyy HH:mm:ss");
						startDt = formatter.parseDateTime(startDateInput + " "
								+ startTimeInput);

						startDatePanel.setVisible(false);

					}
				});

				JButton cancelTimeSaveButton = new JButton("Cancel");
				startDatePanel.add(cancelTimeSaveButton); // adding the button
				cancelTimeSaveButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						startDatePanel.setVisible(false);
					}
				});

				startDatePanel.setVisible(true);

			}
		});

		// creation of the label task end-time
		JLabel endTime = new JLabel("Task End Time");
		pane.add(endTime); // adding the label

		endTimeButton = new JButton("");
		pane.add(endTimeButton); // adding the button

		// add an action to the save button
		endTimeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				endDatePanel = new JFrame();
				Container endDatePane;

				endDatePanel.pack();
				endDatePanel.setResizable(false);
				endDatePanel.setSize(200, 100); // setting the size of the frame
				endDatePanel.setTitle("Detailed task view"); // the title of the
				endDatePane = endDatePanel.getContentPane();

				endDatePane.setLayout(new GridLayout(0, 2)); // only two
				// objects can
				// be in each
				// row
				// window

				endDatePicker = new JDatePicker(false);
				endDatePanel.add(endDatePicker);

				SpinnerModel model = new SpinnerDateModel();
				endTimePicker = new JSpinner(model);
				JComponent editor = new JSpinner.DateEditor(endTimePicker,
						"HH:mm:ss");
				endTimePicker.setEditor(editor);

				endDatePanel.add(endTimePicker);

				JButton endTimeSaveButton = new JButton("Save");
				endDatePanel.add(endTimeSaveButton); // adding the button
				endTimeSaveButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						endDateInput = endDatePicker.getSelectedDateAsText();
						System.out.println(endDateInput);

						try {
							endTimePicker.commitEdit();
						} catch (ParseException pe) {
							// Edited value is invalid, spinner.getValue() will
							// return
							// the last valid value, you could revert the
							// spinner to show that:
							JComponent editor = endTimePicker.getEditor();
							if (editor instanceof DefaultEditor) {
								((DefaultEditor) editor).getTextField()
										.setValue(endTimePicker.getValue());
							}
							// reset the value to some known value:
							// startTimePicker.setValue(fallbackValue);
							// or treat the last valid value as the current, in
							// which
							// case you don't need to do anything.
						}

						Date newDate = (Date) endTimePicker.getValue();
						newDate.getHours();
						endTimeInput = Integer.toString(newDate.getHours())
								+ ":" + Integer.toString(newDate.getMinutes())
								+ ":" + Integer.toString(newDate.getSeconds());
						System.out.println(endTimeInput);

						endTimeButton
								.setText(endDateInput + " " + endTimeInput);

						DateTimeFormatter formatter = DateTimeFormat
								.forPattern("MMM d, yyyy HH:mm:ss");
						endDt = formatter.parseDateTime(endDateInput + " "
								+ endTimeInput);

						endDatePanel.setVisible(false);

					}
				});

				JButton cancelTimeSaveButton = new JButton("Cancel");
				endDatePanel.add(cancelTimeSaveButton); // adding the button
				cancelTimeSaveButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						endDatePanel.setVisible(false);
					}
				});

				endDatePanel.setVisible(true);

			}
		});

		// creation of the label task description
		JLabel priority = new JLabel("Priority");
		pane.add(priority); // adding the label

		SpinnerModel model = new SpinnerNumberModel();
		priorityPicker = new JSpinner(model);
		pane.add(priorityPicker);

		// create a button to save the task
		JButton saveButton = new JButton("Save");
		pane.add(saveButton); // adding the button

		// add an action to the save button
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				editTask();
				// MainController.getInstance().ReloadGui();

			}
		});

		// keep the window visible
		popUp.setVisible(true);

	}

	private void editTask() {

		TaskList newList = TaskList.getInstance();
		DateTime now = DateTime.now();
		newList.addTask(taskName, taskCategory, now, now, false, false,
				taskPriority, "", now, now, 0);
		System.out.println("New task added");
		MainController newController = MainController.getInstance();
		newController.ReloadGui();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}