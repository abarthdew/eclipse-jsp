package com.newlecture.web;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/calcPage")
public class Nana2 extends HttpServlet {

  protected void service(HttpServletRequest req, HttpServletResponse res) throws IOException {

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
    out.write("			<form action=\"calc\" method=\"post\">");
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
}
