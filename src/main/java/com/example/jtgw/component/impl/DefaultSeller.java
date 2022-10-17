package com.example.jtgw.component.impl;

import java.util.Optional;

import com.example.jtgw.cake_store.guice.annotation.LogInvoke;
import com.example.jtgw.component.Discount;
import com.example.jtgw.component.Seller;
import com.example.jtgw.entity.Order;

public class DefaultSeller implements Seller {

  private final Optional<Discount> optionalDiscount;

  public DefaultSeller(Optional<Discount> optionalDiscount) {
    System.out.println("init seller");
    this.optionalDiscount = optionalDiscount;
  }

  @Override
  @LogInvoke
  public Order sell(String sellTarget, String address) {
    System.out.printf("manual sell 👩‍💼👩‍💼👩‍💼 %s\n", sellTarget);
    Double price = 200d;
    if (optionalDiscount.isPresent()) {
      price = optionalDiscount.get().discount(price);
    }
    return new Order(sellTarget, address, price);
  }

}
