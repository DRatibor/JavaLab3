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
			e.printStackTrace();
		}
	}

	public Socket getSocket() {
		return socket;
	}

	public void pushString(String string) {
		try {
			ou.writeUTF(string);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String pullString() {
		try {
			return io.readUTF();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void pushChar(char charr) {
		try {
			ou.write(charr);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void pushInt(int i) {
		try {
			ou.writeInt(i);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int pullInt() {
		try {
			return io.readInt();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public void pushDouble(double d) {
		try {
			ou.writeDouble(d);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public double pullDouble() {
		try {
			return io.readDouble();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public void pushBoolean(boolean b) {
		try {
			ou.writeBoolean(b);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public boolean pullBoolean() {
		try {
			return io.readBoolean();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	public void pushGroup(StructureOfGroupDB groupToServer) throws Exception {				
		objOu.writeObject(groupToServer);
	}
	
	public void pushProduct(StructureOfProductDB productToServer) throws Exception {				
		objOu.writeObject(productToServer);
	}
	
	public StructureOfGroupDB pullGroup() throws Exception {
		StructureOfGroupDB groupFromServer = (StructureOfGroupDB) objIo.readObject();
		
		return groupFromServer;
	}
	
	public StructureOfProductDB pullProduct() throws Exception {
		StructureOfProductDB productFromServer = (StructureOfProductDB) objIo.readObject();
		
		return productFromServer;
	}
	
	public ArrayList<StructureOfGroupDB> pullGroupList () throws Exception {
		ArrayList<StructureOfGroupDB> listOfGroupsFromServer = (ArrayList<StructureOfGroupDB>) objIo.readObject(); 
		
		return listOfGroupsFromServer;
	}
	
	public ArrayList<StructureOfProductDB> pullProductsList () throws Exception {
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
