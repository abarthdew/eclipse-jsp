package com.newlecture.web.controller;

import com.newlecture.web.entity.NoticeView;
import com.newlecture.web.service.NoticeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/notice/list")
public class NoticeListController extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    // 검색
    String field = request.getParameter("f") != null && !request.getParameter("f").equals("") ? request.getParameter("f") : "title"; // select option
    String query = request.getParameter("q") != null && !request.getParameter("q").equals("") ? request.getParameter("q") : ""; // 검색어

    // 페이지
    int page = request.getParameter("p") != null && !request.getParameter("p").equals("") ? Integer.parseInt(request.getParameter("p")) : 1;

    NoticeService service = new NoticeService();
    List<NoticeView> list = service.getNoticeList(field, query, page);

    // 검색된 글의 카운트
    int count = service.getNoticeCount(field, query);

    request.setAttribute("list", list);
    request.setAttribute("count", count);

    request.getRequestDispatcher("/WEB-INF/view/notice/list.jsp").forward(request, response);
  }
}
