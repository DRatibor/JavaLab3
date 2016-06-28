package Client;

import java.util.ArrayList;

import Server.StructureOfProductDB;

public class CollectionManager {

	// // private String productGroup; // �������� ������
	// // private String productName; // �������� ������
	// // private String productDescription; // �������� ������
	// // private String productManufacturer; // �������� ������������� ������
	// // private int productAmount; // ���������� ������
	// // private double productPrice; // ���� ������
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
		//product.setProductID(null);
		product.setProductGroup(productGroup);
		product.setProductName(productName);
		product.setProductDescription(productDescription);
		product.setProductManufacturer(productManufacturer);
		product.setProductAmount(productAmount);
		product.setProductPrice(productPrice);
		productList.add(product);
		return productList;
	}

	public ArrayList createGroupCollection(
			String groupName, String groupDescription) {
		ArrayList productList = new ArrayList();
		StructureOfGroupDB group = new StructureOfGroupDB();
		// group.setgroupId(null);
		group.setGroupName(groupName);
		group.setGroupDescription(groupDescription);
		productList.add(group);
		return productList;
	}
	
	public String[] createGroupCollection(
			String groupName, String groupDescription) {
		ArrayList productList = new ArrayList();
		StructureOfGroupDB group = new StructureOfGroupDB();
		// group.setgroupId(null);
		group.setGroupName(groupName);
		group.setGroupDescription(groupDescription);
		productList.add(group);
		return productList;
	}
	
	
}
