package com.newlecture.web.controller.admin.notice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newlecture.web.entity.Notice;

@WebServlet("/admin/board/notice/reg")
// get, post 요청 처리
public class RegController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 등록하기 위한 페이지
		request.getRequestDispatcher("/WEB-INF/view/admin/board/notice/reg.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String open = request.getParameter("open");
		
		Notice notice = new Notice();
		notice.setTitle(title);
		notice.setContent(content);
		
		PrintWriter out = response.getWriter();
		out.printf("tltle: %s<br>", title);
		out.printf("content: %s<br>", content);
		out.printf("open: %s<br>", open);
	}
	
}
