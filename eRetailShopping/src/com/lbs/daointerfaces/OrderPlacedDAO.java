package com.lbs.daointerfaces;

import java.sql.SQLException;
import java.util.List;

import com.lbs.beans.OrderPlacedForm;

public interface OrderPlacedDAO {
	
	public abstract List<OrderPlacedForm> getOrderPlacedDetails(OrderPlacedForm orderPlaced) throws ClassNotFoundException, SQLException;
	
	public abstract int orderConfirmed(int customerId) throws ClassNotFoundException, SQLException;

}
