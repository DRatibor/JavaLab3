package Server;

import java.io.*;
import java.net.*;

public class Server extends Thread {

	public static final int PORT = 8001; // порт подключения
	private ClientPullPusher clientPullPusher;
	private DataBaseCreator dataBaseCreator;
	static DataInputStream is; // входящий поток
	static DataOutputStream os; // исходящий поток
	ServerSocket serverSocet; // сокет сервера
	Socket socket; // сокет
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
			System.out.println("Запустили сервер");
			while (true) {
				socket = serverSocet.accept();
				System.out.println("Подключили сокет " + socket);
//				spp = new ClientPullPusher(socket);
				new ClientConnection(socket, dataBaseCreator);
//				initPassword();				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

//	private void initPassword() { // проверяем пароль
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
