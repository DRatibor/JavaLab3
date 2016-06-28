package Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import SharedTypes.StructureOfGroupDB;
import SharedTypes.StructureOfProductDB;

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
			System.out.println("Сервер пишет стринг");
			ou.writeUTF(string);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String pullString() {
		try {
			System.out.println("Сервер читает стринг");
			return io.readUTF();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void pushChar(char charr) {
		try {
			System.out.println("Сервер пишет чар");
			ou.write(charr);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void pushInt(int i) {
		try {
			System.out.println("Сервер пишет инт");
			ou.writeInt(i);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int pullInt() {
		try {
			System.out.println("Сервер читает стринг");
			return io.readInt();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public void pushDouble(double d) {
		try {
			System.out.println("Сервер пишет дабл");
			ou.writeDouble(d);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public double pullDouble() {
		try {
			System.out.println("Сервер читает стринг");
			return io.readDouble();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public void pushBoolean(boolean b) {
		try {
			System.out.println("Сервер пишет булеан");
			ou.writeBoolean(b);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public boolean pullBoolean() {
		try {
			System.out.println("Сервер читает булеан");
			return io.readBoolean();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	public StructureOfGroupDB pullGroup() {
		StructureOfGroupDB groupFromClient = null;
		try {
			System.out.println("Сервер читает группу");
			groupFromClient = (StructureOfGroupDB) objIo.readObject();
			// return productFromClient;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return groupFromClient;
	}

	public StructureOfProductDB pullProduct() {
		StructureOfProductDB productFromClient = null;
		try {
			System.out.println("Сервер читает продукт");
			productFromClient = (StructureOfProductDB) objIo.readObject();
			// return productFromClient;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return productFromClient;
	}

	public void pushGroup(StructureOfGroupDB groupToClient) {
		try {
			System.out.println("Сервер пишет группу");
			objOu.writeObject(groupToClient);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void pushProduct(StructureOfProductDB productToClient) {
		try {
			System.out.println("Сервер пишет продукт");
			objOu.writeObject(productToClient);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void pushGroupList(ArrayList<StructureOfGroupDB> listOfGroupsToClient) {
		try {
			System.out.println("Сервер пишет список групп");
			objOu.writeObject(listOfGroupsToClient);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void pushProductList(
			ArrayList<StructureOfProductDB> listOfProductsToClient) {
		try {
			System.out.println("Сервер пишет список продуктов");
			objOu.writeObject(listOfProductsToClient);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// public void pushListOfGroups (ArrayList<StructureOfGroupDB> l) {
	// try {
	// int listSize = l.size();
	// pushInt(listSize);
	// for(int i = 0; i < listSize; i++) {
	// objOu.writeObject(l.get(i));
	// }
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	// }

	// public ArrayList<StructureOfGroupDB> pullListOfGroups() {
	// ArrayList<StructureOfGroupDB> groupsList = new
	// ArrayList<StructureOfGroupDB>();

	// try {
	// int listSize = pullInt();
	// for(int i = 0; i < listSize; i++) {
	// StructureOfGroupDB newGroup = (StructureOfGroupDB) objIo.readObject();
	// groupsList.add(newGroup);
	// }
	// } catch (IOException e) {
	// e.printStackTrace();
	// } catch (ClassNotFoundException e) {
	// e.printStackTrace();
	// }

	// return groupsList;
	// }
}
