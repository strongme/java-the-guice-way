package com.example.jtgw.component.impl;

import com.example.jtgw.cake_store.guice.annotation.LogInvoke;
import com.example.jtgw.component.Cooker;

public class DefaultCooker implements Cooker {

  public DefaultCooker() {
    try {
      System.out.println("🔥start init cooking tool🔥");
      int count = 0;
      while (count < 3) {
        count++;
        System.out.printf("init cooker %s ...\n", count);
        Thread.sleep(1000);
      }
      System.out.println("🔥end init cooking tool🔥");
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  @LogInvoke
  public String cook(String cookTarget) {
    System.out.printf("manual cook 🔥🔥🔥 %s\n", cookTarget);
    return String.format("cooked %s", cookTarget);
  }
}
