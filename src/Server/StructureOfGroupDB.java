package Server;

import java.io.Serializable;

public class StructureOfGroupDB implements Serializable {
	// ������ ���������� ����� ��
	private int groupId;
	private String groupName; // �������� ������
	private String groupDescription; // �������� ������
	private final static String groupTableName = "Group table";
	
	// ������� ������� ������� �� ����� �������� �������

		private final static String GROUPTABLE = "create table if not exists "
				+ groupTableName
				+ "('id' integer primary key autoincrement,'groupName' text, 'groupDescription' text);";
		
		// ������ "������" ��� �������� ������ � �������
		
		public void setGroupId(int groupId) {
			this.groupId = groupId;
		}

		public void setGroupName(String groupName) {
			this.groupName = groupName;
		}

		public void setGroupDescription(String groupDescription) {
			this.groupDescription = groupDescription;
		}
		
		// �������� "������" ��� ��������� ��������� �������� ������� � �����
		// �������
		
		public int getGroupID() {
			return groupId;
		}

		public static String getGroupTable() {
			return GROUPTABLE;
		}
		
		public String getGroupName() {
			return groupName;
		}

		public String getGroupDescription() {
			return groupDescription;
		}
		public static String getGroupTableName() {
			return groupTableName;
		}
}
