package com.newlecture.web.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/notice/detail")
public class NoticeDetailController extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    // 홈 디렉토리는 Webapp
    request.getRequestDispatcher("/WEB-INF/view/notice/detail.jsp").forward(request, response);

  }

}
