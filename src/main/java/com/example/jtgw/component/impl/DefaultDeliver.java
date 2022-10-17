package com.example.jtgw.component.impl;

import javax.inject.Inject;
import javax.inject.Provider;

import com.example.jtgw.cake_store.guice.annotation.LogInvoke;
import com.example.jtgw.component.Advertiser;
import com.example.jtgw.component.Deliver;
import com.example.jtgw.entity.Order;

public class DefaultDeliver implements Deliver {

  private final Provider<Advertiser> advertiserProvider;

  @Inject
  public DefaultDeliver(Provider<Advertiser> advertiserProvider) {
    this.advertiserProvider = advertiserProvider;
  }

  @Override
  @LogInvoke
  public void deliver(Order order) {
    System.out.printf("manual deliver 🚴🚴🚴 %s to %s\n", order.getCake(), order.getAddress());
    advertiserProvider.get().showSlogan();
  }
}
