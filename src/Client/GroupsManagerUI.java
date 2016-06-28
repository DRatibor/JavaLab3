package Client;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.*;

public class GroupsManagerUI {
	
	
	DataBaseBank dataBaseBank;
	CollectionManager collectionManager; // класс для создания коллекций
											// продуктов
	ServerPullPusher serverPullPusher; // класс со списком команд для сервера

	String groupName, groupDescription;
	public JFrame frame; // фрейм
	JLabel groupNameLabel; // надпись "Назва групи"
	JLabel groupDescriptionLabel; // надпись "Опис групи"
	JComboBox<?> groupsComboBox; // выпадающий список групп
	JTextField groupTextField; // поле название новой группы
	JTextField groupDescriptionTextArea; // текстовая форма описания группы
	JButton changesConfirmationButton; // кнопка подтверждающая изменения
	JButton deleteButton; // конопка удаления

	GroupsManagerUI() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		frame = new JFrame("Редагування/додавання груп товарів");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLayout(new GridBagLayout());

		componentsInitialization();// описываем компоненты
		componentsPlacing();// размещаем компоненты

		frame.setSize(400, 120);
		// frame.pack();

		frame.setVisible(true);

	}

	public void windowClosing(WindowEvent e) {// будет просто так работать?
		windowClosing(e);
		serverPullPusher.pushString("exit");
	}

	private void componentsPlacing() {

		// ряд 1

		// надпись "Назва групи"
		frame.add(groupNameLabel, new GridBagConstraints(0, 0, 1, 1, 1, 1,
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
				new Insets(2, 2, 2, 2), 0, 0));

		// надпись "Опис групи"
		frame.add(groupDescriptionLabel, new GridBagConstraints(1, 0, 1, 1, 1,
				1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
				new Insets(2, 2, 2, 2), 0, 0));

		// ряд 2

		// выпадающий список групп
		frame.add(groupsComboBox, new GridBagConstraints(0, 1, 1, 1, 1, 1,
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
				new Insets(2, 2, 2, 2), 0, 0));

		// текстовая форма описания группы
		frame.add(groupDescriptionTextArea, new GridBagConstraints(1, 1, 1, 1,
				1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
				new Insets(2, 2, 2, 2), 0, 0));

		// кнопка подтверждающая изменения
		frame.add(changesConfirmationButton, new GridBagConstraints(2, 1, 1, 1,
				1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
				new Insets(2, 2, 2, 2), 0, 0));

		// ряд 3

		// поле название новой группы
		frame.add(groupTextField, new GridBagConstraints(0, 2, 1, 1, 1, 1,
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
				new Insets(2, 2, 2, 2), 0, 0));

		// конопка удаления
		frame.add(deleteButton, new GridBagConstraints(2, 2, 1, 1, 1, 1,
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
				new Insets(2, 2, 2, 2), 0, 0));

	}

	private void componentsInitialization() {

		// надпись "Назва групи"
		groupNameLabel = new JLabel("Назва групи");

		// надпись "Опис групи"
		groupDescriptionLabel = new JLabel("Опис групи");

		// выпадающий список групп
		serverPullPusher.pushString("getGroupList");
		dataBaseBank.setGroupList();
		String[] items = collectionManager.arrayOfGroupsInGropCollection();
		String[] itemsAndAdd = new String[items.length+1];
		for (int i=1; i<=items.length; i++){
			itemsAndAdd[i] = items[i-1];
		}
		itemsAndAdd[0]= "Створити групу";
		groupsComboBox = new JComboBox(items);
		groupsComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((String) groupsComboBox.getSelectedItem() != "Створити групу") {
					groupTextField.setText((String) groupsComboBox
							.getSelectedItem());
					groupDescriptionTextArea.setText(collectionManager.groupDiscription((String) groupsComboBox
							.getSelectedItem()));
					groupTextField.setEditable(false);
					
				} else {
					groupTextField.setEditable(true);
					groupTextField.setText("");
					groupDescriptionTextArea.setText("");
				}
			}
		});

		// поле название новой группы
		groupTextField = new JTextField();

		// текстовая форма описания группы
		groupDescriptionTextArea = new JTextField();

		// кнопка подтверждающая изменения
		changesConfirmationButton = new JButton("Підтвердити");
		changesConfirmationButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				groupName = (String) groupsComboBox.getSelectedItem();
				groupDescription = groupDescriptionTextArea.getText();
				if (groupName.equals("") || groupDescription.equals("")) {
					new FailureWindowUI();
				}
				else if (groupName.equals("Створити групу")) {
					serverPullPusher.pushString("eddGroup");
					serverPullPusher.pushListOfGroups(collectionManager
							.createGroupCollection(groupTextField.getText(),
							groupDescription));
				}else {
					serverPullPusher.pushString("editGroup");
					 serverPullPusher.pushListOfGroups(collectionManager
					 .createGroupCollection(groupName,
					 groupDescription));
					groupName = null;
					groupDescription = null;
				}
			}
		});

		// конопка удаления
		deleteButton = new JButton("Видалити групу");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				groupName = (String) groupsComboBox.getSelectedItem();
				if (groupName.equals("Створити групу")) {
					new FailureWindowUI();
				} else {
					serverPullPusher.pushString("delGroup");
					serverPullPusher.pushString(groupName);
					groupName = null;
				}
			}
		});

//		ActionListener actionListener = new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//
//				// если выбрали кнопку удаления
//				if (e.getSource() == deleteButton) {
//					groupName = (String) groupsComboBox.getSelectedItem();
//					if (groupName != null) {
//						serverPullPusher.pushString("delGroup");
//						serverPullPusher.pushString(groupName);
//						groupName = null;
//					} else
//						new FailureWindowUI();
//				}
//
//				// если выбрали кнопку редактирования
//				else if (e.getSource() == changesConfirmationButton) {
//					groupName = (String) groupsComboBox.getSelectedItem();
//					groupDescription = groupDescriptionTextArea.getText();
//					if (groupName != null && groupDescription != null) {
//						serverPullPusher.pushString("editGroup");
//						// serverPullPusher.pushListOfGroups(collectionCreator
//						// .createGroupCollection(groupName,
//						// groupDescription));
//						groupName = null;
//						groupDescription = null;
//					} else
//						new FailureWindowUI();
//				} else if (e.getSource() == groupsComboBox) {
//					groupDescriptionTextArea.setText("ААААААА");
//				}
//			}
//		};
	}

	public static void main(String[] args) {
		new GroupsManagerUI();
	}
}
