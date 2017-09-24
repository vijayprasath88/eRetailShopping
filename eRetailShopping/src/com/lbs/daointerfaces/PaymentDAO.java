package com.lbs.daointerfaces;

import java.sql.SQLException;
import java.util.List;

import com.lbs.beans.PaymentForm;

public interface PaymentDAO {

	public abstract double getTotalPayment(int customerId) throws ClassNotFoundException, SQLException;
	public abstract int isPaymentDetailsPresent(PaymentForm payment) throws ClassNotFoundException, SQLException;
	public abstract int insertPaymentDetails(PaymentForm payment) throws ClassNotFoundException, SQLException;
	public abstract PaymentForm getPaymentDetails(PaymentForm payment) throws ClassNotFoundException, SQLException;

}
