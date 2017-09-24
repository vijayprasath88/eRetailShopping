package com.lbs.services;

import java.sql.SQLException;

import com.lbs.daoimplementations.ProductInsertDAOImplementation;
import com.lbs.daointerfaces.ProductInsertDAO;

public class ProductInsertService {
	
	public boolean insertProductDetails(int customerId, int[] productIds, String[] checkedQuantities) throws ClassNotFoundException, SQLException {
		ProductInsertDAO productInsertDAO= new ProductInsertDAOImplementation();
			return (productInsertDAO.insertProductDetails(customerId,productIds,checkedQuantities));
	 }


}
