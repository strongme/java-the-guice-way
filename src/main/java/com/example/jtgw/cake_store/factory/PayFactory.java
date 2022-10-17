package com.example.jtgw.cake_store.factory;

import com.example.jtgw.component.Pay;
import com.example.jtgw.component.impl.DefaultPay;

public class PayFactory {

  private static Pay instance;

  public static Pay getInstance() {
    if (instance == null) {
      instance = new DefaultPay();
    }
    return instance;
  }

  public static void setInstance(Pay instance) {
    PayFactory.instance = instance;
  }
}
