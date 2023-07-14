package com.newlecture.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/service")
public class Calculator extends HttpServlet {

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

    if (req.getMethod().equals("GET")) { // get ��û�� ó��(�빮�� �ʼ�)
      System.out.println("GET ��û�� �Խ��ϴ�.");
    } else if (req.getMethod().equals("POST")) { // post ��û�� ó��
      System.out.println("POST ��û�� �Խ��ϴ�.");
    }

  }

}
