package com.newlecture.web;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/querystring")
public class Nana extends HttpServlet {

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
    res.setCharacterEncoding("UTF-8");
    res.setContentType("text/html; charset=UTF-8");

    PrintWriter out = res.getWriter();

    int cnt = Integer.parseInt(req.getParameter("cnt"));
    // req.getParameter("cnt")는 무조건 문자열로 전달됨

    for (int i = 0; i < cnt; i++) {
      out.println(i + " : 안녕 Servlet !! </br>");
    }
  }
}
