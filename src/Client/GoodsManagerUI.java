package Client;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GoodsManagerUI {
	CollectionManager collectionCreator; // класс для создания коллекций
	ServerPullPusher serverPullPusher; // класс со списком команд для сервера

	String productName, groupsComboBoxText, productDescriptionTextAreaText,
			productComboBoxText, productManufacturerTextFieldText;
	double productPriceTextFieldText;
	int productNumberChTextFieldText;

	public JFrame frame; // фрейм
	JLabel groupNameLabel; // надпись "Назва групи"
	JLabel productNameLabel; // надпись "Назва товару"
	JLabel productDescriptionLabel; // надпись "Опис товару"
	JLabel productNumberChLabel; // надпись "Одиниць надійшло"
	JComboBox<?> groupsComboBox; // выпадающий список групп
	JTextField productTextField; // поле название нового товара
	JTextField productDescriptionTextArea; // текстовая форма описания товара
	JTextField productNumberChTextField; // изменение в количестве товара
	JButton changesConfirmationButton; // кнопка подтверждающая изменения
	JLabel productName2Label; // надпись "Назва товару"
	JLabel productManufacturerLabel; // надпись "Виробник"
	JLabel productPriceLabel; // надпись "Ціна"
	JComboBox<?> productComboBox; // выпадающий список товаров
	JTextField productManufacturerTextField; // поле с производителем
	JTextField productPriceTextField; // поле с ценой товара
	JButton deleteButton; // конопка удаления

	GoodsManagerUI() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		frame = new JFrame("Редагування/додавання груп товарів");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLayout(new GridBagLayout());

		componentsInitialization();// описываем компоненты
		componentsPlacing();// размещаем компоненты

		frame.setSize(500, 150);
		// frame.pack();

		frame.setVisible(true);
	}

	private void componentsPlacing() {

		// ряд 1

		//надпись "Назва групи"
		frame.add(groupNameLabel, new GridBagConstraints(0, 0, 1, 1, 1, 1,
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
				new Insets(2, 2, 2, 2), 0, 0));

		//надпись "Назва товару"
		frame.add(productNameLabel, new GridBagConstraints(1, 0, 1, 1, 1, 1,
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
				new Insets(2, 2, 2, 2), 0, 0));

		//надпись "Опис товару"
		frame.add(productDescriptionLabel, new GridBagConstraints(2, 0, 1, 1,
				1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
				new Insets(2, 2, 2, 2), 0, 0));
		//надпись "Одиниць надійшло"
		frame.add(productNumberChLabel, new GridBagConstraints(3, 0, 1, 1, 1,
				1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
				new Insets(2, 2, 2, 2), 0, 0));

		// ряд 2

		//выпадающий список групп
		frame.add(groupsComboBox, new GridBagConstraints(0, 1, 1, 1, 1, 1,
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
				new Insets(2, 2, 2, 2), 0, 0));

		//поле название нового товара
		frame.add(productTextField, new GridBagConstraints(1, 1, 1, 1, 1, 1,
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
				new Insets(2, 2, 2, 2), 0, 0));

		//текстовая форма описания товара
		frame.add(productDescriptionTextArea, new GridBagConstraints(2, 1, 1,
				1, 1, 1, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));

		//изменение в количестве товара
		frame.add(productNumberChTextField, new GridBagConstraints(3, 1, 1, 1,
				1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
				new Insets(2, 2, 2, 2), 0, 0));

		//кнопка подтверждающая изменения
		frame.add(changesConfirmationButton, new GridBagConstraints(4, 1, 1, 1,
				1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
				new Insets(2, 2, 2, 2), 0, 0));

		// ряд 3

		//надпись "Назва товару"
		frame.add(productName2Label, new GridBagConstraints(0, 2, 1, 1, 1, 1,
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
				new Insets(2, 2, 2, 2), 0, 0));

		//надпись "Виробник"
		frame.add(productManufacturerLabel, new GridBagConstraints(1, 2, 1, 1,
				1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
				new Insets(2, 2, 2, 2), 0, 0));

		//надпись "Ціна"
		frame.add(productPriceLabel, new GridBagConstraints(2, 2, 1, 1, 1, 1,
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
				new Insets(2, 2, 2, 2), 0, 0));

		// ряд 4

		//выпадающий список товаров
		frame.add(productComboBox, new GridBagConstraints(0, 3, 1, 1, 1, 1,
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
				new Insets(2, 2, 2, 2), 0, 0));

		//поле с производителем
		frame.add(productManufacturerTextField, new GridBagConstraints(1, 3, 1,
				1, 1, 1, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));

		//поле с ценой товара
		frame.add(productPriceTextField, new GridBagConstraints(2, 3, 1, 1, 1,
				1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
				new Insets(2, 2, 2, 2), 0, 0));

		//конопка удаления
		frame.add(deleteButton, new GridBagConstraints(4, 3, 1, 1, 1, 1,
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
				new Insets(2, 2, 2, 2), 0, 0));

	}

	private void componentsInitialization() {

		// надпись "Назва групи"
		groupNameLabel = new JLabel("Назва групи");

		// надпись "Назва товару"
		productNameLabel = new JLabel("Назва товару");

		// надпись "Опис товару"
		productDescriptionLabel = new JLabel("Опис товару");

		// надпись "Одиниць надійшло"
		productNumberChLabel = new JLabel("Одиниць надійшло");

		// выпадающий список групп
		groupsComboBox = new JComboBox();

		// поле название нового товара
		productTextField = new JTextField();

		// текстовая форма описания товара
		productDescriptionTextArea = new JTextField();

		// изменение в количестве товара
		productNumberChTextField = new JTextField();

		// кнопка подтверждающая изменения
		changesConfirmationButton = new JButton("Редагувати");
		changesConfirmationButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				productName = (String) productComboBox.getSelectedItem();
				groupsComboBoxText = (String) groupsComboBox.getSelectedItem();
				productDescriptionTextAreaText = productDescriptionTextArea
						.getText();
				productNumberChTextFieldText = Integer
						.parseInt(productNumberChTextField.getText());
				productComboBoxText = (String) productComboBox
						.getSelectedItem();
				productManufacturerTextFieldText = productManufacturerTextField
						.getText();
				productPriceTextFieldText = Double
						.parseDouble(productPriceTextField.getText());

				if (productName.equals("")) {
					new FailureWindowUI();
				} else if (productName.equals("Додати продукт")) {
					serverPullPusher.pushString("eddProduct"); // заменить на
																// метод для
																// товаров
					// serverPullPusher.pushListOfGroups(collectionCreator
					// .createProductCollection(groupsComboBoxText,
					// productName,
					// productDescriptionTextAreaText,
					// productManufacturerTextFieldText,
					// productNumberChTextFieldText,
					// productPriceTextFieldText));
				} else {
					serverPullPusher.pushString("editGroup"); // заменить на
																// метод для
																// товаров и
																// учитывать что
																// тут дельта
																// продукции
					// serverPullPusher.pushListOfGroups(collectionCreator
					// .createProductCollection(groupsComboBoxText,
					// productName,
					// productDescriptionTextAreaText,
					// productManufacturerTextFieldText,
					// productNumberChTextFieldText,
					// productPriceTextFieldText));
					productName = null;
					groupsComboBoxText = null;
					productDescriptionTextAreaText = null;
					productNumberChTextFieldText = 0;
					productComboBoxText = null;
					productManufacturerTextFieldText = null;
					productPriceTextFieldText = 0;
				}
			}
		});

		// надпись "Назва товару"
		productName2Label = new JLabel("Назва товару");

		// надпись "Виробник"
		productManufacturerLabel = new JLabel("Виробник");

		// надпись "Ціна"
		productPriceLabel = new JLabel("Ціна");

		// выпадающий список товаров
		productComboBox = new JComboBox();

		// поле с производителем
		productManufacturerTextField = new JTextField();

		// поле с ценой товара
		productPriceTextField = new JTextField();

		// конопка удаления
		deleteButton = new JButton("Видалити");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				productName = (String) productComboBox.getSelectedItem();
				if (productName.equals("Додати продукт")) {
					new FailureWindowUI();
				} else {
					serverPullPusher.pushString("delGroup");
					serverPullPusher.pushString(productName);
					productName = null;
				}
			}
		});
	}

	public static void main(String[] args) {
		new GoodsManagerUI();
	}
}
