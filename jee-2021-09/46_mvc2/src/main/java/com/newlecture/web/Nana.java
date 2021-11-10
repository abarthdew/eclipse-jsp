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
		String result = ""; // model(index.jsp�� result�� ����)
		String num_ = request.getParameter("num");
		if (num_ != null && !num_.equals("")) {
			num = Integer.parseInt(num_);
		}
		result = num%2 == 0 ? "¦��" : "Ȧ��";
		
		// <������ �����>
		// page context : ������ ������ ȥ�� ����� �� �ִ� �����.
		// request : �� ������ ������ ���迡�� ����� �� �ִ� �����.
		// session : ���� ���ǿ��� �����Ǵ� �����.
		// page : ��� ����, ��� ���������� �����Ǵ� �����.
		// <Ŭ���̾�Ʈ�� �����>
		// cookie : Ŭ���̾�Ʈ�� �����ϴ� �����.
		request.setAttribute("result", result); // request�� ���� ���� index.jsp���� ������ �� ����.
		
		// index.jsp�� �� Ŭ���� �� ���̸� �������� �� �ִ� ������ �ʿ�.
		// result�� index.jsp�� �����ϱ� ����, �� ������ ������� �Ǵ� ����Ұ� �ʿ�.
		// �� Ŭ�������� index.jsp�� �����ϱ� ���� �������̶�� ����Ҹ� ���.
		// 1. ������(foward) : ���� �۾��� ������ �̾ �� �ֵ��� ���𰡸� ����. 
		// 2. �����̷�Ʈ(redirect) : ���� �۾��� ������� ���� ���ο� ��û�� �� �� ���.
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp"); // ���� ���丮�� �ֱ� ������ �̷��� ǥ��
		dispatcher.forward(request, response); // req, res�� index.jsp�� ������ �� ����.
	}
	
}
