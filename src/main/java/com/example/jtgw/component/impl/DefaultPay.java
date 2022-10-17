package com.example.jtgw.component.impl;

import com.example.jtgw.cake_store.guice.annotation.LogInvoke;
import com.example.jtgw.entity.Order;
import com.example.jtgw.component.Pay;

public class DefaultPay implements Pay {
  @Override
  @LogInvoke
  public void pay(Order order) {
    System.out.printf("manual pay 💰💰💰 ¥%s for %s\n", order.getPrice(), order.getCake());
  }
}
