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
				StructureProductDb product = clientPullPusher.pullProduct();
				Boolean dbResponse = productDB.add(product);
				clientPullPusher.pushBoolean(dbResponse);
				
				// addProduct(); // StructureProductDb
				break;
			case "getProductList":
				int groupId = clientPullPusher.pullInt();
				ArrayList<StructureProductDb> prodList = productDB.getListInGroup(groupId);
				clientPullPusher.pushProductList(prodList);
				
				// getProductList(); // int groupId
				break;		
			case "getGroupList":
				ArrayList<StructureGroupDb> groupList = productDB.getList();
				clientPullPusher.pushGroupList();
				
				// getGroupList(); 
				break;
			case "deleteAllInGroup":
				int groupId = clientPullPusher.pullInt();
				Boolean dbResponse = productDB.deleteAllInGroup(groupId);
				clientPullPusher.pushBoolean(dbResponse);
				
				// editProduct(); // StructureProductDb
				break;	
				
			case "increaseGoodAmount":
				int prodId = clientPullPusher.pullInt();
				int increaseOnValue = clientPullPusher.pullInt();
				Boolean dbResponse = productDB.increaseAmount(prodId, increaseOnValue);
				clientPullPusher.pushBoolean(dbResponse);
				
				// editProduct(); // StructureProductDb
				break;
			case "decreaseGoodAmount":
				int prodId = clientPullPusher.pullInt();
				int decreaseOnValue = clientPullPusher.pullInt();
				Boolean dbResponse = productDB.decreaseAmount(prodId, decreaseOnValue);
				clientPullPusher.pushBoolean(dbResponse);
				
				// editProduct(); // StructureProductDb
				break;
			case "editProduct":
				StructureProductDb product = clientPullPusher.pullProduct();
				Boolean dbResponse = productDB.update(product);
				clientPullPusher.pushBoolean(dbResponse);
				
				// editProduct(); // StructureProductDb
				break;
			case "delProduct":
				int prodId = clientPullPusher.pullInt();
				Boolean dbResponse = productDB.delete(prodId);
				clientPullPusher.pushBoolean(dbResponse);
				
				// delProduct(); // int prodId
				break;
			case "addGroup":
				StructureGroupDb group = clientPullPusher.pullGroup();
				Boolean dbResponse = groupDB.add(group);
				clientPullPusher.pushBoolean(dbResponse);
				
				// addGroup(); // 
				break;
			case "editGroup":
				StructureGroupDb group = clientPullPusher.pullGroup();
				Boolean dbResponse = groupDB.update(group);
				clientPullPusher.pushBoolean(dbResponse);
				
				// editGroup();
				break;
			case "delGroup":
				int groupId = clientPullPusher.pullInt();
				Boolean dbResponse = groupDB.delete(groupId);
				clientPullPusher.pushBoolean(dbResponse);
				
				// delGroup();
				break;
			case "statistics":
				String type = clientPullPusher.pullString();
				String groupId = null;
				if (type.equals("forGroup")) {
					groupId = clientPullPusher.pullString();		
				}
				ArrayList<StructureProductDb> prodStatistics = productDB.getStatistics(groupId);
				clientPullPusher.pushProductList(prodStatistics);
				
				// statistics(); // string type ['forGroup', 'allGroups'],  [int groupId]
				break;
			case "search":
				String searchPhrase = clientPullPusher.pullString();
				ArrayList<StructureProductDb> matchedProducts = productDB.search(searchPhrase);
				clientPullPusher.pushProductList(matchedProducts);
				
				// search(); // string productName
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

	// private addProduct() {
	// 	StructureProductDb product = clientPullPusher.pullProduct();
	// 	productDao.add(product);

	// }

	// private void editProduct() {
	// 	// TODO Auto-generated method stub

	// }

	// private void delProduct() {
	// 	// TODO Auto-generated method stub

	// }

	// private void addGroup() {
	// 	while (true) {
	// 		String s = clientPullPusher.pullString();
	// 		if (s.equals("back")) {
	// 			return;
	// 		} else if (s.equals("add")) {
	// 			ArrayList<StructureOfGroupDB> newGroups = clientPullPusher
	// 					.pullListOfGroups();
	// 			int listSize = newGroups.size();
	// 			for (int i = 0; i < listSize; i++) {
	// 				groupDB.add(newGroups.get(i));
	// 			}
	// 			return;
	// 		} else if (s.equals("exit")) {
	// 			try {
	// 				clientPullPusher.getSocket().close();
	// 				serverconnection = false;
	// 				return;
	// 			} catch (IOException e) {
	// 				e.printStackTrace();
	// 			}
	// 		}
	// 	}

	// }

	// private void editGroup() {
	// 	// TODO Auto-generated method stub

	// }

	// private void delGroup() {
	// 	while (true) {
	// 		String s = clientPullPusher.pullString();

	// 		if (s.equals("back")) {
	// 			return;
	// 		} else if (s.equals("del")) {
	// 			groupDB.delete(clientPullPusher.pullInt());
	// 			return;
	// 		} else if (s.equals("exit")) {
	// 			try {
	// 				clientPullPusher.getSocket().close();
	// 				serverconnection = false;
	// 				return;
	// 			} catch (IOException e) {
	// 				e.printStackTrace();
	// 			}
	// 		}
	// 	}

	// }

	// private void statistics() {
	// 	// TODO Auto-generated method stub

	// }

	// private void search() {
	// 	// TODO Auto-generated method stub

	// }
}
