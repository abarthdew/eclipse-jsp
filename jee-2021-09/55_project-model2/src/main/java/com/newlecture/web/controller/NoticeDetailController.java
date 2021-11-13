package com.newlecture.web.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/notice/detail")
public class NoticeDetailController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String url = "jdbc:oracle:thin:@localhost:1521/xe";
		String sql = "SELECT * FROM NOTICE WHERE ID = ?";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "newlec", "1234");
			PreparedStatement st = con.prepareStatement(sql); // ���� ?�� ä�� �� ����, �̸� �غ��� sql ����(����)�� �߰�
			st.setInt(1, id); // 1��° ?�� id�� �ְڴ�
			ResultSet rs = st.executeQuery(); // ��� �غ� �� ���ุ �ϸ� ��
			rs.next(); // ȣ�� �� ResultSet�� ����ϴ� ������ ���ڵ� �ϳ��� �����

			String title = rs.getString("TITLE");
			String writer = rs.getString("WRITE_ID");
			int hit = rs.getInt("HIT");
			Date regdate = rs.getDate("REGDATE");
			String files = rs.getString("FILES");
			String content = rs.getString("CONTENT");
			

			request.setAttribute("title", title);
			request.setAttribute("writer", writer);
			request.setAttribute("regdate", regdate);
			request.setAttribute("hit", hit);
			request.setAttribute("files", files);
			request.setAttribute("content", content);
			
			rs.close();
		    st.close();
		    con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		// Ȩ ���丮�� Webapp
		request.getRequestDispatcher("/notice/detail.jsp").forward(request, response);

	}
	
}
