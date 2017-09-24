package com.lbs.services;

import java.sql.SQLException;
import java.util.List;

import com.lbs.beans.CategoryForm;
import com.lbs.daoimplementations.CategoryDAOImplementation;
import com.lbs.daointerfaces.CategoryDAO;

public class CategoryService {
	
	public List getAllCategoryDetails() throws ClassNotFoundException, SQLException {
		CategoryDAO catDAO= new CategoryDAOImplementation();
			return (catDAO.getAllCategoryDetails());
	 }

}
