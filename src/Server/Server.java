package Server;

import java.io.*;
import java.net.*;

public class Server {

	public static final int PORT = 8081;
	static int in = 1;
	static String pass = "play";
	static DataInputStream is;
	static DataOutputStream os;
	ServerSocket s;

	Server() throws IOException {
		s = new ServerSocket(PORT);
		try {
			Socket socket = s.accept();
			System.out.println("Встановили з'єднання: " + socket);
			is = new DataInputStream(socket.getInputStream());
		} finally {
			s.close();
		}
	}
	String getName() throws IOException{
	return is.readUTF();
	}
	
}
