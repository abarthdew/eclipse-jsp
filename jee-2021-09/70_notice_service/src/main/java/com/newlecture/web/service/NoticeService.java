package com.newlecture.web.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.newlecture.web.entity.Notice;

public class NoticeService {

	public List<Notice> getNoticeList() { //1
//		return getNoticeList(1); // 2를 거쳐 3을 호출하므로 두번의 스택이 만들어지기 때문에 주석
		return getNoticeList("title", "", 1); // 3을 바로 호출
	}
	
	public List<Notice> getNoticeList(int page) { // 2
		return getNoticeList("title", "", 1); 
	}
	
	/**
	 * @param field : TITLE, WRITE_ID
	 * @param query : 검색어
	 * @param page : 페이지 번호
	 * @return
	 */
	public List<Notice> getNoticeList(String field, String query, int page) { //3
		List<Notice> list = new ArrayList();
		String sql = "SELECT * FROM"
				+ "      (SELECT ROWNUM NUM, N.* FROM"
				+ "            (SELECT * FROM NOTICE where " + field + " like ? ORDER BY REGDATE DESC) N"
				+ "       )"
				+ "    WHERE NUM BETWEEN ? AND ?";
		// 1, 11, 21, 31 -> 1 + (page - 1) * 10
		// 10, 20, 30, 40 -> page * 10
		
		String url = "jdbc:oracle:thin:@localhost:1521/xe";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "newlec", "1234");
			PreparedStatement st = con.prepareStatement(sql); 
			st.setString(1, "%" + query + "%");
			st.setInt(2, 1 + (page - 1) * 10);
			st.setInt(3, page * 10);
			// st.setString(0, "title" || "write_id");
			// title 혹은 write_id 컬럼을 ?로 처리할 경우 ''가 생기기 때문에 불가능
			// SELECT * FROM NOTICE where 'title' = ?
			
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				Notice notice = new Notice(
					rs.getInt("ID"),
					rs.getString("TITLE"),
					rs.getString("WRITE_ID"),
					rs.getInt("HIT"),
					rs.getDate("REGDATE"),
					rs.getString("FILES"),
					rs.getString("CONTENT")
				);
				list.add(notice);
			}
			rs.close();
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public int getNoticeCount() {
		return getNoticeCount("title", "");
	}
	
	public int getNoticeCount(String field, String query) {
		int count = 0;
		String sql = "SELECT count(ID) COUNT FROM"
				+ "      (SELECT ROWNUM NUM, N.* FROM"
				+ "            (SELECT * FROM NOTICE where title like ? ORDER BY REGDATE DESC) N"
				+ "       )";

		String url = "jdbc:oracle:thin:@localhost:1521/xe";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "newlec", "1234");
			PreparedStatement st = con.prepareStatement(sql); 
			st.setString(1, "%" + query + "%");
			
			ResultSet rs = st.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt("count");
			}
			
			rs.close();
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	
	public Notice getNotice(int id) {
		Notice notice = null;
		
		String sql = "SELECT * FROM NOTICE WHERE ID = ?";
		
		String url = "jdbc:oracle:thin:@localhost:1521/xe";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "newlec", "1234");
			PreparedStatement st = con.prepareStatement(sql); 
			st.setInt(1, id);
			
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				notice = new Notice(
					rs.getInt("ID"),
					rs.getString("TITLE"),
					rs.getString("WRITE_ID"),
					rs.getInt("HIT"),
					rs.getDate("REGDATE"),
					rs.getString("FILES"),
					rs.getString("CONTENT")
				);
			}
			
			rs.close();
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return notice;
	}
	
	public Notice getNextNotice(int id) {
		Notice notice = null;
		
		String sql = "SELECT * FROM NOTICE"
				+ "    WHERE ID = (SELECT ID FROM NOTICE WHERE REGDATE > ("
				+ "            SELECT REGDATE FROM NOTICE WHERE ID = ?)"
				+ "            AND ROWNUM = 1"
				+ "    )";
		
		String url = "jdbc:oracle:thin:@localhost:1521/xe";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "newlec", "1234");
			PreparedStatement st = con.prepareStatement(sql); 
			st.setInt(1, id);
			
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				notice = new Notice(
					rs.getInt("ID"),
					rs.getString("TITLE"),
					rs.getString("WRITE_ID"),
					rs.getInt("HIT"),
					rs.getDate("REGDATE"),
					rs.getString("FILES"),
					rs.getString("CONTENT")
				);
			}
			
			rs.close();
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return notice;
	}
	
	public Notice getPrevNotice(int id) {
		Notice notice = null;
		
		String sql = "SELECT * FROM (SELECT * FROM NOTICE ORDER BY REGDATE DESC)"
				+ "    WHERE REGDATE < (SELECT REGDATE FROM NOTICE WHERE ID = ?) AND ROWNUM = 1";
		
		String url = "jdbc:oracle:thin:@localhost:1521/xe";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "newlec", "1234");
			PreparedStatement st = con.prepareStatement(sql); 
			st.setInt(1, id);
			
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				notice = new Notice(
					rs.getInt("ID"),
					rs.getString("TITLE"),
					rs.getString("WRITE_ID"),
					rs.getInt("HIT"),
					rs.getDate("REGDATE"),
					rs.getString("FILES"),
					rs.getString("CONTENT")
				);
			}
			
			rs.close();
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return notice;
	}
	
}
