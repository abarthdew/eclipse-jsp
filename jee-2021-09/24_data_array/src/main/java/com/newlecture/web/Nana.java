package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.StringUtils;


@WebServlet("/data-array")
public class Nana extends HttpServlet {
	
	protected void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");
		
		// ������ �̸����� �������� �Ѳ����� ���� ������
		String[] num = req.getParameterValues("num");
		
		int result = 0;
		for (String n : num) {
			result += Integer.parseInt(n);
		}
		
		res.getWriter().printf("result is %d\n", result);
		
	}
}
