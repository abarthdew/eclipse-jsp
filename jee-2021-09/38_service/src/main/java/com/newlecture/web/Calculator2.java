package com.newlecture.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/service2")
public class Calculator2 extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// �θ� ���� service�� doGet, doPost�� �����ؼ� ȣ���ϵ��� �Ǿ� ����
		super.service(req, res); // doGet, doPost�� override�Ǿ����� ������ ������
	}
	
	// �̷��� doPost�� �޼ҵ尡 �־�� ��
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("doPost �޼ҵ尡 ȣ��Ǿ����ϴ�.");
	}
	
}
