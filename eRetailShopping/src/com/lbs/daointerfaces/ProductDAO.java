package com.lbs.daointerfaces;

import java.sql.SQLException;
import java.util.List;

import com.lbs.beans.ProductForm;

public interface ProductDAO {
	
	public abstract List<ProductForm> getAllProductDetails(ProductForm productForm) throws ClassNotFoundException,SQLException;

}
