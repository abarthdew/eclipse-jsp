package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.binary.StringUtils;


@WebServlet("/session")
public class Nana extends HttpServlet {
	
	protected void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		// 세션
		HttpSession session = req.getSession();
		
		int v = Integer.parseInt(req.getParameter("v"));
		String button = req.getParameter("button");

		int result = 0;
		
		if (button.equals("=")) { // =이 오면 결과 도출
			int x = (Integer)session.getAttribute("value");
			int y = v;
			String buttonOperator = (String)session.getAttribute("button");
			result = buttonOperator.equals("+") ? x + y : x - y;
			res.getWriter().printf("result is %d\n", result);
		} else { // +, -는 값 저장
			// map 형식으로 저장
			session.setAttribute("value", v);
			session.setAttribute("button", button);
		}
		
		
	}
}
