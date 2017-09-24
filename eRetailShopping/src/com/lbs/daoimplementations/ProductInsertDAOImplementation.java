package com.lbs.daoimplementations;

import java.sql.Array;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;

import com.lbs.daointerfaces.ProductInsertDAO;
import com.lbs.utilities.DatabaseConnectivityUtility;

public class ProductInsertDAOImplementation implements ProductInsertDAO {
	
	
	public boolean insertProductDetails(int customerId,int[] productIds,String[] checkedQuantities) throws ClassNotFoundException, SQLException {
		boolean isInserted = false;
		Connection con = DatabaseConnectivityUtility.getConnection();
        CallableStatement call = con.prepareCall("{call SP_StoreProductInfo(?, ?, ?)}");
        call.setInt(1,customerId);
        call.setString(2,Arrays.toString(productIds));
        call.setString(3, Arrays.toString(checkedQuantities));
        isInserted = call.execute();
       DatabaseConnectivityUtility.closeConnection(con);
       isInserted = true;
       return isInserted;
	}
	
}
