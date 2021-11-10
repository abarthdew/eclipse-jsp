package com.newlecture.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mvc2")
public class Nana extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num = 0;
		String result = ""; // model(index.jsp의 result와 같음)
		String num_ = request.getParameter("num");
		if (num_ != null && !num_.equals("")) {
			num = Integer.parseInt(num_);
		}
		result = num%2 == 0 ? "짝수" : "홀수";
		
		// <서버상 저장소>
		// page context : 페이지 내에서 혼자 사용할 수 있는 저장소.
		// request : 둘 사이의 포워드 관계에서 사용할 수 있는 저장소.
		// session : 현재 세션에서 공유되는 저장소.
		// page : 모든 세션, 모든 페이지에서 공유되는 저장소.
		// <클라이언트상 저장소>
		// cookie : 클라이언트에 저장하는 저장소.
		request.setAttribute("result", result); // request에 담은 값을 index.jsp에서 꺼내쓸 수 있음.
		
		// index.jsp와 이 클래스 둘 사이를 연결해줄 수 있는 도구가 필요.
		// result를 index.jsp로 전달하기 위해, 둘 사이의 연결고리가 되는 저장소가 필요.
		// 이 클래스에서 index.jsp로 전이하기 위해 포워딩이라는 저장소를 사용.
		// 1. 포워딩(foward) : 현재 작업한 내용을 이어갈 수 있도록 무언가를 공유. 
		// 2. 리다이렉트(redirect) : 현재 작업과 상관없는 전혀 새로운 요청을 할 때 사용.
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp"); // 같은 디렉토리에 있기 때문에 이렇게 표기
		dispatcher.forward(request, response); // req, res를 index.jsp에 공유할 수 있음.
	}
	
}
