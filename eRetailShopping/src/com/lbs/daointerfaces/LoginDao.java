package com.lbs.daointerfaces;

import java.sql.SQLException;

import com.lbs.beans.Login;

public interface LoginDao {
	public abstract int matchDetails(Login login)throws ClassNotFoundException,SQLException;
}
