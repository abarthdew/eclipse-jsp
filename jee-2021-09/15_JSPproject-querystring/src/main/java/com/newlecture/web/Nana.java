package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/querystring")
public class Nana extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = res.getWriter();
		
		int cnt = Integer.parseInt(req.getParameter("cnt"));
		// req.getParameter("cnt")�� ������ ���ڿ��� ���޵�
		
		for (int i=0; i<cnt; i++) {
			out.println(i + " : �ȳ� Servlet !! </br>");
		}
	}
}
