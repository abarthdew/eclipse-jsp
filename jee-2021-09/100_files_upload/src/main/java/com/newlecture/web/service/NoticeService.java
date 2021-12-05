package com.newlecture.web.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.newlecture.web.entity.Notice;
import com.newlecture.web.entity.NoticeView;

public class NoticeService {
	
	/* 공지 일괄삭제 */
	public int removeNoticeAll(int[] ids) { // 배열로 id를 넘겨받아 삭제된 갯수 리턴
		int result = 0;
		String params = "";
		
		for(int i = 0; i<ids.length; i++) {
			params += ids[i];
			if (i < ids.length - 1) params += ","; 
		}
		
		String sql = "DELETE NOTICE WHERE ID IN (" + params + ")";

		String url = "jdbc:oracle:thin:@localhost:1521/xe";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "newlec", "1234");
			Statement st = con.createStatement();			
			result = st.executeUpdate(sql); // update 된 레코드 수 반환
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/* 공지 일괄공개 */
	public int pubNoticeAll(int[] ids) { // 배열로 id를 넘겨받아 공개된 갯수 리턴
		return 0;
	}
	
	/* 공지 등록 */
	public int insertNotice(Notice notice) {
		int result = 0;
		
		String sql = "INSERT INTO NOTICE (ID, TITLE, CONTENT, WRITE_ID, REGDATE, PUB, FILES) VALUES (?, ?, ?, ?, SYSDATE, ?, ?)";
		String url = "jdbc:oracle:thin:@localhost:1521/xe";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "newlec", "1234");
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, notice.getId());
			st.setString(2, notice.getTitle());
			st.setString(3, notice.getContent());
			st.setString(4, notice.getWriter());
			st.setBoolean(5, notice.getPub());
			st.setString(6, notice.getFiles());
			
			result = st.executeUpdate();
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/* 공지 삭제 */
	public int deleteNotice(int id) {
		return 0;
	}
	
	/* 공지 수정 */
	public int updateNotice(Notice notice) { // insert, update, delete는 보통 레코드 몇 개에 영향을 주었는가에 중점을 두어 반환
		return 0;
	}
	
	/* 최신 공지 불러오기 */
	public List<Notice> getNoticeNewestList() { // 댓글 수까지 필요 없으므로 NoticeView가 아닌 Notice
		return null;
	}

	public List<NoticeView> getNoticeList() { 
		return getNoticeList("title", "", 1);
	}
	
	public List<NoticeView> getNoticeList(int page) {
		return getNoticeList("title", "", 1); 
	}
	
	/**
	 * @param field : TITLE, WRITE_ID
	 * @param query : 검색어
	 * @param page : 페이지 번호
	 * @return
	 */
	public List<NoticeView> getNoticeList(String field, String query, int page) { //3
		List<NoticeView> list = new ArrayList();
		String sql = "SELECT * FROM"
				+ "      (SELECT ROWNUM NUM, N.* FROM"
				+ "            (SELECT * FROM NOTICE_VIEW where " + field + " like ? ORDER BY REGDATE DESC) N"
				+ "       )"
				+ "    WHERE NUM BETWEEN ? AND ?";
		
		String url = "jdbc:oracle:thin:@localhost:1521/xe";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "newlec", "1234");
			PreparedStatement st = con.prepareStatement(sql); 
			st.setString(1, "%" + query + "%");
			st.setInt(2, 1 + (page - 1) * 10);
			st.setInt(3, page * 10);
			
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				NoticeView notice = new NoticeView(
					rs.getInt("ID"),
					rs.getString("TITLE"),
					rs.getString("WRITE_ID"),
					rs.getInt("HIT"),
					rs.getDate("REGDATE"),
					rs.getString("FILES"),
					"", // rs.getString("CONTENT"), VIEW에서 가져오지 않기 때문에 빼 줌
					rs.getInt("CNT"),
					rs.getBoolean("PUB")
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
					rs.getString("CONTENT"),
					rs.getBoolean("PUB")
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
					rs.getString("CONTENT"),
					rs.getBoolean("PUB")
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
					rs.getString("CONTENT"),
					rs.getBoolean("PUB")
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
