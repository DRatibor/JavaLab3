package Server;

import java.sql.*;

public class DataBaseCreator {
	private Connection connection;

	public void createDateBase(String name) {
		try {
			connection = null;
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:" + name);
			ProductDB prod = new ProductDB(connection); //�������� ��� ��� ������ �����
			prod.createTableDataBase();
			//�������� �����, ������� ������� ��
			GroupDB group = new GroupDB(connection); //�������� ��� ��� ������ �����
			group.createTableDataBase();
			//�������� �����, ������� ������� ��
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		return connection;
	}

}
