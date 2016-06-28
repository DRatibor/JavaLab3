package Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class ClientPullPusher {
	private Socket socket;
	private DataInputStream io;
	private DataOutputStream ou;
	private ObjectOutputStream objOu;
    private ObjectInputStream objIo;

	ClientPullPusher(Socket socket) {
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
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	public String pullString() {
		try {
			return io.readUTF();
		} catch (IOException e) {
			System.out.println(e.getMessage());
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
	
	public StructureProductDb pullProduct() {
		try {
			StructureProductDb productFromClient = (StructureProductDb) objIo.readObject();
			return productFromClient;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void pushGroup(StructureGroupDb groupToClient) {
		try {
			objOu.writeObject(groupToClient);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void pushProduct(StructureProductDb productToClient) {
		try {
			objOu.writeObject(productToClient);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void pushGroupList (ArrayList<StructureGroupDb> listOfGroupsToClient) {
		try {
			objOu.writeObject(listOfGroupsToClient);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void pushProductList (ArrayList<StructureProductDb> listOfProductsToClient) {
		try {
			objOu.writeObject(listOfProductsToClient);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	// public void pushListOfGroups (ArrayList<StructureOfGroupDB> l) {
 //       try {
 //       	int listSize = l.size();
 //       	pushInt(listSize);
 //       	for(int i = 0; i < listSize; i++) {
 //       		objOu.writeObject(l.get(i));
 //       	}   	        	
 //       } catch (IOException e) {
 //          e.printStackTrace();
 //       }
 //  }
	
	// public ArrayList<StructureOfGroupDB> pullListOfGroups() {
	// 	ArrayList<StructureOfGroupDB> groupsList = new ArrayList<StructureOfGroupDB>();
		
	// 	try {        	
 //       	int listSize = pullInt();
 //       	for(int i = 0; i < listSize; i++) {
 //       		StructureOfGroupDB newGroup = (StructureOfGroupDB) objIo.readObject();
 //       		groupsList.add(newGroup);
 //       	} 
 //       } catch (IOException e) {
 //          e.printStackTrace();
 //       } catch (ClassNotFoundException e) {
 //          e.printStackTrace();
 //       }
        
 //       return groupsList;
 //  }
}
