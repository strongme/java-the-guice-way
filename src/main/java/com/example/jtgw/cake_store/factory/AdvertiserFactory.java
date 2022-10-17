package com.example.jtgw.cake_store.factory;

import com.example.jtgw.component.Advertiser;
import com.example.jtgw.component.impl.DefaultAdvertiser;

public class AdvertiserFactory {

  private static Advertiser instance;

  public static Advertiser getInstance() {
    if (instance == null) {
      instance = new DefaultAdvertiser("🔊🔊🔊🔊 Cake 🍰🍰🍰 of the year, come and enjoy! 🔊🔊🔊🔊");
    }
    return instance;
  }

  public static void setInstance(Advertiser instance) {
    AdvertiserFactory.instance = instance;
  }
}
