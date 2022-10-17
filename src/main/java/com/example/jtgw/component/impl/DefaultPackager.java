package com.example.jtgw.component.impl;

import com.example.jtgw.cake_store.guice.annotation.LogInvoke;
import com.example.jtgw.component.Packager;

public class DefaultPackager implements Packager {

  private final String material;

  public DefaultPackager(String material) {
    this.material = material;
  }

  @Override
  @LogInvoke
  public void pack(String target) {
    System.out.printf("manual package %s with %s\n", target, material);
  }
}
