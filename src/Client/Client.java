package Client;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class Client extends Thread {
	InetAddress addr;
	Socket socket;
	int PORT = 8001;


	Client() {
		try {
			addr = InetAddress.getByName(null);
			socket = new Socket(addr,PORT);
			new Client_Thread(socket);
			//new MainUI();
			//new LoginPassUI(socket);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
}
}

