package com.newlecture.web.controller.notice;

import com.newlecture.web.entity.Notice;
import com.newlecture.web.service.NoticeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/notice/detail")
public class DetailController extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    int id = Integer.parseInt(request.getParameter("id"));

    NoticeService service = new NoticeService();
    Notice notice = service.getNotice(id);
    request.setAttribute("notice", notice);

    // forward
    request.getRequestDispatcher("/WEB-INF/view/notice/detail.jsp").forward(request, response);

  }

}
