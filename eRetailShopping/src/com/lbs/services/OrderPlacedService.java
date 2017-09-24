package com.lbs.services;

import java.sql.SQLException;
import java.util.List;

import com.lbs.beans.OrderPlacedForm;
import com.lbs.daoimplementations.OrderPlacedDAOImplementation;
import com.lbs.daointerfaces.OrderPlacedDAO;

public class OrderPlacedService {
	
	public List<OrderPlacedForm> getOrderPlacedDetails(OrderPlacedForm orderPlaced) throws ClassNotFoundException, SQLException{
		OrderPlacedDAO orderPlacedDAO = new OrderPlacedDAOImplementation();
		return orderPlacedDAO.getOrderPlacedDetails(orderPlaced);
	}
	
	public int orderConfirmed(int customerId) throws ClassNotFoundException, SQLException{
		OrderPlacedDAO orderPlacedDAO = new OrderPlacedDAOImplementation();
		return orderPlacedDAO.orderConfirmed(customerId);
	}

}
