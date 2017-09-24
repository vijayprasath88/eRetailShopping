package com.lbs.daointerfaces;

import java.sql.SQLException;
import java.util.List;

import com.lbs.beans.CategoryForm;

public interface CategoryDAO {
	
	public abstract List getAllCategoryDetails() throws ClassNotFoundException,SQLException;
}
