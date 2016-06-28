package Client;

import java.util.ArrayList;

public class DataBaseBank {
	ServerPullPusher serverPullPusher;
	ArrayList groupList = new ArrayList();
	ArrayList productList = new ArrayList();

	public ArrayList getGroupList() {
		return groupList;
	}

	public ArrayList getProductList() {
		return productList;
	}

	public void setGroupList() {
		groupList = serverPullPusher.pullListOfGroups();
	}

	public void setProductList() {
		productList = serverPullPusher.pullListOfProducts();
	}

}
