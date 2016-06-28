package Client;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GoodsManagerUI {
	CollectionManager collectionCreator; // ����� ��� �������� ���������
	ServerPullPusher serverPullPusher; // ����� �� ������� ������ ��� �������

	String productName, groupsComboBoxText, productDescriptionTextAreaText,
			productComboBoxText, productManufacturerTextFieldText;
	double productPriceTextFieldText;
	int productNumberChTextFieldText;

	public JFrame frame; // �����
	JLabel groupNameLabel; // ������� "����� �����"
	JLabel productNameLabel; // ������� "����� ������"
	JLabel productDescriptionLabel; // ������� "���� ������"
	JLabel productNumberChLabel; // ������� "������� �������"
	JComboBox<?> groupsComboBox; // ���������� ������ �����
	JTextField productTextField; // ���� �������� ������ ������
	JTextField productDescriptionTextArea; // ��������� ����� �������� ������
	JTextField productNumberChTextField; // ��������� � ���������� ������
	JButton changesConfirmationButton; // ������ �������������� ���������
	JLabel productName2Label; // ������� "����� ������"
	JLabel productManufacturerLabel; // ������� "��������"
	JLabel productPriceLabel; // ������� "ֳ��"
	JComboBox<?> productComboBox; // ���������� ������ �������
	JTextField productManufacturerTextField; // ���� � ��������������
	JTextField productPriceTextField; // ���� � ����� ������
	JButton deleteButton; // ������� ��������

	GoodsManagerUI() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		frame = new JFrame("�����������/��������� ���� ������");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLayout(new GridBagLayout());

		componentsInitialization();// ��������� ����������
		componentsPlacing();// ��������� ����������

		frame.setSize(500, 150);
		// frame.pack();

		frame.setVisible(true);
	}

	private void componentsPlacing() {

		// ��� 1

		//������� "����� �����"
		frame.add(groupNameLabel, new GridBagConstraints(0, 0, 1, 1, 1, 1,
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
				new Insets(2, 2, 2, 2), 0, 0));

		//������� "����� ������"
		frame.add(productNameLabel, new GridBagConstraints(1, 0, 1, 1, 1, 1,
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
				new Insets(2, 2, 2, 2), 0, 0));

		//������� "���� ������"
		frame.add(productDescriptionLabel, new GridBagConstraints(2, 0, 1, 1,
				1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
				new Insets(2, 2, 2, 2), 0, 0));
		//������� "������� �������"
		frame.add(productNumberChLabel, new GridBagConstraints(3, 0, 1, 1, 1,
				1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
				new Insets(2, 2, 2, 2), 0, 0));

		// ��� 2

		//���������� ������ �����
		frame.add(groupsComboBox, new GridBagConstraints(0, 1, 1, 1, 1, 1,
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
				new Insets(2, 2, 2, 2), 0, 0));

		//���� �������� ������ ������
		frame.add(productTextField, new GridBagConstraints(1, 1, 1, 1, 1, 1,
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
				new Insets(2, 2, 2, 2), 0, 0));

		//��������� ����� �������� ������
		frame.add(productDescriptionTextArea, new GridBagConstraints(2, 1, 1,
				1, 1, 1, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));

		//��������� � ���������� ������
		frame.add(productNumberChTextField, new GridBagConstraints(3, 1, 1, 1,
				1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
				new Insets(2, 2, 2, 2), 0, 0));

		//������ �������������� ���������
		frame.add(changesConfirmationButton, new GridBagConstraints(4, 1, 1, 1,
				1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
				new Insets(2, 2, 2, 2), 0, 0));

		// ��� 3

		//������� "����� ������"
		frame.add(productName2Label, new GridBagConstraints(0, 2, 1, 1, 1, 1,
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
				new Insets(2, 2, 2, 2), 0, 0));

		//������� "��������"
		frame.add(productManufacturerLabel, new GridBagConstraints(1, 2, 1, 1,
				1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
				new Insets(2, 2, 2, 2), 0, 0));

		//������� "ֳ��"
		frame.add(productPriceLabel, new GridBagConstraints(2, 2, 1, 1, 1, 1,
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
				new Insets(2, 2, 2, 2), 0, 0));

		// ��� 4

		//���������� ������ �������
		frame.add(productComboBox, new GridBagConstraints(0, 3, 1, 1, 1, 1,
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
				new Insets(2, 2, 2, 2), 0, 0));

		//���� � ��������������
		frame.add(productManufacturerTextField, new GridBagConstraints(1, 3, 1,
				1, 1, 1, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));

		//���� � ����� ������
		frame.add(productPriceTextField, new GridBagConstraints(2, 3, 1, 1, 1,
				1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
				new Insets(2, 2, 2, 2), 0, 0));

		//������� ��������
		frame.add(deleteButton, new GridBagConstraints(4, 3, 1, 1, 1, 1,
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
				new Insets(2, 2, 2, 2), 0, 0));

	}

	private void componentsInitialization() {

		// ������� "����� �����"
		groupNameLabel = new JLabel("����� �����");

		// ������� "����� ������"
		productNameLabel = new JLabel("����� ������");

		// ������� "���� ������"
		productDescriptionLabel = new JLabel("���� ������");

		// ������� "������� �������"
		productNumberChLabel = new JLabel("������� �������");

		// ���������� ������ �����
		groupsComboBox = new JComboBox();

		// ���� �������� ������ ������
		productTextField = new JTextField();

		// ��������� ����� �������� ������
		productDescriptionTextArea = new JTextField();

		// ��������� � ���������� ������
		productNumberChTextField = new JTextField();

		// ������ �������������� ���������
		changesConfirmationButton = new JButton("����������");
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
				} else if (productName.equals("������ �������")) {
					serverPullPusher.pushString("eddProduct"); // �������� ��
																// ����� ���
																// �������
					// serverPullPusher.pushListOfGroups(collectionCreator
					// .createProductCollection(groupsComboBoxText,
					// productName,
					// productDescriptionTextAreaText,
					// productManufacturerTextFieldText,
					// productNumberChTextFieldText,
					// productPriceTextFieldText));
				} else {
					serverPullPusher.pushString("editGroup"); // �������� ��
																// ����� ���
																// ������� �
																// ��������� ���
																// ��� ������
																// ���������
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

		// ������� "����� ������"
		productName2Label = new JLabel("����� ������");

		// ������� "��������"
		productManufacturerLabel = new JLabel("��������");

		// ������� "ֳ��"
		productPriceLabel = new JLabel("ֳ��");

		// ���������� ������ �������
		productComboBox = new JComboBox();

		// ���� � ��������������
		productManufacturerTextField = new JTextField();

		// ���� � ����� ������
		productPriceTextField = new JTextField();

		// ������� ��������
		deleteButton = new JButton("��������");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				productName = (String) productComboBox.getSelectedItem();
				if (productName.equals("������ �������")) {
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
