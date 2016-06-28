package Server;

import java.io.Serializable;

public class StructureOfGroupDB implements Serializable {
	// задаем переменные ячеек БД
	private int groupId;
	private String groupName; // название группы
	private String groupDescription; // описание группы
	private final static String groupTableName = "Group table";
	
	// создаем таблицу таблицу со всеми группами товаров

		private final static String GROUPTABLE = "create table if not exists "
				+ groupTableName
				+ "('id' integer primary key autoincrement,'groupName' text, 'groupDescription' text);";
		
		// Ставим "сетеры" для внесения правок в таблицу
		
		public void setGroupId(int groupId) {
			this.groupId = groupId;
		}

		public void setGroupName(String groupName) {
			this.groupName = groupName;
		}

		public void setGroupDescription(String groupDescription) {
			this.groupDescription = groupDescription;
		}
		
		// поставим "гетеры" для получения отдельных значений таблицы и целой
		// таблицы
		
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
