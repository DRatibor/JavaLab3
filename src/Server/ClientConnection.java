package Server;

import java.io.IOException;
import java.net.*;

public class ClientConnection extends Thread{
	
	Socket socket;
	DataBaseCreator dataBaseCreator;
	ClientPullPusher clientPullPusher;
	Boolean keepConnection = true;
	
	public ClientConnection (Socket socket, DataBaseCreator dataBaseCreator) {
        this.socket = socket;
        this.dataBaseCreator = dataBaseCreator;
        clientPullPusher = new ClientPullPusher(socket);
        this.start();
    }
	
	 public void run() {

		 	String msg1;
	        while (keepConnection) {
	        	System.out.println("цикл принятия строки запущен");
	        msg1 = clientPullPusher.pullString();
	        	System.out.println(msg1);
	            switch (msg1) {
	                case "Exit":
					try {
						clientPullPusher.getSocket().close();
					} catch (IOException e) {
						e.printStackTrace();
					}
	                	keepConnection = false;
	                    break;
	                case "InitPassword":
	                    if(checkPassword()) new DataBaseManager(clientPullPusher ,dataBaseCreator);
	                    break;
	            }
	        }

}

	private boolean checkPassword() {
		return true;
	}
}
