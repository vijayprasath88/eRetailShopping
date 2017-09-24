package com.lbs.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lbs.services.ProductInsertService;

public class ProductInsertController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean isInserted = false;
		int customerId = 0;
		String[] checkedProducts = null;
		String[] checkedQuantities = null;
		int[] productIds;
		int[] totalQuantities;

		ProductInsertService productInsertService = new ProductInsertService();

		if (request.getParameterValues("totalQuantites") != null) {
			checkedQuantities = (request.getParameterValues("totalQuantites"));
		}

		if (request.getParameterValues("checkedProducts") != null) {
			checkedProducts = (request.getParameterValues("checkedProducts"));
		}
		HttpSession session = request.getSession();
		if (session.getAttribute("customerId") != null) {
			customerId = (int) session.getAttribute("customerId");
		}

		productIds = new int[checkedProducts.length];
		//totalQuantities = new int[checkedQuantities.length];

		for (int j = 0; j < productIds.length; j++) {
			productIds[j] = Integer.parseInt(checkedProducts[j]);
		}

		try {
			isInserted = productInsertService.insertProductDetails(customerId, productIds, checkedQuantities);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		if (isInserted) {
			RequestDispatcher rd = request.getRequestDispatcher("/payment");
			rd.forward(request, response);

		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/product");
			rd.forward(request, response);
		}

	}

}
