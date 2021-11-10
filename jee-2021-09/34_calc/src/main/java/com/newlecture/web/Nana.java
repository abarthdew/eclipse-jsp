package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.binary.StringUtils;


@WebServlet("/calc")
public class Nana extends HttpServlet {
	
	protected void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
				
		Cookie[] cookies = req.getCookies();
		
		String value = req.getParameter("value");
		String button = req.getParameter("button");
		String dot = req.getParameter("dot");
		
		String exp = "";
		if (cookies != null) {
			for (Cookie c : cookies) {
				if (c.getName().equals("exp")) {
					exp = c.getValue();
					break;
				}
			}
		}
		
		if (button != null && button.equals("=")) {
			ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
			try {
				exp = String.valueOf(engine.eval(exp));
			} catch (ScriptException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (button != null && button.equals("C")) { // 쿠키 초기화
			exp = "";
		} else {
			exp += (value == null) ? "" : value;
			exp += (button == null) ? "" : button;
			exp += (dot == null) ? "" : dot;
		}
		
		Cookie expCookie = new Cookie("exp", exp);
		if (button != null && button.equals("C")) { // 쿠키 삭제
			expCookie.setMaxAge(0);
		}
		res.addCookie(expCookie);
		
		res.sendRedirect("calcPage"); // Nana, Nana2 경로가 같기 때문에 /calcPage라고 안 써도 됨
		
	}
}
