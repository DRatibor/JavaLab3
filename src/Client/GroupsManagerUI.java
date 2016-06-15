package Client;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.*;

public class GroupsManagerUI {
	JFrame frame; // фрейм
	JLabel groupNameLabel; // надпись "Назва групи"
	JLabel groupDescriptionLabel; // надпись "Опис групи"
	JComboBox<Object> groupsComboBox; // выпадающий список групп
	JTextField groupTextField; // поле название новой группы
	JTextArea groupDescriptionTextArea; // текстовая форма описания группы
	JButton changesConfirmationButton; // кнопка подтверждающая изменения
	JButton deleteButton; // конопка удаления

	GroupsManagerUI() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		frame = new JFrame("Редагування груп товарів");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridBagLayout());

		componentsInitialization();// описываем компоненты
		componentsPlacing();// размещаем компоненты

		frame.setSize(300, 100);
		//frame.pack();
		frame.setVisible(true);
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
		frame.add(groupDescriptionTextArea, new GridBagConstraints(1, 1, 1, 2,
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
		groupsComboBox = new JComboBox<Object>();

		// поле название новой группы
		groupTextField = new JTextField();

		// текстовая форма описания группы
		groupDescriptionTextArea = new JTextArea();

		// кнопка подтверждающая изменения
		changesConfirmationButton = new JButton("Підтвердити");

		// конопка удаления
		deleteButton = new JButton("Видалити групу");
		;

	}

	public static void main(String[] args) {
		GroupsManagerUI ui = new GroupsManagerUI();
	}
}
