package Server;

import java.sql.*;
import java.util.ArrayList;

public class GroupDB {
	Connection connection;

	GroupDB(Connection connection) {
		this.connection = connection;
	}	

    public void createTableDataBase() {
        try {
            PreparedStatement product = connection.prepareStatement(StructureOfGroupDB.getGroupTable());
            int result = product.executeUpdate();
            product.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public ArrayList<StructureOfGroupDB> getList() {
    	ArrayList<StructureOfGroupDB> groupList = new ArrayList<StructureOfGroupDB>();

        try {
            Statement statement = connection.createStatement();
            ResultSet res = statement.executeQuery("SELECT * FROM " + StructureOfGroupDB.getGroupTableName());

            while (res.next()) {
            	StructureOfGroupDB structureOfGroupDB = new StructureOfGroupDB();
                structureOfGroupDB.setGroupId(res.getInt("id"));
                structureOfGroupDB.setGroupName(res.getString("groupName"));
                structureOfGroupDB.setGroupDescription(res.getString("groupDescription"));

                groupList.add(structureOfGroupDB);
            }
            statement.close();
            res.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return groupList;
    }
    
    //public ArrayList<StructureOfGroupDB> getByName(String groupName) {
    //	ArrayList<StructureOfGroupDB> groupList = new ArrayList<StructureOfGroupDB>();

    //    try {
    //        Statement statement = connection.createStatement();
    //        ResultSet res = statement.executeQuery("SELECT * FROM " + StructureOfGroupDB.getGroupTableName()
    //        	    + " WHERE name = '" + groupName + "'");

    //        while (res.next()) {
    //        	StructureOfGroupDB structureOfGroupDB = new StructureOfGroupDB();
    //            structureOfGroupDB.setGroupId(res.getInt("id"));
    //            structureOfGroupDB.setGroupName(res.getString("groupName"));
    //            structureOfGroupDB.setGroupDescription(res.getString("groupDescription"));

    //            groupList.add(structureOfGroupDB);
    //        }
    //        statement.close();
    //        res.close();
    //    } catch (SQLException e) {
    //        e.printStackTrace();
    //    }
    //    return groupList;
    //}

    
    public boolean add(StructureOfGroupDB structureOfGroupDB) {
        boolean isInsert = false;

        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO " + StructureOfGroupDB.getGroupTableName() + " (name) VALUES (?)");

            statement.setString(1, structureOfGroupDB.getGroupName());

            int result = statement.executeUpdate();
            isInsert = true;
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isInsert;
    }

    public boolean update(StructureOfGroupDB structureOfGroupDB) {
        boolean isUpdate = false;

	int id = structureOfGroupDB.getGroupId();
	
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE " + StructureOfGroupDB.getGroupTableName() +
                    " SET name = '" + structureOfGroupDB.getGroupName() + "' WHERE id = '" + id + "'");

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
            PreparedStatement statement = connection.prepareStatement("DELETE FROM " + StructureOfGroupDB.getGroupTableName() + " WHERE id = '" + id + "'");
            int result = statement.executeUpdate();
            isDelete = true;
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isDelete;
    }
}
