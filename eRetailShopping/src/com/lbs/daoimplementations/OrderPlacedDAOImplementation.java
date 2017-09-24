package com.lbs.daoimplementations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lbs.beans.OrderPlacedForm;
import com.lbs.daointerfaces.OrderPlacedDAO;
import com.lbs.utilities.DatabaseConnectivityUtility;

public class OrderPlacedDAOImplementation implements OrderPlacedDAO{
	
	public List<OrderPlacedForm> getOrderPlacedDetails(OrderPlacedForm orderPlaced) throws ClassNotFoundException, SQLException {
		List<OrderPlacedForm> orderPlacedList = new ArrayList<OrderPlacedForm>();
		Connection con = DatabaseConnectivityUtility.getConnection();
		PreparedStatement pstmt = con.prepareStatement("select * from Order_Placed where Customer_Id = ?");
		pstmt.setInt(1, orderPlaced.getCustomerId());
		ResultSet rs = pstmt.executeQuery();
		OrderPlacedForm orderPlacedObj = null;
		while (rs.next()) {
			orderPlacedObj = new OrderPlacedForm();
			orderPlacedObj.setOrderId(rs.getInt("Order_Id"));
			orderPlacedObj.setCustomerId(rs.getInt("Customer_Id"));
			orderPlacedObj.setProductId(rs.getInt("Product_Id"));
			orderPlacedObj.setOrderDate(rs.getString("Order_Date"));
			orderPlacedObj.setOrderAmount(rs.getLong("Order_Amount"));
			orderPlacedObj.setOrderConfirmed(rs.getString("Order_Confirmed"));
			orderPlacedList.add(orderPlacedObj);
		}

		return orderPlacedList;

	}
	
	public int orderConfirmed(int customerId) throws ClassNotFoundException, SQLException {
		int isInserted = 0;
		Connection con = DatabaseConnectivityUtility.getConnection();
		PreparedStatement pstmt = con.prepareStatement("UPDATE Order_Placed SET Order_Confirmed = 'Y' WHERE Customer_Id = ? ");
		pstmt.setInt(1, customerId);
		isInserted = pstmt.executeUpdate();
		
		return isInserted;

	}

}
	