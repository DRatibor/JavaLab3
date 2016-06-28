package Client;

import java.net.Socket;

public class Client_Thread extends Thread {
    private Socket socket;
    ServerPullPusher serverPullPusher;

    public Client_Thread(Socket socket) {
        this.socket = socket;        
        System.out.println("эта штука в классе Client_Thread и конструкторе Client_Thread выполнилась");
        this.start();
//        System.out.println("эта штука в классе Client_Thread и конструкторе Client_Thread после  this.start(); выполнилась");
    }

    public void run() {
//        super.run();
    	System.out.println("эта штука в классе Client_Thread и методе –ан выполнилась");
        serverPullPusher = new ServerPullPusher(socket);
        serverPullPusher.pushString("строка передана");
        
    }
}