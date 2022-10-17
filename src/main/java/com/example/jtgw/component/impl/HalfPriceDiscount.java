package com.example.jtgw.component.impl;

import com.example.jtgw.cake_store.guice.annotation.LogInvoke;
import com.example.jtgw.component.Discount;

public class HalfPriceDiscount implements Discount {
  @Override
  @LogInvoke
  public Double discount(Double price) {
    return price * 0.5;
  }
}
