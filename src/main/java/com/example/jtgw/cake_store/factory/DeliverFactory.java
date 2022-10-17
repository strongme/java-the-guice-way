package com.example.jtgw.cake_store.factory;

import com.example.jtgw.component.Deliver;
import com.example.jtgw.component.impl.DefaultDeliver;

public class DeliverFactory {

  private static Deliver instance;

  public static Deliver getInstance() {
    if (instance == null) {
      instance = new DefaultDeliver(AdvertiserFactory::getInstance);
    }
    return instance;
  }

  public static void setInstance(Deliver instance) {
    DeliverFactory.instance = instance;
  }
}
