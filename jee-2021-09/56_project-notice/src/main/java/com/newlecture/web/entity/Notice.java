package com.newlecture.web.entity;

import java.util.Date;

public class Notice {
	private String title;
	private String writer;
	private int hit;
	private Date regdate;
	private String files;
	private String content;
	
	public Notice() {
	}
	public Notice(String title, String writer, int hit, Date regdate, String files, String content) {
		super();
		this.title = title;
		this.writer = writer;
		this.hit = hit;
		this.regdate = regdate;
		this.files = files;
		this.content = content;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public String getFiles() {
		return files;
	}
	public void setFiles(String files) {
		this.files = files;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
