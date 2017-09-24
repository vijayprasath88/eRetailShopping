package com.lbs.daoimplementations;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.lbs.beans.CategoryForm;
import com.lbs.daointerfaces.CategoryDAO;
import com.lbs.utilities.DatabaseConnectivityUtility;

public class CategoryDAOImplementation implements CategoryDAO {
	
	public List getAllCategoryDetails() throws ClassNotFoundException, SQLException {
         List<CategoryForm> catList = new ArrayList<CategoryForm>();
        Connection con = DatabaseConnectivityUtility.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from Category");
        CategoryForm category = null;
         while(rs.next()){
        	 category = new CategoryForm();
        	 category.setCategoryId(rs.getInt("Category_Id"));
        	 category.setCategoryName(rs.getString("Category_Name"));
            catList.add(category);
        }
          DatabaseConnectivityUtility.closeConnection(con);
         
        return catList;
    }

}
