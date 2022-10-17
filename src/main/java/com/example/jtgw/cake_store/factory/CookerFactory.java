package com.example.jtgw.cake_store.factory;

import com.example.jtgw.component.Cooker;
import com.example.jtgw.component.impl.DefaultCooker;

public class CookerFactory {
  private static Cooker instance;

  public static void setInstance(Cooker instance) {
    CookerFactory.instance = instance;
  }

  public static Cooker getInstance() {
    if (instance == null) {
      instance = new DefaultCooker();
    }
    return instance;
  }
}
