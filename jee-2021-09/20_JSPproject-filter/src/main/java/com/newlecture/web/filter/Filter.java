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
    // 톰캣이 처음 실행될 때, 요청이 올 때마다 실행됨

    // 공통 설정
    req.setCharacterEncoding("UTF-8");
    // chain.doFilter(req, res);로 다음 작업이 실행되기 전에 설정

    // FilterChain chain : filter로 들어온 흐름을 다음 요청으로 전달할 것인가를 결정
    chain.doFilter(req, res);
    // req : 요청이 오면 흐름을 다음 필터 또는 서블릿이 실행되도록 함
    // res : 그 후 결과가 돌아오면 System.out.println("after filter"); 이 실행됨
    System.out.println("after filter");
  }

}
