package com.example.jtgw.cake_store.factory;

import com.example.jtgw.component.Packager;
import com.example.jtgw.component.impl.DefaultPackager;

public class PackagerFactory {

  private static Packager instance;

  public static Packager getInstance() {
    if (instance == null) {
      instance = new DefaultPackager("plastic");
    }
    return instance;
  }

  public static void setInstance(Packager instance) {
    PackagerFactory.instance = instance;
  }
}
