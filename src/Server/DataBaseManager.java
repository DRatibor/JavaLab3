package Server;

import java.io.IOException;
import java.util.ArrayList;

import SharedTypes.StructureOfGroupDB;
import SharedTypes.StructureOfProductDB;

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
				StructureOfProductDB product = clientPullPusher.pullProduct();
				Boolean dbResponse = productDB.add(product);
				clientPullPusher.pushBoolean(dbResponse);
				
				// addProduct(); // StructureProductDb
				break;
			case "getProductList":
				String groupName = clientPullPusher.pullString();
				ArrayList<StructureOfProductDB> prodList = productDB.getListInGroup(groupName);
				clientPullPusher.pushProductList(prodList);
				
				// getProductList(); // int groupId
				break;		
			case "getGroupList":
				ArrayList<StructureOfGroupDB> groupList = groupDB.getList();
				clientPullPusher.pushGroupList(groupList);
				
				// getGroupList(); 
				break;
			case "deleteAllInGroup":
				String groupNameToDeleteIn = clientPullPusher.pullString();
				Boolean productsIngroupDeleted = productDB.deleteAllInGroup(groupNameToDeleteIn);
				clientPullPusher.pushBoolean(productsIngroupDeleted);
				
				// editProduct(); // StructureProductDb
				break;	
				
			case "increaseGoodAmount":
				StructureOfProductDB productToIncreaseAmount = clientPullPusher.pullProduct();
				int increaseOnValue = clientPullPusher.pullInt();
				Boolean amountIncreased = productDB.increaseAmount(productToIncreaseAmount, increaseOnValue);
				clientPullPusher.pushBoolean(amountIncreased);
				
				// editProduct(); // StructureProductDb
				break;
			case "decreaseGoodAmount":
				StructureOfProductDB productToDecreaseAmount = clientPullPusher.pullProduct();
				int decreaseOnValue = clientPullPusher.pullInt();
				Boolean amountDecreased = productDB.decreaseAmount(productToDecreaseAmount, decreaseOnValue);
				clientPullPusher.pushBoolean(amountDecreased);
				
				// editProduct(); // StructureProductDb
				break;
			case "editProduct":
				StructureOfProductDB productToEdit = clientPullPusher.pullProduct();
				Boolean productUpdated = productDB.update(productToEdit);
				clientPullPusher.pushBoolean(productUpdated);
				
				// editProduct(); // StructureProductDb
				break;
			case "delProduct":
				StructureOfProductDB productToDelete = clientPullPusher.pullProduct();
				Boolean productDeleted = productDB.delete(productToDelete);
				clientPullPusher.pushBoolean(productDeleted);
				
				// delProduct(); // int prodId
				break;
			case "addGroup":
				StructureOfGroupDB group = clientPullPusher.pullGroup();
				Boolean groupAdded = groupDB.add(group);
				clientPullPusher.pushBoolean(groupAdded);
				
				// addGroup(); // 
				break;
			case "editGroup":
				StructureOfGroupDB groupToEdit = clientPullPusher.pullGroup();
				Boolean groupUpdated = groupDB.update(groupToEdit);
				clientPullPusher.pushBoolean(groupUpdated);
				
				// editGroup();
				break;
			case "delGroup":
				StructureOfGroupDB groupToDelete = clientPullPusher.pullGroup();
				Boolean groupDeleted = groupDB.delete(groupToDelete);
				clientPullPusher.pushBoolean(groupDeleted);
				
				// delGroup();
				break;
			case "statistics":
				String type = clientPullPusher.pullString();
				String groupNameToShowStat = "allGroups";
				if (type.equals("forGroup")) {
					groupNameToShowStat = clientPullPusher.pullString();		
				}				
				ArrayList<StructureOfProductDB> prodStatistics = productDB.getStatistics(groupNameToShowStat);
				clientPullPusher.pushProductList(prodStatistics);
				
				// statistics(); // string type ['forGroup', 'allGroups'],  [int groupId]
				break;
			case "search":
				String searchPhrase = clientPullPusher.pullString();
				ArrayList<StructureOfProductDB> matchedProducts = productDB.search(searchPhrase);
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
