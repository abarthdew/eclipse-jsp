package com.newlecture.web.controller.admin.notice;

import com.newlecture.web.entity.NoticeView;
import com.newlecture.web.service.NoticeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin/board/notice/list")
public class ListController extends HttpServlet {
  // 404 : url이 없어 발생하는 오류(url 오류)
  // 405 : url은 있는데 그 안에 받을 수 있는 메서드가 없는 경우(메서드 오류)
  // 403 : url, 메서드는 있는데 권한이 없는 경우(보안 오류)

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String[] openIds = request.getParameterValues("open-id");
    String[] delIds = request.getParameterValues("del-id");

    String cmd = request.getParameter("cmd");

    switch (cmd) {
      case "all-open":
        for (String openId : openIds) System.out.printf("open ID : %s\n", openId);
        break;
      case "all-del":
        NoticeService service = new NoticeService();
        int[] ids = new int[delIds.length];
        for (int i = 0; i < delIds.length; i++) {
          ids[i] = Integer.parseInt(delIds[i]);
        }
        int result = service.removeNoticeAll(ids);
        break;
    }

    response.sendRedirect("list");
  }

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

    request.getRequestDispatcher("/WEB-INF/view/admin/board/notice/list.jsp").forward(request, response);
  }
}
