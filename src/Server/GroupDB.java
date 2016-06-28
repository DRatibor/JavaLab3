package Server;

import java.sql.*;
import java.util.ArrayList;

import SharedTypes.StructureOfGroupDB;

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
            	StructureOfGroupDB group = new StructureOfGroupDB();
            	group.setGroupId(res.getInt("id"));
            	group.setGroupName(res.getString("groupName"));
            	group.setGroupDescription(res.getString("groupDescription"));

                groupList.add(group);
            }
            statement.close();
            res.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return groupList;
    }    
     
    public boolean add(StructureOfGroupDB structureOfGroupDB) {
        boolean isInsert = false;

        try {
            PreparedStatement statement = connection.prepareStatement(
            		"INSERT INTO " + StructureOfGroupDB.getGroupTableName() 
            		+ " (groupName, groupDescription) VALUES (?, ?)");

            statement.setString(1, structureOfGroupDB.getGroupName());
            statement.setString(2, structureOfGroupDB.getGroupDescription());

            int result = statement.executeUpdate();
            isInsert = true;
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isInsert;
    }

    public boolean update(StructureOfGroupDB groupToUpdate) {
        boolean isUpdate = false;

	    try {
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE " + StructureOfGroupDB.getGroupTableName()
                    + " SET groupName = '" + groupToUpdate.getGroupName() + "'"
                    + ", groupDescription = '" + groupToUpdate.getGroupDescription() + "'"
                    + " WHERE name = '" + groupToUpdate.getGroupName() + "'");

            int result = statement.executeUpdate();
            isUpdate = true;
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isUpdate;
    }
    
    public boolean delete(StructureOfGroupDB groupToDelete) {
        boolean isDelete = false;

        try {
            PreparedStatement statement = connection.prepareStatement(
            		"DELETE FROM " + StructureOfGroupDB.getGroupTableName() 
            		+ " WHERE groupName = '" + groupToDelete.getGroupName() + "'");
            int result = statement.executeUpdate();
            isDelete = true;
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isDelete;
    }
}
