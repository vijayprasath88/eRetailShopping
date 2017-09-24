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
import com.google.gson.Gson;

import com.lbs.services.CategoryService;

//@WebServlet("/CategoryAndProductController")
public class CategoryController extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String json = null;
		CategoryService cps = new CategoryService();

		List categoryList = new ArrayList();
		List productList = new ArrayList();


		try {
			categoryList = cps.getAllCategoryDetails();

		}

		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		 request.setAttribute("categoryList", categoryList);
		 RequestDispatcher rd = request.getRequestDispatcher("/Category.jsp");
		     
	        rd.forward(request, response);
		
		
	}

}
