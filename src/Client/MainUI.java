package Client;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class MainUI {

	// ���������� ����������
	ServerPullPusher serverPullPusher;
	String searchText;
	public Boolean visible = true;
	JFrame frame; // �����
	JButton groupsManagementButton; // ������ ��������� ���� ����������/��������
									// � �������������� �����
	JButton goodsManagementButton; // ������ ��������� ���� �����������/��������
									// � �������������� �������
	JButton statisticsWindowButton; // ������ ��������� ���� ����������
	JTextField searchFormTextField; // ����� ������ �������
	JButton changesConfirmationButton; // ������ �������������� ��������� �
										// �������
	JList<?> groupsList; // ������ ����� �������
	JLabel currentGroupLabel; // ������� ���������� ������� �������� ������
	JLabel totalLabel; // ������� "�������:" ����� �����
	JTable goodsOfGroupTable; // ����������� ������� �� ������� ������� ������
	JTextField totalPriceTextField; // ����� ����������� ��������� ���� �������
									// ������
	JTextField totalQuantityTextField; // ����� ����������� ����������
										// ���������� ������� ������

	MainUI() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		frame = new JFrame("������� ��������� �������");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridBagLayout());

		componentsInitialization();// ��������� ����������
		componentsPlacing();// ��������� ����������

		frame.setSize(1000, 600);
		// frame.pack();
		frame.setVisible(visible);
	}

	private void componentsPlacing() {

		// ��� 1

		// ������ ��������� ���� ����������/�������� � �������������� �����
		frame.add(groupsManagementButton, new GridBagConstraints(0, 0, 1, 1, 1,
				1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
				new Insets(2, 2, 2, 2), 0, 0));

		// ������ ��������� ���� �����������/�������� � �������������� �������
		frame.add(goodsManagementButton, new GridBagConstraints(1, 0, 1, 1, 1,
				1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
				new Insets(2, 2, 2, 2), 0, 0));

		// ������ ��������� ���� ����������
		frame.add(statisticsWindowButton, new GridBagConstraints(2, 0, 1, 1, 1,
				1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
				new Insets(2, 2, 2, 2), 0, 0));

		// ����� ������ �������
		frame.add(searchFormTextField, new GridBagConstraints(3, 0, 1, 1, 1, 1,
				GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
				new Insets(5, 2, 2, 2), 0, 0));
		// ������ �������������� ��������� � �������
		frame.add(changesConfirmationButton, new GridBagConstraints(4, 0, 1, 1,
				1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
				new Insets(2, 2, 5, 2), 0, 0));

		// ��� 2

		// ������� ���������� ������� �������� ������
		frame.add(currentGroupLabel, new GridBagConstraints(0, 1, 1, 4, 1, 1,
				GridBagConstraints.NORTH, GridBagConstraints.CENTER,
				new Insets(2, 2, 2, 2), 0, 0));

		// ��� 3

		// ???????

		// ��� 4

		// ������ ����� �������
		frame.add(groupsList, new GridBagConstraints(0, 4, 1, 11, 1, 1,
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
				new Insets(2, 2, 2, 2), 0, 0));

		// ����������� ������� �� ������� ������� ������
		frame.add(goodsOfGroupTable, new GridBagConstraints(1, 4, 10, 1, 1, 1,
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
				new Insets(2, 2, 2, 2), 0, 0));

		// ��� 5

		// ������� "�������:" ����� �����
		frame.add(totalLabel, new GridBagConstraints(1, 5, 1, 1, 1, 1,
				GridBagConstraints.SOUTH, GridBagConstraints.HORIZONTAL,
				new Insets(2, 2, 8, 2), 0, 0));

		// ����� ����������� ���������� ���������� ������� ������
		frame.add(totalQuantityTextField, new GridBagConstraints(2, 5, 1, 1, 1,
				1, GridBagConstraints.SOUTH, GridBagConstraints.HORIZONTAL,
				new Insets(2, 2, 8, 2), 0, 0));

		// ����� ����������� ��������� ���� ������� ������
		frame.add(totalPriceTextField, new GridBagConstraints(3, 5, 1, 1, 1, 1,
				GridBagConstraints.SOUTH, GridBagConstraints.HORIZONTAL,
				new Insets(2, 2, 8, 2), 0, 0));

	}

	private void componentsInitialization() {

		// ������ ��������� ���� ����������/�������� � �������������� �����
		groupsManagementButton = new JButton("����������� �����");
		groupsManagementButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GroupsManagerUI();
			}
		});

		// ������ ��������� ���� �����������/�������� � �������������� �������
		goodsManagementButton = new JButton("������/������� �����");
		goodsManagementButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GoodsManagerUI();
			}
		});
		// ������ ��������� ���� ����������
		statisticsWindowButton = new JButton("����������");

		// ����� ������ �������
		searchFormTextField = new JTextField();
		searchFormTextField.setText("����� ������");

		// ������� ���������� ������� �������� ������
		currentGroupLabel = new JLabel(
				"�������� �������� ������� ������ �������");

		// ������ ����� �������
		groupsList = new JList();
		groupsList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				goodsOfGroupTable.removeAll();
			}
		});

		// ����������� ������� �� ������� ������� ������
		goodsOfGroupTable = new JTable();

		// ������� "�������:" ����� �����
		totalLabel = new JLabel("�������: ");

		// ����� ����������� ���������� ���������� ������� ������
		totalQuantityTextField = new JTextField();
		totalQuantityTextField.setText("���������� �������");

		// ����� ����������� ��������� ���� ������� ������
		totalPriceTextField = new JTextField();
		totalPriceTextField.setText("���� �������");

		// ������ �������������� ��������� � �������
		changesConfirmationButton = new JButton("�����");
		changesConfirmationButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (searchText.equals("")) {
					new FailureWindowUI();
				} else {
					serverPullPusher.pushString("search");
					serverPullPusher.pushString(searchText);
					searchText = null;
				}
			}
		});
	}

	ActionListener actionListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {

			// �����
			if (e.getSource() == changesConfirmationButton) {
				searchText = searchFormTextField.getText();// ����������
															// �����????
				if (searchText != null) {
					serverPullPusher.pushString("search");
					serverPullPusher.pushString(searchText);
					searchText = null;
				} else
					new FailureWindowUI();
			}
		}
	};

	public static void main(String[] args) {
		new MainUI();
	}
}
