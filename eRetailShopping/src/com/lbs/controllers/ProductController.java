package com.lbs.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lbs.beans.ProductForm;
import com.lbs.services.ProductService;

public class ProductController extends HttpServlet {
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		int categoryId = Integer.parseInt(request.getParameter("category"));
		ProductForm productForm = new ProductForm();
		ProductService productService = new ProductService();
		List productList = new ArrayList();
		
		try {
			productForm.setCategoryId(categoryId);
			productList = productService.getAllProductDetails(productForm);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		 request.setAttribute("productList", productList);
	     
		    RequestDispatcher rd = request.getRequestDispatcher("product.jsp");
		     
	        rd.forward(request, response);
		
	}
	}
