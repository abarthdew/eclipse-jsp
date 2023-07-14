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
  // 404 : url�� ���� �߻��ϴ� ����(url ����)
  // 405 : url�� �ִµ� �� �ȿ� ���� �� �ִ� �޼��尡 ���� ���(�޼��� ����)
  // 403 : url, �޼���� �ִµ� ������ ���� ���(���� ����)

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

    // �˻�
    String field = request.getParameter("f") != null && !request.getParameter("f").equals("") ? request.getParameter("f") : "title"; // select option
    String query = request.getParameter("q") != null && !request.getParameter("q").equals("") ? request.getParameter("q") : ""; // �˻���

    // ������
    int page = request.getParameter("p") != null && !request.getParameter("p").equals("") ? Integer.parseInt(request.getParameter("p")) : 1;

    NoticeService service = new NoticeService();
    List<NoticeView> list = service.getNoticeList(field, query, page);

    // �˻��� ���� ī��Ʈ
    int count = service.getNoticeCount(field, query);

    request.setAttribute("list", list);
    request.setAttribute("count", count);

    request.getRequestDispatcher("/WEB-INF/view/admin/board/notice/list.jsp").forward(request, response);
  }
}
