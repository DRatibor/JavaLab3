package Server;

import java.io.IOException;
import java.util.ArrayList;

public class DataBaseManager extends Thread {
	Boolean serverconnection = true;
	private ClientPullPusher clientPullPusher;
	private DataBaseCreator dataBaseCreator;
	private GroupDB groupDB;
	private ProductDB productDB;

	DataBaseManager(ClientPullPusher clientPullPusher,
			DataBaseCreator dataBaseCreator) {
		this.clientPullPusher = clientPullPusher;
		this.dataBaseCreator = dataBaseCreator;
		groupDB = new GroupDB(dataBaseCreator.getConnection());
		productDB = new ProductDB(dataBaseCreator.getConnection());
		this.start();
	}

	public void run() {
		super.run();

		while (serverconnection == true) {

			switch (clientPullPusher.pullString()) {

			case "addProduct":
				addProduct();
				break;
			case "editProduct":
				editProduct();
				break;
			case "delProduct":
				delProduct();
				break;
			case "addGroup":
				addGroup();
				break;
			case "editGroup":
				editGroup();
				break;
			case "delGroup":
				delGroup();
				break;
			case "statistics":
				statistics();
				break;
			case "search":
				search();
				break;
			case "exit":
				try {
					clientPullPusher.getSocket().close();
					return;
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			}
		}
	}

	private void addProduct() {
		// TODO Auto-generated method stub

	}

	private void editProduct() {
		// TODO Auto-generated method stub

	}

	private void delProduct() {
		// TODO Auto-generated method stub

	}

	private void addGroup() {
		while (true) {
			String s = clientPullPusher.pullString();
			if (s.equals("back")) {
				return;
			} else if (s.equals("add")) {
				ArrayList<StructureOfGroupDB> newGroups = clientPullPusher
						.pullListOfGroups();
				int listSize = newGroups.size();
				for (int i = 0; i < listSize; i++) {
					groupDB.add(newGroups.get(i));
				}
				return;
			} else if (s.equals("exit")) {
				try {
					clientPullPusher.getSocket().close();
					serverconnection = false;
					return;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	private void editGroup() {
		// TODO Auto-generated method stub

	}

	private void delGroup() {
		while (true) {
			String s = clientPullPusher.pullString();

			if (s.equals("back")) {
				return;
			} else if (s.equals("del")) {
				groupDB.delete(clientPullPusher.pullInt());
				return;
			} else if (s.equals("exit")) {
				try {
					clientPullPusher.getSocket().close();
					serverconnection = false;
					return;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	private void statistics() {
		// TODO Auto-generated method stub

	}

	private void search() {
		// TODO Auto-generated method stub

	}
}
