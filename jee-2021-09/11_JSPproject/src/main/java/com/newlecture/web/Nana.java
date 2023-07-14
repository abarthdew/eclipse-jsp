package com.newlecture.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Nana extends HttpServlet {

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
    PrintWriter out = res.getWriter();
    out.print("Hello");
  }
}
