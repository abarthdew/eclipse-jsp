package com.newlecture.web;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/post")
public class Nana extends HttpServlet {

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
    res.setCharacterEncoding("UTF-8");
    res.setContentType("text/html; charset=UTF-8");

    PrintWriter out = res.getWriter();

    String title = req.getParameter("title");
    String content = req.getParameter("content");

    out.println(title);
    out.println(content);

  }
}
