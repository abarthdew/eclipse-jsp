package com.newlecture.web;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/querystring2")
public class Nana2 extends HttpServlet {

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
    res.setCharacterEncoding("UTF-8");
    res.setContentType("text/html; charset=UTF-8");

    PrintWriter out = res.getWriter();

    String cntString = req.getParameter("cnt");
    int cnt = 100;
    if (cntString != null && !cntString.equals("")) {
      cnt = Integer.parseInt(cntString);
    }
    for (int i = 0; i < cnt; i++) {
      out.println(i + " : �ȳ� Servlet !! </br>");
    }
  }
}
