package com.example.jtgw.component.impl;

import com.example.jtgw.cake_store.guice.annotation.LogInvoke;
import com.example.jtgw.component.Notifier;

public class SmsNotifier implements Notifier {
  @Override
  @LogInvoke
  public void notify(String message) {
    System.out.printf("SMSð±  notify ð¢ð¢ð¢ %s \n", message);
  }
}
