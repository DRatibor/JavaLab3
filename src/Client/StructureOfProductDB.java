package Client;

import java.io.Serializable;

public class StructureOfProductDB implements Serializable {

	private String productGroup; // �������� ������
	private String productName; // �������� ������
	private String productDescription; // �������� ������
	private String productManufacturer; // �������� ������������� ������
	private int productID; // ������������� ��������
	private int productAmount; // ���������� ������
	private double productPrice; // ���� ������

	// ������ "������"

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public void setProductGroup(String productGroup) {
		this.productGroup = productGroup;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public void setProductManufacturer(String productManufacturer) {
		this.productManufacturer = productManufacturer;
	}

	public void setProductAmount(int productAmount) {
		this.productAmount = productAmount;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	// ������ "������"

	public int getProductID() {
		return productID;
	}

	public String getProductGroup() {
		return productGroup;
	}

	public String getProductName() {
		return productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public String getProductManufacturer() {
		return productManufacturer;
	}

	public int getProductAmount() {
		return productAmount;
	}

	public double getProductPrice() {
		return productPrice;
	}

}
