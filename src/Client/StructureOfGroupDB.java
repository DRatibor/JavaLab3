package Client;

import java.io.Serializable;

public class StructureOfGroupDB implements Serializable {

	private int groupId;
	private String groupName; // название группы
	private String groupDescription; // описание группы
	
	// ставим "сетеры"

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public void setGroupDescription(String groupDescription) {
		this.groupDescription = groupDescription;
	}

	// ставим "гетеры"

	public int getGroupID() {
		return groupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public String getGroupDescription() {
		return groupDescription;
	}
}
