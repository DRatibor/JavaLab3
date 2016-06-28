package Server;

import java.sql.*;
import java.util.ArrayList;

public class ProductDB {
	Connection connection;

	ProductDB(Connection connection) {
		this.connection = connection;
	}

	public void createTableDataBase() {

		try {
			PreparedStatement product = connection
					.prepareStatement(StructureOfProductDB.getProductTable());
			int result = product.executeUpdate();
			product.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<StructureOfProductDB> getAll() {
		ArrayList<StructureOfProductDB> productList = new ArrayList<StructureOfProductDB>();

		try {
			Statement statement = connection.createStatement();
			ResultSet res = statement.executeQuery("SELECT * FROM "
					+ StructureOfProductDB.getProductTableName());

			while (res.next()) {
				StructureOfProductDB product = new StructureOfProductDB();
				product.setProductID(res.getInt("id"));
				product.setProductGroup(res.getString("productGroup"));
				product.setProductName(res.getString("productName"));
				product.setProductDescription(res
						.getString("productDescription"));
				product.setProductManufacturer(res
						.getString("productManufacturer"));
				product.setProductAmount(res.getInt("productAmount"));
				product.setProductPrice(res.getDouble("productPrice"));

				productList.add(product);
			}
			statement.close();
			res.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return productList;
	}

	public ArrayList<StructureOfProductDB> getBuyName(String productName) {
		ArrayList<StructureOfProductDB> productList = new ArrayList<StructureOfProductDB>();

		try {
			Statement statement = connection.createStatement();
			ResultSet res = statement.executeQuery("SELECT * FROM "
					+ StructureOfProductDB.getProductTableName()
					+ " WHERE name = '" + productName + "'");

			while (res.next()) {
				StructureOfProductDB product = new StructureOfProductDB();
				product.setProductID(res.getInt("id"));
				product.setProductGroup(res.getString("productGroup"));
				product.setProductName(res.getString("productName"));
				product.setProductDescription(res
						.getString("productDescription"));
				product.setProductManufacturer(res
						.getString("productManufacturer"));
				product.setProductAmount(res.getInt("productAmount"));
				product.setProductPrice(res.getDouble("productPrice"));

				productList.add(product);
			}
			statement.close();
			res.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return productList;
	}

	public ArrayList<StructureOfProductDB> getBuyGroup(int groupId) {
		ArrayList<StructureOfProductDB> productList = new ArrayList<StructureOfProductDB>();

		try {
			Statement statement = connection.createStatement();
			ResultSet res = statement.executeQuery("SELECT * FROM "
					+ StructureOfProductDB.getProductTableName()
					+ " WHERE idGroup = '" + groupId + "'");

			while (res.next()) {
				StructureOfProductDB product = new StructureOfProductDB();
				product.setProductID(res.getInt("id"));
				product.setProductGroup(res.getString("productGroup"));
				product.setProductName(res.getString("productName"));
				product.setProductDescription(res
						.getString("productDescription"));
				product.setProductManufacturer(res
						.getString("productManufacturer"));
				product.setProductAmount(res.getInt("productAmount"));
				product.setProductPrice(res.getDouble("productPrice"));

				productList.add(product);
			}
			statement.close();
			res.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return productList;
	}

	public ArrayList<StructureOfProductDB> getBuySubGroup(int subGroupId) {
		ArrayList<StructureOfProductDB> productList = new ArrayList<StructureOfProductDB>();

		try {
			Statement statement = connection.createStatement();
			ResultSet res = statement.executeQuery("SELECT * FROM "
					+ StructureOfProductDB.getProductTableName()
					+ " WHERE idSubGroup = '" + subGroupId + "'");

			while (res.next()) {
				StructureOfProductDB product = new StructureOfProductDB();
				product.setProductID(res.getInt("id"));
				product.setProductGroup(res.getString("productGroup"));
				product.setProductName(res.getString("productName"));
				product.setProductDescription(res
						.getString("productDescription"));
				product.setProductManufacturer(res
						.getString("productManufacturer"));
				product.setProductAmount(res.getInt("productAmount"));
				product.setProductPrice(res.getDouble("productPrice"));

				productList.add(product);
			}
			statement.close();
			res.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return productList;
	}

	public boolean add(StructureOfProductDB product) {
		boolean isInsert = false;

		try {
			PreparedStatement statement = connection
					.prepareStatement("INSERT INTO "
							+ StructureOfProductDB.getProductTableName()
							+ " (productGroup, productName, productDescription, productManufacturer, productAmount, productPrice) VALUES (?, ?, ?, ?, ?, ?)");

			statement.setString(1, product.getProductGroup());
			statement.setString(2, product.getProductName());
			statement.setString(3, product.getProductDescription());
			statement.setString(4, product.getProductManufacturer());
			statement.setInt(5, product.getProductAmount());
			statement.setDouble(6, product.getProductPrice());

			int result = statement.executeUpdate();
			isInsert = true;
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isInsert;
	}

	public boolean update(int id, StructureOfProductDB product) {
		boolean isUpdate = false;

		try {
			PreparedStatement statement = connection.prepareStatement("UPDATE "
					+ StructureOfProductDB.getProductTableName()
					+ " SET productGroup = '" // ????????????
					+ product.getProductGroup() + "', productName = '"
					+ product.getProductName() + "', productDescription = '"
					+ product.getProductDescription()
					+ "', productManufacturer = '"
					+ product.getProductManufacturer() + "', productAmount = '"
					+ product.getProductAmount() + "', productPrice = '"
					+ product.getProductPrice() + "' WHERE id = '" + id + "'");
			int result = statement.executeUpdate();
			isUpdate = true;
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isUpdate;
	}

	public boolean delete(int id) {
		boolean isDelete = false;

		try {
			PreparedStatement statement = connection
					.prepareStatement("DELETE FROM "
							+ StructureOfProductDB.getProductTableName()
							+ " WHERE id = '" + id + "'");
			int result = statement.executeUpdate();
			isDelete = true;
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isDelete;
	}
}
