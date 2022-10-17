package com.example.jtgw.servlet;

import com.example.jtgw.cake_store.guice.CakeStoreModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;

public class CustomGuiceServletConfig extends GuiceServletContextListener {

  @Override
  protected Injector getInjector() {
    return Guice.createInjector(new CustomServletModule(), new CakeStoreModule());
  }
}
