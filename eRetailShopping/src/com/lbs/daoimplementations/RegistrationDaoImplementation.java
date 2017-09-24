package com.lbs.daoimplementations;

import java.sql.Connection;
import java.sql.Timestamp;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lbs.beans.Registration;
import com.lbs.daointerfaces.RegistrationDao;
import com.lbs.utilities.*;

public class RegistrationDaoImplementation implements RegistrationDao {
	Connection con = null;
	ResultSet rs = null;

	public int insertDetails(Registration register) {
		int status = 0;
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		try {

			con = DatabaseConnectivityUtility.getConnection();
			System.out.println(con == null);
			PreparedStatement pst = con.prepareStatement("select * from Customer_Login where Customer_Email=?");
			pst.setString(1, register.getEmail());
			rs = pst.executeQuery();
			if (rs.next()) {
				status = 0;
			} else {
				status = 1;
			}
			if (status == 1) {

				PreparedStatement ps = con.prepareStatement("insert into Customer_Login values(?,?,?,?)");

				ps.setString(1, register.getEmail());
				ps.setString(2, register.getPassword());
				ps.setString(3, "A");
				ps.setTimestamp(4, timestamp);
				int stat = ps.executeUpdate();

			}

		} catch (Exception e) {
			e.printStackTrace();

		}

		return status;
	}

	@Override
	public String matchDetails(Registration registration) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}
}
