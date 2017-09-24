package com.lbs.daoimplementations;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lbs.beans.PaymentForm;
import com.lbs.daointerfaces.PaymentDAO;
import com.lbs.utilities.DatabaseConnectivityUtility;

public class PaymentDAOImplementation implements PaymentDAO {

	@Override
	public double getTotalPayment(int customerId) throws ClassNotFoundException, SQLException {
		double totalPayment = 0;
		Connection con = DatabaseConnectivityUtility.getConnection();
		CallableStatement cstmt = con.prepareCall("{call SP_GetTotalPayment(?)}");
		cstmt.setInt(1, customerId);
		ResultSet rs = cstmt.executeQuery();
		while(rs.next()){
			totalPayment = rs.getInt(1);
		}
		return totalPayment;
	}
	
	@Override
	public int isPaymentDetailsPresent(PaymentForm payment) throws ClassNotFoundException, SQLException {
		int isPaymentThere = 0;
		Connection con = DatabaseConnectivityUtility.getConnection();
		PreparedStatement pstmt = con.prepareStatement("select * from Customer_Payment where Customer_Id = ?");
		pstmt.setInt(1, payment.getCustomerId());
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			isPaymentThere = 1;
		} else {
			isPaymentThere = 0;
		}
		return isPaymentThere;
	}

	@Override
	public int insertPaymentDetails(PaymentForm payment) throws ClassNotFoundException, SQLException {
		int insertStatus = 0;
		Connection con = DatabaseConnectivityUtility.getConnection();
		CallableStatement pstmt = con.prepareCall("{call SP_Insert_Payment_Info(?,?,?,?,?,?)}");
		pstmt.setInt(1, payment.getCustomerId());
		pstmt.setString(2,payment.getAccountNo());
		pstmt.setInt(3,payment.getCcv());
		pstmt.setString(4, payment.getNameOnCard());
		pstmt.setInt(5, payment.getMonth());
		pstmt.setInt(6, payment.getYear());
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			insertStatus =rs.getInt(1);
		}
		return insertStatus;
	}

	public PaymentForm getPaymentDetails(PaymentForm payment) throws ClassNotFoundException, SQLException {
		//List<PaymentForm> paymentList = new ArrayList<PaymentForm>();
		Connection con = DatabaseConnectivityUtility.getConnection();
		PreparedStatement pstmt = con.prepareStatement("select * from Customer_Payment where Customer_Id = ?");
		pstmt.setInt(1, payment.getCustomerId());
		ResultSet rs = pstmt.executeQuery();
		PaymentForm paymentObj = null;
		while (rs.next()) {
			paymentObj = new PaymentForm();
			paymentObj.setCustomerId(rs.getInt("Customer_Id"));
			paymentObj.setAccountNo(rs.getString("Account_Number"));
			paymentObj.setCcv(rs.getInt("CVV"));
			paymentObj.setNameOnCard(rs.getString("Name_On_Card"));
			paymentObj.setMonth(rs.getInt("Month"));
			paymentObj.setYear(rs.getInt("Year"));
			//paymentList.add(paymentObj);
		}

		return paymentObj;

	}

}
