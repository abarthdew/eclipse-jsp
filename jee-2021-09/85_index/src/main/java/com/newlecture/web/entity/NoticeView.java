package com.newlecture.web.entity;

import java.sql.Date;

public class NoticeView extends Notice {
	
	private int cnt;

	public NoticeView() {
		// TODO Auto-generated constructor stub
	}

	public NoticeView(int id, String title, String writeId, int hit, Date regdate, String file, String content, int cnt) {
		// �θ� �Ӽ� ����
		super(id, title, writeId, hit, regdate, file, ""); // content�� ���ڿ�
		// ������ �Ӽ� ����
		this.cnt = cnt;
	}
	
	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

}
