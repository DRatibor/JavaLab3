package Server;

import java.sql.*;

public class DataBaseCreator {
	private Connection connection;

	public void createDateBase(String name) {
		try {
			connection = null;
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:" + name);
			ProductDB prod = new ProductDB(connection); //убедится что это нужный класс
			prod.createTableDataBase();
			//добавить метод, который создает БД
			GroupDB group = new GroupDB(connection); //убедится что это нужный класс
			group.createTableDataBase();
			//добавить мотод, который создает БД
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
