package com.newlecture.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/el-cal")
public class Nana extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		int num = 0;
		String result = "";
		String num_ = request.getParameter("num");
		if (num_ != null && !num_.equals("")) {
			num = Integer.parseInt(num_);
		}
		result = num%2 == 0 ? "Â¦¼ö" : "È¦¼ö";
		
		request.setAttribute("result", result); 
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp"); 
		dispatcher.forward(request, response);
	}
	
}
