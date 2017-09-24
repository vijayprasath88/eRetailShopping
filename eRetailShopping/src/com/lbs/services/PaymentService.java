package com.lbs.services;

import java.sql.SQLException;
import java.util.List;

import com.lbs.beans.PaymentForm;
import com.lbs.daoimplementations.PaymentDAOImplementation;
import com.lbs.daointerfaces.PaymentDAO;

public class PaymentService {
	
	public double getTotalPayment(int customerId) throws ClassNotFoundException, SQLException {
		PaymentDAO paymentdao = new PaymentDAOImplementation();

		return paymentdao.getTotalPayment(customerId);
	}

	public int isPaymentDetailsPresent(PaymentForm payment) throws ClassNotFoundException, SQLException {
		PaymentDAO paymentdao = new PaymentDAOImplementation();

		return paymentdao.isPaymentDetailsPresent(payment);
	}

	public int insertPaymentDetails(PaymentForm payment) throws ClassNotFoundException, SQLException {
		PaymentDAO paymentdao = new PaymentDAOImplementation();

		return paymentdao.insertPaymentDetails(payment);
	}

	public PaymentForm getPaymentDetails(PaymentForm payment) throws ClassNotFoundException, SQLException {
		PaymentDAO paymentdao = new PaymentDAOImplementation();

		return paymentdao.getPaymentDetails(payment);
	}
	
	
}
