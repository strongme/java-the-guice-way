package com.example.jtgw.component.impl;

import com.example.jtgw.cake_store.guice.annotation.LogInvoke;
import com.example.jtgw.component.Pay;
import com.example.jtgw.entity.Order;

public class AliPay implements Pay {
  @Override
  @LogInvoke
  public void pay(Order order) {
    System.out.printf("Alipay pay 💰💰💰 ¥%s for %s\n", order.getPrice(), order.getCake());
  }
}
