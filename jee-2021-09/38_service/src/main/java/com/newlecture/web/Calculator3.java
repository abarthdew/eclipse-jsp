package com.newlecture.web;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/service3")
public class Calculator3 extends HttpServlet {

  // super.service(req, res); ���̵� ����

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse res) {
    System.out.println("doGet �޼ҵ尡 ȣ��Ǿ����ϴ�.");
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse res) {
    System.out.println("doPost �޼ҵ尡 ȣ��Ǿ����ϴ�.");
  }

}
