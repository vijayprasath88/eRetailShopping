package com.lbs.services;

import java.sql.SQLException;
import java.util.List;

import com.lbs.beans.ProductForm;
import com.lbs.daoimplementations.ProductDAOImplementation;
import com.lbs.daointerfaces.ProductDAO;

public class ProductService {
	
	public List<ProductForm> getAllProductDetails(ProductForm productForm) throws ClassNotFoundException, SQLException {
		ProductDAO productDAO= new ProductDAOImplementation();
			return (productDAO.getAllProductDetails(productForm));
	 }

}
