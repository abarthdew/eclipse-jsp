package com.newlecture.web.entity;

import java.sql.Date;

public class NoticeView extends Notice {

  private int cnt;

  public NoticeView() {
    // TODO Auto-generated constructor stub
  }

  public NoticeView(int id, String title, String writeId, int hit, Date regdate, String file, String content, int cnt, boolean pub) {
    // 부모 속성 세팅
    super(id, title, writeId, hit, regdate, file, "", pub); // content는 빈문자열
    // 나머지 속성 세팅
    this.cnt = cnt;
  }

  public int getCnt() {
    return cnt;
  }

  public void setCnt(int cnt) {
    this.cnt = cnt;
  }

}
