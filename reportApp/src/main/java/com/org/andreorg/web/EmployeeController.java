package com.org.andreorg.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.org.andreorg.web.dao.EmployeeDao;
import com.org.andreorg.web.model.Employee;

/**
 * Servlet implementation class EmployeeController
 */
public class EmployeeController extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		int empId = Integer.parseInt(request.getParameter("empId"));
	
		RequestDispatcher rd = request.getRequestDispatcher("showEmployee.jsp");
		rd.forward(request, response);
		
	}
}
