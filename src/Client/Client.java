package Client;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import Server.*;

public class Client {
	static int in;
	static String pass = "play";

	public static void main(String[] args) throws IOException {
		InetAddress addr = InetAddress.getByName(null);
		System.out.println("адреса =" +addr);
		Socket socket = new Socket (addr, Server.PORT);
		System.out.println("socket = " +socket);
		//передаем логин и пароль. ѕроверить работоспособность
		socket.getOutputStream().write(pass.getBytes());
		socket.getOutputStream().write(pass.getBytes());
		//получаем файл
		//InputStream bos = socket.getInputStream();
		//byte buf[] = new byte[64*1024];
        //int r = bos.read(buf);
        //FileOutputStream fout= new FileOutputStream("Test1.txt");
        //fout.write(buf);
        //fout.close();
		//bos.close();
		socket.close();
	}

}
