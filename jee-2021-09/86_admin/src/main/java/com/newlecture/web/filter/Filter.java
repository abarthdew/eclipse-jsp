package com.newlecture.web.filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/*")
public class Filter implements javax.servlet.Filter {

  @Override
  public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
    throws IOException, ServletException {

    System.out.println("before filter");
    // ��Ĺ�� ó�� ����� ��, ��û�� �� ������ �����

    // ���� ����
    req.setCharacterEncoding("UTF-8");
    // chain.doFilter(req, res);�� ���� �۾��� ����Ǳ� ���� ����

    // FilterChain chain : filter�� ���� �帧�� ���� ��û���� ������ ���ΰ��� ����
    chain.doFilter(req, res);
    // req : ��û�� ���� �帧�� ���� ���� �Ǵ� ������ ����ǵ��� ��
    // res : �� �� ����� ���ƿ��� System.out.println("after filter"); �� �����
    System.out.println("after filter");
  }

}
