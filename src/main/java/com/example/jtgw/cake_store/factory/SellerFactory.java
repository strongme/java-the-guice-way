package com.example.jtgw.cake_store.factory;

import java.util.Optional;

import com.example.jtgw.component.Seller;
import com.example.jtgw.component.impl.DefaultSeller;

public class SellerFactory {

  private static Seller instance;

  public static void setInstance(Seller instance) {
    SellerFactory.instance = instance;
  }

  public static Seller getInstance() {
    if (instance == null) {
      instance = new DefaultSeller(Optional.of(DiscountFactory.getInstance()));
    }
    return instance;
  }
}
