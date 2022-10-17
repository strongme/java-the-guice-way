package com.example.jtgw.cake_store.factory;

import com.example.jtgw.component.Discount;
import com.example.jtgw.component.impl.HalfPriceDiscount;

public class DiscountFactory {

  private static Discount instance;

  public static void setInstance(Discount instance) {
    DiscountFactory.instance = instance;
  }

  public static Discount getInstance() {
    if (instance == null) {
      instance = new HalfPriceDiscount();
    }
    return instance;
  }
}
