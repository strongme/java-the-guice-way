package com.example.jtgw.component.impl;

import com.example.jtgw.cake_store.guice.annotation.LogInvoke;
import com.example.jtgw.component.Notifier;

public class DefaultNotifier implements Notifier {
  @Override
  @LogInvoke
  public void notify(String message) {
    System.out.printf("manual notify 📢📢📢 %s \n", message);
  }
}
