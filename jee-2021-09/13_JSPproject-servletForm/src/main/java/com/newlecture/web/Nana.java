package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/form")
public class Nana extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
		PrintWriter out = res.getWriter();
		for (int i=0; i<100; i++) {
//			out.println(i + " : Hello Servlet !!");
			out.println(i + " : Hello Servlet !! </br>");
		}
	}
}
