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
	CollectionManager collectionManager; // ����� ��� �������� ���������
											// ���������
	ServerPullPusher serverPullPusher; // ����� �� ������� ������ ��� �������

	String groupName, groupDescription;
	public JFrame frame; // �����
	JLabel groupNameLabel; // ������� "����� �����"
	JLabel groupDescriptionLabel; // ������� "���� �����"
	JComboBox<?> groupsComboBox; // ���������� ������ �����
	JTextField groupTextField; // ���� �������� ����� ������
	JTextField groupDescriptionTextArea; // ��������� ����� �������� ������
	JButton changesConfirmationButton; // ������ �������������� ���������
	JButton deleteButton; // ������� ��������

	GroupsManagerUI() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		frame = new JFrame("�����������/��������� ���� ������");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLayout(new GridBagLayout());

		componentsInitialization();// ��������� ����������
		componentsPlacing();// ��������� ����������

		frame.setSize(400, 120);
		// frame.pack();

		frame.setVisible(true);

	}

	public void windowClosing(WindowEvent e) {// ����� ������ ��� ��������?
		windowClosing(e);
		serverPullPusher.pushString("exit");
	}

	private void componentsPlacing() {

		// ��� 1

		// ������� "����� �����"
		frame.add(groupNameLabel, new GridBagConstraints(0, 0, 1, 1, 1, 1,
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
				new Insets(2, 2, 2, 2), 0, 0));

		// ������� "���� �����"
		frame.add(groupDescriptionLabel, new GridBagConstraints(1, 0, 1, 1, 1,
				1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
				new Insets(2, 2, 2, 2), 0, 0));

		// ��� 2

		// ���������� ������ �����
		frame.add(groupsComboBox, new GridBagConstraints(0, 1, 1, 1, 1, 1,
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
				new Insets(2, 2, 2, 2), 0, 0));

		// ��������� ����� �������� ������
		frame.add(groupDescriptionTextArea, new GridBagConstraints(1, 1, 1, 1,
				1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
				new Insets(2, 2, 2, 2), 0, 0));

		// ������ �������������� ���������
		frame.add(changesConfirmationButton, new GridBagConstraints(2, 1, 1, 1,
				1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
				new Insets(2, 2, 2, 2), 0, 0));

		// ��� 3

		// ���� �������� ����� ������
		frame.add(groupTextField, new GridBagConstraints(0, 2, 1, 1, 1, 1,
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
				new Insets(2, 2, 2, 2), 0, 0));

		// ������� ��������
		frame.add(deleteButton, new GridBagConstraints(2, 2, 1, 1, 1, 1,
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
				new Insets(2, 2, 2, 2), 0, 0));

	}

	private void componentsInitialization() {

		// ������� "����� �����"
		groupNameLabel = new JLabel("����� �����");

		// ������� "���� �����"
		groupDescriptionLabel = new JLabel("���� �����");

		// ���������� ������ �����
		serverPullPusher.pushString("getGroupList");
		dataBaseBank.setGroupList();
		String[] items = collectionManager.arrayOfGroupsInGropCollection();
		String[] itemsAndAdd = new String[items.length+1];
		for (int i=1; i<=items.length; i++){
			itemsAndAdd[i] = items[i-1];
		}
		itemsAndAdd[0]= "�������� �����";
		groupsComboBox = new JComboBox(items);
		groupsComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((String) groupsComboBox.getSelectedItem() != "�������� �����") {
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

		// ���� �������� ����� ������
		groupTextField = new JTextField();

		// ��������� ����� �������� ������
		groupDescriptionTextArea = new JTextField();

		// ������ �������������� ���������
		changesConfirmationButton = new JButton("ϳ���������");
		changesConfirmationButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				groupName = (String) groupsComboBox.getSelectedItem();
				groupDescription = groupDescriptionTextArea.getText();
				if (groupName.equals("") || groupDescription.equals("")) {
					new FailureWindowUI();
				}
				else if (groupName.equals("�������� �����")) {
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

		// ������� ��������
		deleteButton = new JButton("�������� �����");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				groupName = (String) groupsComboBox.getSelectedItem();
				if (groupName.equals("�������� �����")) {
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
//				// ���� ������� ������ ��������
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
//				// ���� ������� ������ ��������������
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
//					groupDescriptionTextArea.setText("�������");
//				}
//			}
//		};
	}

	public static void main(String[] args) {
		new GroupsManagerUI();
	}
}
