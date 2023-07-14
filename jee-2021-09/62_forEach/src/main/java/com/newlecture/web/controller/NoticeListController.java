package com.newlecture.web.controller;

import com.newlecture.web.entity.Notice;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet("/notice/list")
public class NoticeListController extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String url = "jdbc:oracle:thin:@localhost:1521/xe";
    String sql = "SELECT * FROM NOTICE";

    try {
      Class.forName("oracle.jdbc.driver.OracleDriver");
      Connection con = DriverManager.getConnection(url, "newlec", "1234");
      Statement st = con.createStatement();
      ResultSet rs = st.executeQuery(sql);

      List<Notice> list = new ArrayList();

      while (rs.next()) {
        int id = rs.getInt("ID");
        String title = rs.getString("TITLE");
        String writer = rs.getString("WRITE_ID");
        int hit = rs.getInt("HIT");
        Date regdate = rs.getDate("REGDATE");
        String files = rs.getString("FILES");
        String content = rs.getString("CONTENT");
        Notice notice = new Notice(id, title, writer, hit, regdate, files, content);
        list.add(notice);
      }

      request.setAttribute("list", list);
      request.getRequestDispatcher("/WEB-INF/view/notice/list.jsp").forward(request, response);

      rs.close();
      st.close();
      con.close();
    } catch (ClassNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }
}
