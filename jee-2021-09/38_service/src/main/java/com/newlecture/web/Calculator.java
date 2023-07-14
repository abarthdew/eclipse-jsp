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

    if (req.getMethod().equals("GET")) { // get 요청만 처리(대문자 필수)
      System.out.println("GET 요청이 왔습니다.");
    } else if (req.getMethod().equals("POST")) { // post 요청만 처리
      System.out.println("POST 요청이 왔습니다.");
    }

  }

}
