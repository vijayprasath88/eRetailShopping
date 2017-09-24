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

import com.lbs.beans.OrderPlacedForm;
import com.lbs.services.OrderPlacedService;

//@WebServlet("/orderPlaced")
public class OrderPlacedController extends HttpServlet {
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		OrderPlacedService orderPlacedService = new OrderPlacedService();
		OrderPlacedForm orderPlacedForm = new OrderPlacedForm();
		List orderPlacedList = new ArrayList();
		HttpSession session = request.getSession();
		int customerId = (int) session.getAttribute("customerId");
		int isUpdated = 0;
		
		
		try {
			//orderPlacedList = orderPlacedService.getOrderPlacedDetails(orderPlacedForm);
		isUpdated=	orderPlacedService.orderConfirmed(customerId);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("orderPlacedList", orderPlacedList);
		RequestDispatcher rd = request.getRequestDispatcher("orderPlaced.jsp");
		rd.forward(request, response);	
		
	}

}
