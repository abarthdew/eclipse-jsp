package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/post2")
public class Nana2 extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = res.getWriter();
		
		req.setCharacterEncoding("UTF-8"); // 입력받기 전에 설정
		
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		out.println(title);
		out.println(content);
		
	}
}
