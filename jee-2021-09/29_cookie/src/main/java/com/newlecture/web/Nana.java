package com.newlecture.web;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/cookie")
public class Nana extends HttpServlet {

  protected void service(HttpServletRequest req, HttpServletResponse res) throws IOException {

    Cookie[] cookies = req.getCookies();

    int v = Integer.parseInt(req.getParameter("v"));
    String button = req.getParameter("button");

    int result = 0;

    if (button.equals("=")) {
      // 쿠키 배열을 돌면서 찾기
      int x = 0;
      for (Cookie c : cookies) {
        if (c.getName().equals("value")) {
          x = Integer.parseInt(c.getValue());
          break;
        }
      }
      int y = v;
      // 쿠키 배열을 돌면서 찾기
      String buttonOperator = "";
      for (Cookie c : cookies) {
        if (c.getName().equals("button")) {
          buttonOperator = c.getValue();
          break;
        }
      }
      result = buttonOperator.equals("+") ? x + y : x - y;
      res.getWriter().printf("result is %d\n", result);
    } else {
      Cookie valueCookie = new Cookie("value", String.valueOf(v)); // url에 사용할 수 있는 문자 형태로 저장해야 함
      Cookie buttonCookie = new Cookie("button", button);

      res.addCookie(valueCookie);
      res.addCookie(buttonCookie);
    }

    for (Cookie e : cookies) {
      System.out.println(e.getName());
      System.out.println(e.getValue());
    }

  }
}
