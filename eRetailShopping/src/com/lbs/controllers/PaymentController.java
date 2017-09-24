package com.lbs.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lbs.beans.PaymentForm;
import com.lbs.services.PaymentService;


@WebServlet("/Payment")
public class PaymentController extends HttpServlet {
	
	public void doPost( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		PaymentForm payment = new PaymentForm();
		int isPaymentPresent = 0;
		int isInserted = 0;
		double totalPayment = 0;
		String accountNo = null;
		int cvv = 0;
		String nameOnCard = null;
		int month = 0;
		int year = 0;
		int firstInsert = 0;
		int nextPage = 0;
		
		List paymentList  = new ArrayList();
		PaymentService payService = new PaymentService();
		HttpSession session = request.getSession();
		int customerId = (int) session.getAttribute("customerId");
		if(request.getParameter("isInsert") != null && !request.getParameter("isInsert").equals("")){
			firstInsert = Integer.parseInt(request.getParameter("isInsert"));
		}
		if(request.getParameter("nextPage") != null && !request.getParameter("nextPage").equals("")){
			nextPage = Integer.parseInt(request.getParameter("nextPage"));
		}
		if(request.getParameter("AccountNo") != null && !request.getParameter("AccountNo").equals(""))
		{
			accountNo = request.getParameter("AccountNo").trim();
			payment.setAccountNo(accountNo);
		}
		
		if(request.getParameter("CVV") != null && !request.getParameter("CVV").equals(""))
		{
			cvv  =Integer.parseInt(request.getParameter("CVV").trim());
			payment.setCcv(cvv);
		}
		
		if(request.getParameter("NameOnCard") != null && !request.getParameter("NameOnCard").equals(""))
		{
			nameOnCard = request.getParameter("NameOnCard").trim();
			payment.setNameOnCard(nameOnCard);
		}
		if(request.getParameter("Month") != null && !request.getParameter("Month").equals(""))
		{
			month = Integer.parseInt(request.getParameter("Month").trim());
			payment.setMonth(month);
		}
		if(request.getParameter("Year") != null && !request.getParameter("Year").equals(""))
		{
			year = Integer.parseInt(request.getParameter("Year").trim());
			payment.setYear(year);
		}
		
		payment.setCustomerId(customerId);
		try {
			if(firstInsert == 0){
			isPaymentPresent = payService.isPaymentDetailsPresent(payment);
			}
			if(isPaymentPresent == 1){
				payment = (PaymentForm) payService.getPaymentDetails(payment);
				firstInsert = 1;
			}else if(isPaymentPresent == 0 && firstInsert==1){
				
				payment.setCustomerId(customerId);
				payment.setAccountNo(accountNo);
				payment.setCcv(cvv);
				payment.setNameOnCard(nameOnCard);
				payment.setMonth(month);
				payment.setYear(year);
				
				isInserted = payService.insertPaymentDetails(payment);
		
			}
			
			 totalPayment = payService.getTotalPayment(customerId);
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
				
		if(nextPage==2){
			//go to order place page
			RequestDispatcher rd = request.getRequestDispatcher("/placeOrder");
			rd.forward(request, response);	
			
		}else if(isInserted == 0 && firstInsert==1){
			
				request.setAttribute("AccountNo", payment.getAccountNo());
				request.setAttribute("NameOnCard", payment.getNameOnCard());
				request.setAttribute("CVV",payment.getCcv() );
				request.setAttribute("Month",payment.getMonth());
				request.setAttribute("Year", payment.getYear());
				request.setAttribute("nextPage", "2");
				
			request.setAttribute("totalPayment", totalPayment);
			
			 request.setAttribute("paymentDetails", paymentList);
		     
			    RequestDispatcher rd = request.getRequestDispatcher("Payment.jsp");
			     
		        rd.forward(request, response);	
		}else{
			request.setAttribute("AccountNo","");
			request.setAttribute("NameOnCard","");
			request.setAttribute("CVV","");
			request.setAttribute("Month","");
			request.setAttribute("Year","");
			request.setAttribute("totalPayment", totalPayment);
			request.setAttribute("nextPage", "2");
			 RequestDispatcher rd = request.getRequestDispatcher("Payment.jsp");
		     
		        rd.forward(request, response);	
			
		}
		
	}
	

}
