package com.newlecture.web;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/calc")
public class Nana extends HttpServlet {

  protected void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
    res.setCharacterEncoding("UTF-8");
    res.setContentType("text/html; charset=UTF-8");

    String x_ = req.getParameter("x");
    String y_ = req.getParameter("y");
    String button = req.getParameter("button");

    int x = x_ != null && !x_.equals("") ? Integer.parseInt(x_) : 0;
    int y = y_ != null && !y_.equals("") ? Integer.parseInt(y_) : 0;

    int result = button.equals("add") ? x + y : x - y;

    res.getWriter().printf("result is %d\n", result);

  }
}
