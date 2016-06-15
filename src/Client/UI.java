package Client;

import java.awt.*;

import javax.swing.*;

public class UI {

	// компоненты интерфейса
	JFrame frame; // фрейм
	JButton groupsManagementButton; // кнопка открывает меню добавления/удаления
									// и редактирования групп
	JButton goodsManagementButton; // кнопка открывает меню поступления/списания
									// и редактирования товаров
	JButton statisticsWindowButton; // кнопка открывает меню статистики
	JTextField searchFormTextField; // форма поиска товаров
	JButton changesConfirmationButton; // кнопка подтверждающая изменения в
										// таблице
	JList<?> groupsList; // список групп товаров
	JLabel currentGroupLabel; // надпись отображает текущую выбраную группу
	JLabel totalLabel; // надпись "Загалом:" внизу формы
	JTable goodsOfGroupTable; // центральная таблица со списком товаров группы
	JTextField totalPriceTextField; // форма отображения суммарной цены товаров
									// группы
	JTextField totalQuantityTextField; // форма отображения суммарного
										// количества товаров группы

	UI() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		frame = new JFrame("Система управління складом");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridBagLayout());

		componentsInitialization();// описываем компоненты
		componentsPlacing();// размещаем компоненты
		
		
		frame.setSize(1000, 600);
		//frame.pack();
		frame.setVisible(true);
	}

	private void componentsPlacing() {

		// ряд 1

		// кнопка открывает меню добавления/удаления и редактирования групп
		frame.add(groupsManagementButton, new GridBagConstraints(0, 0, 1, 1, 1,
				1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
				new Insets(2, 2, 2, 2), 0, 0));

		// кнопка открывает меню поступления/списания и редактирования товаров
		frame.add(goodsManagementButton, new GridBagConstraints(1, 0, 1, 1, 1,
				1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
				new Insets(2, 2, 2, 2), 0, 0));

		// кнопка открывает меню статистики
		frame.add(statisticsWindowButton, new GridBagConstraints(2, 0, 1, 1, 1,
				1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
				new Insets(2, 2, 2, 2), 0, 0));

		// форма поиска товаров
		frame.add(searchFormTextField, new GridBagConstraints(3, 0, 2, 1, 1, 1,
				GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
				new Insets(5, 2, 2, 2), 0, 0));

		// ряд 2

		// надпись отображает текущую выбраную группу
		frame.add(currentGroupLabel, new GridBagConstraints(0, 1, 1, 4, 1, 1,
				GridBagConstraints.NORTH, GridBagConstraints.CENTER,
				new Insets(2, 2, 2, 2), 0, 0));

		// ряд 3

		// ???????

		// ряд 4

		// список групп товаров
		frame.add(groupsList, new GridBagConstraints(0, 4, 1, 11, 1, 1,
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
				new Insets(2, 2, 2, 2), 0, 0));

		// центральная таблица со списком товаров группы
		frame.add(goodsOfGroupTable, new GridBagConstraints(1, 4, 10, 1, 1, 1,
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
				new Insets(2, 2, 2, 2), 0, 0));

		// ряд 5

		// надпись "Загалом:" внизу формы
		frame.add(totalLabel, new GridBagConstraints(1, 5, 1, 1, 1, 1,
				GridBagConstraints.SOUTH, GridBagConstraints.HORIZONTAL,
				new Insets(2, 2, 8, 2), 0, 0));

		// форма отображения суммарного количества товаров группы
		frame.add(totalQuantityTextField, new GridBagConstraints(2, 5, 1, 1, 1,
				1, GridBagConstraints.SOUTH, GridBagConstraints.HORIZONTAL,
				new Insets(2, 2, 8, 2), 0, 0));

		// форма отображения суммарной цены товаров группы
		frame.add(totalPriceTextField, new GridBagConstraints(3, 5, 1, 1, 1, 1,
				GridBagConstraints.SOUTH, GridBagConstraints.HORIZONTAL,
				new Insets(2, 2, 8, 2), 0, 0));
		// кнопка подтверждающая изменения в таблице
		frame.add(changesConfirmationButton, new GridBagConstraints(4, 5, 1, 1,
				1, 1, GridBagConstraints.SOUTH, GridBagConstraints.HORIZONTAL,
				new Insets(2, 2, 5, 2), 0, 0));

	}

	private void componentsInitialization() {

		// кнопка открывает меню добавления/удаления и редактирования групп
		groupsManagementButton = new JButton("Редагування групп");

		// кнопка открывает меню поступления/списания и редактирования товаров
		goodsManagementButton = new JButton("Додати/списати товар");

		// кнопка открывает меню статистики
		statisticsWindowButton = new JButton("Статистика");

		// форма поиска товаров
		searchFormTextField = new JTextField();
		searchFormTextField.setText("пошук товарів");

		// надпись отображает текущую выбраную группу
		currentGroupLabel = new JLabel("ВСТАВИТЬ НАЗВАНИЕ ТЕКУЩЕЙ ГРУППЫ ТОВАРОВ");
		
		// список групп товаров
		groupsList = new JList();

		// центральная таблица со списком товаров группы
		goodsOfGroupTable = new JTable();

		// надпись "Загалом:" внизу формы
		totalLabel = new JLabel("Загалом: ");

		// форма отображения суммарного количества товаров группы
		totalQuantityTextField = new JTextField();
		totalQuantityTextField.setText("КОЛИЧЕСТВО ТОВАРОВ");

		// форма отображения суммарной цены товаров группы
		totalPriceTextField = new JTextField();
		totalPriceTextField.setText("ЦЕНА ТОВАРОВ");

		// кнопка подтверждающая изменения в таблице
		changesConfirmationButton = new JButton("Підтвердити");

	}

	public static void main(String[] args) {
		UI ui = new UI();
	}
}
