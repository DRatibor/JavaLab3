package Client;

import java.net.Socket;

public class Client_Thread extends Thread {
    private Socket socket;
    ServerPullPusher serverPullPusher;

    public Client_Thread(Socket socket) {
        this.socket = socket;        
        System.out.println("��� ����� � ������ Client_Thread � ������������ Client_Thread �����������");
        this.start();
//        System.out.println("��� ����� � ������ Client_Thread � ������������ Client_Thread �����  this.start(); �����������");
    }

    public void run() {
//        super.run();
    	System.out.println("��� ����� � ������ Client_Thread � ������ ��� �����������");
        serverPullPusher = new ServerPullPusher(socket);
        serverPullPusher.pushString("������ ��������");
        
    }
}