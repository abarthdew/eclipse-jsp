package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.binary.StringUtils;


@WebServlet("/cookie-path")
public class Nana extends HttpServlet {
	
	protected void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
//		System.out.println(req.getSession());
				
		Cookie[] cookies = req.getCookies();
		for (Cookie s : cookies) {
			System.out.println("cookie : " + s.getName() + " : " + s.getValue());
		}
		
		int v = Integer.parseInt(req.getParameter("v"));
		String button = req.getParameter("button");

		int result = 0;
		
		if (button.equals("=")) {
			// ��Ű �迭�� ���鼭 ã��
			int x = 0;
			for(Cookie c : cookies) {
				if (c.getName().equals("value")) {
					x = Integer.parseInt(c.getValue());	
					break;
				}
			}
			int y = v;
			// ��Ű �迭�� ���鼭 ã��
			String buttonOperator = "";
			for(Cookie c : cookies) {
				if (c.getName().equals("button")) {
					buttonOperator = c.getValue();	
					break;
				}
			}
			result = buttonOperator.equals("+") ? x + y : x - y;
			res.getWriter().printf("result is %d\n", result);
		} else {
			Cookie valueCookie = new Cookie("value", String.valueOf(v)); // url�� ����� �� �ִ� ���� ���·� �����ؾ� ��
			Cookie buttonCookie = new Cookie("button", button);
			
			valueCookie.setPath("/add"); // ��� ���������� valueCookie�� �����´�
			buttonCookie.setPath("/add"); // /add�� ���Ե� ���������� valueCookie�� �����´�
			
			res.addCookie(valueCookie);
			res.addCookie(buttonCookie);
		}
		
	}
}
