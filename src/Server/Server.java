package Server;

import java.io.*;
import java.net.*;

public class Server extends Thread {

	public static final int PORT = 8001; // ���� �����������
	private ClientPullPusher clientPullPusher;
	private DataBaseCreator dataBaseCreator;
	static DataInputStream is; // �������� �����
	static DataOutputStream os; // ��������� �����
	ServerSocket serverSocet; // ����� �������
	Socket socket; // �����
	private String login = "login";
	private String pass = "pass";
	char[] entPass;
	ClientPullPusher spp;

	public Server() {
		start();
	}

	public void run() {
		//spp = new ClientPullPusher(socket);
		dataBaseCreator = new DataBaseCreator();
		dataBaseCreator.createDateBase("Product.db");
		try {
			serverSocet = new ServerSocket(PORT);
			System.out.println("��������� ������");
			while (true) {
				socket = serverSocet.accept();
				System.out.println("���������� ����� " + socket);
//				spp = new ClientPullPusher(socket);
				new ClientConnection(socket, dataBaseCreator);
//				initPassword();				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

//	private void initPassword() { // ��������� ������
//		if (spp.pullString().equals(login)) {
//			for (int i = 0; spp.pullChar() != null; i++) {
//				entPass += spp.pullChar();
//			}
//			if (pass.equals(entPass.toString()))
//				spp.pushBoolean(true);
//			new DataBaseManager(clientPullPusher, dataBaseCreator);
//		} else
//			spp.pushBoolean(false);
//	}

}
