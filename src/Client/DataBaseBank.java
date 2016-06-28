package Client;

import java.util.ArrayList;

public class DataBaseBank {
	ServerPullPusher serverPullPusher;
	ArrayList groupList = new ArrayList();
	ArrayList productList = new ArrayList();

	DataBaseBank (ServerPullPusher serverPullPusher) {
		this.serverPullPusher = serverPullPusher;
	}
	
	public ArrayList getGroupList() {
		return groupList;
	}

	public ArrayList getProductList() {
		return productList;
	}

	public void setGroupList() throws Exception {
		groupList = serverPullPusher.pullGroupList();
	}

	public void setProductList() throws Exception {
		productList = serverPullPusher.pullProductsList();
	}

}
