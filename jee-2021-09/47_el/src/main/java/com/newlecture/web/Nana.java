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

@WebServlet("/el")
public class Nana extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num = 0;
		String result = "";
		String num_ = request.getParameter("num");
		if (num_ != null && !num_.equals("")) {
			num = Integer.parseInt(num_);
		}
		result = num%2 == 0 ? "¦��" : "Ȧ��";
		
		request.setAttribute("result", result); 
		
		// �迭 �����
		String[] names = {"newLec", "dragon", "lux"};
		request.setAttribute("names", names);
		
		// map �����
		Map<String, Object> notice = new HashMap();
		notice.put("id", 1);
		notice.put("title", "���ƿ�");
		request.setAttribute("notice", notice);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp"); 
		dispatcher.forward(request, response);
	}
	
}
