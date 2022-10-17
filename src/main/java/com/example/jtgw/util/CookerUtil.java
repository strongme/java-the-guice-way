package com.example.jtgw.util;

import javax.inject.Inject;
import javax.inject.Provider;

import com.example.jtgw.component.Cooker;

public class CookerUtil {
  @Inject
  static Provider<Cooker> cookerProvider;

  public static Cooker getCookerInstance() {
    return cookerProvider.get();
  }
}
