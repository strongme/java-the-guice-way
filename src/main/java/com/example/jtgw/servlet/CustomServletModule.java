package com.example.jtgw.servlet;

import com.google.inject.servlet.ServletModule;

public class CustomServletModule extends ServletModule {

  @Override
  protected void configureServlets() {
    serve("/").with(MainServlet.class);
  }
}
