package com.example.jtgw.servlet;

import java.io.IOException;

import javax.inject.Singleton;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.inject.Inject;
import lombok.SneakyThrows;

@Singleton
public class MainServlet extends HttpServlet {

  private final ScopeTester scopeTester;

  @Inject
  public MainServlet(ScopeTester scopeTester) {
    this.scopeTester = scopeTester;
  }

  @SneakyThrows
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws IOException {
    // test multiple instance
//    System.out.printf("scopeTest Id 1: %s\n", scopeTester.getId());
//    Thread.sleep(100);
//    System.out.printf("scopeTest Id 2: %s\n", scopeTester.getId());
    resp.getWriter().printf("scopeTest Id: %s", scopeTester.getId());
  }
}
