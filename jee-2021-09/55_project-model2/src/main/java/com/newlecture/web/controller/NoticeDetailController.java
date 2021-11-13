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
			PreparedStatement st = con.prepareStatement(sql); // 쿼리 ?를 채울 수 있음, 미리 준비한 sql 변수(쿼리)를 추가
			st.setInt(1, id); // 1번째 ?에 id를 넣겠다
			ResultSet rs = st.executeQuery(); // 모든 준비 후 실행만 하면 됨
			rs.next(); // 호출 시 ResultSet이 사용하는 공간에 레코드 하나가 적재됨

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
				
		// 홈 디렉토리는 Webapp
		request.getRequestDispatcher("/notice/detail.jsp").forward(request, response);

	}
	
}
