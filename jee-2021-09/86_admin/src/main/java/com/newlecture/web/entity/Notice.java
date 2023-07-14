package com.newlecture.web.entity;

import java.util.Date;

public class Notice {
  private int id;
  private String title;
  private String writer;
  private int hit;
  private Date regdate;
  private String files;
  private String content;
  private boolean pub;

  public Notice() {
  }

  public Notice(int id, String title, String writer, int hit, Date regdate, String files, String content, boolean pub) {
    super();
    this.id = id;
    this.title = title;
    this.writer = writer;
    this.hit = hit;
    this.regdate = regdate;
    this.files = files;
    this.content = content;
    this.pub = pub;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
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

  public boolean getPub() {
    return pub;
  }

  public void setPub(boolean pub) {
    this.pub = pub;
  }

}
