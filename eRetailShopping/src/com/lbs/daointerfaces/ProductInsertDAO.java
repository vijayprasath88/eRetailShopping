package com.lbs.daointerfaces;

import java.sql.SQLException;

public interface ProductInsertDAO {
	
	public abstract boolean insertProductDetails(int customerId,int[] productIds, String[] checkedQuantities) throws ClassNotFoundException, SQLException;
}
