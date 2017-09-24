package com.lbs.controllers;

import com.lbs.beans.Login;
import com.lbs.services.LoginService;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginController extends HttpServlet {
	public void init() {
		// no code
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("username");

		String password = request.getParameter("password");
		// System.out.println(userName);
		int customerId = 0;
		String message = null;
		Login login = new Login();
		login.setemail(userName);
		login.setPassword(password);

		LoginService loginservice = new LoginService();
		// System.out.println(role);
		try {
			customerId = loginservice.LoginDetails(login);

		} catch (ClassNotFoundException ce) {
		} catch (SQLException se) {
		}

		if (customerId == 0) {
			message = "You are not registered with eRetail. Kindly Register";
			request.setAttribute("message", message);
			RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
			rd.forward(request, response);
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("customerId", customerId);
			session.setAttribute("userName", userName);
			response.sendRedirect("category");
			//RequestDispatcher rd = request.getRequestDispatcher("/category");
			//rd.forward(request, response);
		}
		
		

		/*
		if (role.equalsIgnoreCase("OTH")) {
			// out.println("");
			HttpSession session = request.getSession();
			session.setAttribute("userName", userName);

			RequestDispatcher rd = request.getRequestDispatcher("OTH.jsp");
			rd.forward(request, response);

		}

		if (role.equalsIgnoreCase("LO")) {
			HttpSession session = request.getSession();
			session.setAttribute("userName", userName);

			RequestDispatcher rd = request.getRequestDispatcher("LO.jsp");
			rd.forward(request, response);
		}

		if (role.equalsIgnoreCase("OTM")) {
			HttpSession session = request.getSession();
			session.setAttribute("userName", userName);

			RequestDispatcher rd = request.getRequestDispatcher("OTM.jsp");
			rd.forward(request, response);
		}

		if (role.equalsIgnoreCase("invalid")) {

			RequestDispatcher rd = request.getRequestDispatcher("invalid.jsp");
			rd.forward(request, response);

		}
	}*/

 }
	public void destory() {
		// no code
	}
}
