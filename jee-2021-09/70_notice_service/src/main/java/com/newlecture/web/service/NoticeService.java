package com.newlecture.web.service;

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
	
	public List<Notice> getNoticeList(String field, String query, int page) { //3
		String sql = "SELECT * FROM"
				+ "      (SELECT ROWNUM NUM, N.* FROM"
				+ "            (SELECT * FROM NOTICE ORDER BY REGDATE DESC) N"
				+ "       )"
				+ "    WHERE ROWNUM BETWEEN 1 AND 3";
		return null;
	}
	
	public int getNoticeCount() {
		return getNoticeCount("title", "");
	}
	
	public int getNoticeCount(String field, String query) {
		return 0;
	}
	
	public Notice getNotice(int id) {
		String sql = "SELECT * FROM NOTICE WHERE ID = ?";
		return null;
	}
	
	public Notice getNextNotice(int id) {
		String sql = "SELECT * FROM NOTICE"
				+ "    WHERE ID = (SELECT ID FROM NOTICE WHERE REGDATE > ("
				+ "            SELECT REGDATE FROM NOTICE WHERE ID = 3)"
				+ "            AND ROWNUM = 1"
				+ "    )";
		return null;
	}
	
	public Notice getPrevNotice(int id) {
		String sql = "SELECT * FROM (SELECT * FROM NOTICE ORDER BY REGDATE DESC)"
				+ "    WHERE REGDATE < (SELECT REGDATE FROM NOTICE WHERE ID = 3) AND ROWNUM = 1";
		return null;
	}
	
}
