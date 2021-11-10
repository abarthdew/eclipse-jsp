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
		// 부모가 가진 service는 doGet, doPost를 구분해서 호출하도록 되어 있음
		super.service(req, res); // doGet, doPost가 override되어있지 않으면 오류남
	}
	
	// 이렇게 doPost가 메소드가 있어야 됨
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("doPost 메소드가 호출되었습니다.");
	}
	
}
