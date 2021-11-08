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


@WebServlet("/calc2")
public class Nana extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
Cookie[] cookies = req.getCookies();
		
		String exp = "0";
		if (cookies != null) {
			for (Cookie c : cookies) {
				if (c.getName().equals("exp")) {
					exp = c.getValue();
					break;
				}
			}
		}
		
		PrintWriter out = res.getWriter();
		
		out.write("<!DOCTYPE html>");
		out.write("<html>");
		out.write("		<head>");
		out.write("		<meta charset=\"UTF-8\">");
		out.write("		<title>Insert title here</title>");
		out.write("		<style>");
		out.write("			input {width:50px; height:50px;}");
		out.write("		</style>");
		out.write("		</head>");
		out.write("		<body>");
		out.write("			<form method=\"post\">"); // 자기페이지기 때문에 action=\"calc\" 생략 
		out.write("		<div>");
		out.write("			<table>");
		out.write("				<tr>");
		out.printf("					<td colspan=\"4\">%s</td>", exp);
		out.write("				</tr>");
		out.write("				<tr>");
		out.write("					<td><input type=\"submit\" name=\"button\" value=\"CE\"></td>");
		out.write("					<td><input type=\"submit\" name=\"button\" value=\"C\"></td>");
		out.write("					<td><input type=\"submit\" name=\"button\" value=\"<-\"></td>");
		out.write("					<td><input type=\"submit\" name=\"button\" value=\"/\"></td>");
		out.write("				</tr>");
		out.write("				<tr>");
		out.write("					<td><input type=\"submit\" name=\"value\" value=\"7\"></td>");
		out.write("					<td><input type=\"submit\" name=\"value\" value=\"8\"></td>");
		out.write("					<td><input type=\"submit\" name=\"value\" value=\"9\"></td>");
		out.write("					<td><input type=\"submit\" name=\"button\" value=\"*\"></td>");
		out.write("				</tr>");
		out.write("				<tr>");
		out.write("					<td><input type=\"submit\" name=\"value\" value=\"4\"></td>");
		out.write("					<td><input type=\"submit\" name=\"value\" value=\"5\"></td>");
		out.write("					<td><input type=\"submit\" name=\"value\" value=\"6\"></td>");
		out.write("					<td><input type=\"submit\" name=\"button\" value=\"-\"></td>");
		out.write("				</tr>");
		out.write("				<tr>");
		out.write("					<td><input type=\"submit\" name=\"value\" value=\"1\"></td>");
		out.write("					<td><input type=\"submit\" name=\"value\" value=\"2\"></td>");
		out.write("					<td><input type=\"submit\" name=\"value\" value=\"3\"></td>");
		out.write("					<td><input type=\"submit\" name=\"button\" value=\"+\"></td>");
		out.write("				</tr>");
		out.write("				<tr>");
		out.write("					<td></td>");
		out.write("					<td><input type=\"submit\" name=\"value\" value=\"0\"></td>");
		out.write("					<td><input type=\"submit\" name=\"dot\" value=\".\"></td>");
		out.write("					<td><input type=\"submit\" name=\"button\" value=\"=\"></td>");
		out.write("				</tr>");
		out.write("			</table>");
		out.write("		</div>");
		out.write("	</form>");
		out.write("</body>");
		out.write("</html>");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
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
		expCookie.setPath("/calc2");
		res.addCookie(expCookie);
		
		res.sendRedirect("calc2"); // 자기 자신 호출
	}
}
