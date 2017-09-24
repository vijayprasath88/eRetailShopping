package com.lbs.daoimplementations;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import com.lbs.beans.ProductForm;
import com.lbs.daointerfaces.ProductDAO;
import com.lbs.utilities.DatabaseConnectivityUtility;

public class ProductDAOImplementation implements ProductDAO {
	
	public List<ProductForm> getAllProductDetails(ProductForm productForm) throws ClassNotFoundException, SQLException {
        List<ProductForm> productList = new ArrayList<ProductForm>();
       Connection con = DatabaseConnectivityUtility.getConnection();
       PreparedStatement pstmt = con.prepareStatement("select * From Product_Details where Category_Id = ?");
       pstmt.setInt(1, productForm.getCategoryId());
     ResultSet rs =   pstmt.executeQuery();
       ProductForm product = null;
        while(rs.next()){
        	product = new ProductForm();
        	product.setProductId(rs.getInt("Product_Id"));
        	product.setProductName(rs.getString("Product_Name"));
       	 	product.setCategoryId(rs.getInt("Category_Id"));
       	 	product.setPrice(rs.getLong("Price"));
        	productList.add(product);
       }
         DatabaseConnectivityUtility.closeConnection(con);
        
       return productList;
   }

}
