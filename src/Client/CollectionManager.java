package Client;

import java.util.ArrayList;

import Server.StructureOfProductDB;

public class CollectionManager {
	ServerPullPusher serverPullPusher;

	DataBaseBank dataBaseBank;

	// // private String productGroup; // название группы
	// // private String productName; // название товара
	// // private String productDescription; // описание товара
	// // private String productManufacturer; // название производителя товара
	// // private int productAmount; // количество товара
	// // private double productPrice; // цена товара
	//
	// CollectionCreator() {
	// // this.productGroup =
	// // this.productName
	// // this.productDescription
	// // this.productManufacturer,
	// // this.productAmount
	// // this.productPrice
	// }

	public ArrayList<StructureOfProductDB> createProductCollection(
			String productGroup, String productName, String productDescription,
			String productManufacturer, int productAmount, double productPrice) {
		ArrayList<StructureOfProductDB> productList = new ArrayList<StructureOfProductDB>();
		StructureOfProductDB product = new StructureOfProductDB();
		// product.setProductID(null);
		product.setProductGroup(productGroup);
		product.setProductName(productName);
		product.setProductDescription(productDescription);
		product.setProductManufacturer(productManufacturer);
		product.setProductAmount(productAmount);
		product.setProductPrice(productPrice);
		productList.add(product);
		return productList;
	}

	public ArrayList createGroupCollection(String groupName,
			String groupDescription) {
		ArrayList productList = new ArrayList();
		StructureOfGroupDB group = new StructureOfGroupDB();
		// group.setgroupId(null);
		group.setGroupName(groupName);
		group.setGroupDescription(groupDescription);
		productList.add(group);
		return productList;
	}

	public String[] arrayOfGroupsInGropCollection() {
		ArrayList bigGroupList = new ArrayList();
		bigGroupList = dataBaseBank.getGroupList();
		bigGroupList.size();
		String[] groupList = new String[bigGroupList.size()];
		for (int i = 0; i < bigGroupList.size(); i++) {
			groupList[i] = ((StructureOfGroupDB) bigGroupList.get(i))
					.getGroupName();
		}
		return groupList;
	}

	public String groupDiscription(String nameOfGroup) {
		String groupDiscription = null;
		ArrayList bigGroupList = new ArrayList();
		bigGroupList = dataBaseBank.getGroupList();
		bigGroupList.size();
		for (int i = 0; i < bigGroupList.size(); i++) {
			if (nameOfGroup == ((StructureOfGroupDB) bigGroupList.get(i))
					.getGroupName())
				groupDiscription = ((StructureOfGroupDB) bigGroupList.get(i))
						.getGroupDescription();
		}
		return groupDiscription;
	}

	public String[] getGroupProducts(String nameOfGroup) {
		ArrayList bigProductList = new ArrayList();
		dataBaseBank.setProductList();
		bigProductList = dataBaseBank.getProductList();
		bigProductList.size();
		String[] productList = new String[bigProductList.size()];
		for (int i = 1; i <= bigProductList.size(); i++) {
			productList[i] = ((StructureOfProductDB) bigProductList.get(i-1))
					.getProductName();
		}
		return productList;
	}

	public String[] addProductData(String nameOfProduct) {
		int i;
		ArrayList bigProductList = new ArrayList();
		dataBaseBank.setProductList();
		bigProductList = dataBaseBank.getProductList();
		String[] productArr = new String[4];
		for (i = 0; i < bigProductList.size(); i++) {
			if (nameOfProduct == ((StructureOfProductDB) bigProductList.get(i)).getProductName())
				break;
		}
		productArr[0] = ((StructureOfProductDB) bigProductList.get(i)).getProductManufacturer();
		productArr[1] = ((StructureOfProductDB) bigProductList.get(i)).getProductDescription();
		productArr[2] = String.valueOf(((StructureOfProductDB) bigProductList.get(i)).getProductAmount());
		productArr[3] = String.valueOf(((StructureOfProductDB) bigProductList.get(i)).getProductPrice());
		return productArr;
		
	}

}
