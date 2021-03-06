package Client;

import java.io.*;
import java.net.*;
import java.util.ArrayList;

import SharedTypes.StructureOfGroupDB;
import SharedTypes.StructureOfProductDB;

public class ServerPullPusher {
	private Socket socket;
	private DataInputStream io;
	private DataOutputStream ou;
	private ObjectOutputStream objOu;
	private ObjectInputStream objIo;

	ServerPullPusher(Socket socket) {
		this.socket = socket;
		try {
			io = new DataInputStream(socket.getInputStream());
			ou = new DataOutputStream(socket.getOutputStream());
			objOu = new ObjectOutputStream(socket.getOutputStream());
			objIo = new ObjectInputStream(socket.getInputStream());

		} catch (IOException e) {
			System.out.println("error here");
			e.printStackTrace();
		}
	}

	public Socket getSocket() {
		return socket;
	}

	public void pushString(String string) {
		try {
			System.out.println("������ ����� ������");
			ou.writeUTF(string);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String pullString() {
		try {
			System.out.println("������ ������ ������");
			return io.readUTF();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void pushChar(char charr) {
		try {
			System.out.println("������ ����� ���");
			ou.write(charr);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void pushInt(int i) {
		try {
			System.out.println("������ ����� ���");
			ou.writeInt(i);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int pullInt() {
		try {
			System.out.println("������ ������ ���");
			return io.readInt();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public void pushDouble(double d) {
		try {
			System.out.println("������ ����� ����");
			ou.writeDouble(d);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public double pullDouble() {
		try {
			System.out.println("������ ������ ����");
			return io.readDouble();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public void pushBoolean(boolean b) {
		try {
			System.out.println("������ ����� ������");
			ou.writeBoolean(b);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public boolean pullBoolean() {
		try {
			System.out.println("������ ������ ������");
			return io.readBoolean();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	public void pushGroup(StructureOfGroupDB groupToServer) throws Exception {
		System.out.println("������ ����� ������");
		objOu.writeObject(groupToServer);
	}
	
	public void pushProduct(StructureOfProductDB productToServer) throws Exception {
		System.out.println("������ ����� �������");
		objOu.writeObject(productToServer);
	}
	
	public StructureOfGroupDB pullGroup() throws Exception {
		System.out.println("������ ������ ������");
		StructureOfGroupDB groupFromServer = (StructureOfGroupDB) objIo.readObject();
		
		return groupFromServer;
	}
	
	public StructureOfProductDB pullProduct() throws Exception {
		System.out.println("������ ������ �������");
		StructureOfProductDB productFromServer = (StructureOfProductDB) objIo.readObject();
		
		return productFromServer;
	}
	
	public ArrayList<StructureOfGroupDB> pullGroupList () throws Exception {
		System.out.println("������ ������ ������ �����");
		ArrayList<StructureOfGroupDB> listOfGroupsFromServer = (ArrayList<StructureOfGroupDB>) objIo.readObject(); 
		
		return listOfGroupsFromServer;
	}
	
	public ArrayList<StructureOfProductDB> pullProductsList () throws Exception {
		System.out.println("������ ������ ������ ���������");
		ArrayList<StructureOfProductDB> listOfProductsFromServer = (ArrayList<StructureOfProductDB>) objIo.readObject(); 
		
		return listOfProductsFromServer;
	}
		
		
//
//	public void pushListOfGroups(ArrayList arrayList) {
//		try {
//			int listSize = arrayList.size();
//			pushInt(listSize);
//			for (int i = 0; i < listSize; i++) {
//				objOu.writeObject(arrayList.get(i));
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//
//	public ArrayList<StructureOfGroupDB> pullListOfGroups() {
//		ArrayList<StructureOfGroupDB> groupsList = new ArrayList<StructureOfGroupDB>();
//
//		try {
//			int listSize = pullInt();
//			for (int i = 0; i < listSize; i++) {
//				StructureOfGroupDB newGroup = (StructureOfGroupDB) objIo
//						.readObject();
//				groupsList.add(newGroup);
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//
//		return groupsList;
//	}
}
