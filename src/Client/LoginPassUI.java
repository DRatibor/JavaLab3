package Client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.Socket;
import java.util.Arrays;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class LoginPassUI extends JFrame {

	private Socket socket;
	private JLabel mainLabel;
	private JLabel loginLabel;
	private JTextField login;
	private JLabel passLabel;
	private JPasswordField pass;
	private JButton okButton;
	private ServerPullPusher spp;

	public LoginPassUI(Socket socket) {
		super();
		this.socket = socket;
		spp = new ServerPullPusher(socket);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("�����������");
		init();
		Box mainLabelBox = Box.createHorizontalBox();// ����� � ��������� ���� �
														// ���������
		mainLabelBox.add(mainLabel);
		Box box1 = Box.createHorizontalBox();// ����� � ��������� ���� �
												// ���������
		box1.add(loginLabel);
		box1.add(Box.createHorizontalStrut(6));
		box1.add(login);
		Box box2 = Box.createHorizontalBox();
		box2.add(passLabel);
		box2.add(Box.createHorizontalStrut(6));
		box2.add(pass);
		Box box3 = Box.createHorizontalBox();
		box3.add(Box.createHorizontalGlue());
		box3.add(okButton);
		Box mainBox = Box.createVerticalBox();// ������ ��� � ��������� �������
		mainBox.setBorder(new EmptyBorder(12, 12, 12, 12));
		mainBox.add(mainLabel);
		mainBox.add(Box.createVerticalStrut(12));
		mainBox.add(box1);
		mainBox.add(Box.createVerticalStrut(12));
		mainBox.add(box2);
		mainBox.add(Box.createVerticalStrut(17));
		mainBox.add(box3);
		setContentPane(mainBox);
		pack();
		setVisible(true);
		confirmation();
		setResizable(false);// �������� ������ ������ ����
		// this.add(mainLabel);
		// this.add(loginLabel);
		// this.add(login);
		// this.add(passLabel);
		// this.add(pass);
		// this.add(okButton);
	}

	public String getLogin() {
		return this.login.getText();
	}

	public char[] getPass() {
		return this.pass.getPassword();
	}

	public Boolean confirmation() {
		okButton.addActionListener(new ClickLisner());
		spp.pushString("EntryConfirmation");
		spp.pushString(login.getText());
		for (int i = 0; i < pass.getPassword().length; i++) {
			spp.pushChar(pass.getPassword()[i]);
		}
		if (spp.pullBoolean() == true) {
			return true;
		}
		return false;
	}

	private void init() {
		if (mainLabel == null) {
			mainLabel = new JLabel();
			mainLabel.setText("������ ��� ���� � ������:");
		}
		if (loginLabel == null) {
			loginLabel = new JLabel();
			loginLabel.setText("����:");
		}
		if (login == null) {
			login = new JTextField(20);

		}
		if (passLabel == null) {
			passLabel = new JLabel();
			passLabel.setText("������:");
		}
		if (pass == null) {
			pass = new JPasswordField(20);
		}
		if (okButton == null) {
			okButton = new JButton();
			okButton.setText("ϳ���������");
		}
	}

	class ClickLisner implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (confirmation() == true) {
				new MainUI();
				setVisible(false);
			} else
				new FailureWindowUI();
		}
	}
}
