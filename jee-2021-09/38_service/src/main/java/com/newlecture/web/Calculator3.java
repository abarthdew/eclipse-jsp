package com.newlecture.web;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/service3")
public class Calculator3 extends HttpServlet {

  // super.service(req, res); 없이도 가능

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse res) {
    System.out.println("doGet 메소드가 호출되었습니다.");
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse res) {
    System.out.println("doPost 메소드가 호출되었습니다.");
  }

}
