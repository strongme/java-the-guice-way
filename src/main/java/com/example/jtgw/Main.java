package com.example.jtgw;

import javax.servlet.ServletException;

import com.example.jtgw.cake_store.CakeStore;
import com.example.jtgw.cake_store.guice.CakeStoreModule;
import com.example.jtgw.component.StringWrapper;
import com.example.jtgw.util.CookerUtil;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.apache.catalina.LifecycleException;

public class Main {

  public static void main(String[] args) throws ServletException, LifecycleException {
    // the manual way
    //    CakeStore cakeStore = new ManualCakeStore();
    //    cakeStore.process("🍰🍰🍰", "🏠🏠🏠");
    //    cakeStore.process("🍰🍰🍰🍰", "🏠🏠🏠🏠");

    // the factory way
    //    CakeStore cakeStore = new FactoryCakeStore();
    //    cakeStore.process("🍰🍰🍰", "🏠🏠🏠");
    //    cakeStore.process("🍰🍰🍰🍰", "🏠🏠🏠🏠");

    //     the guice way
    Injector injector = Guice.createInjector(new CakeStoreModule());
    testTheGuiceWay(injector);
    // auto injection
    //    testAutoInjection(injector);
    // static injection
    //    testStaticInjection();

    // servlet with guice
//    Tomcat tomcat = new TomcatModule().createEmbedTomcat();
//    tomcat.start();
//    tomcat.getServer().await();
  }

  static void testTheGuiceWay(Injector injector) {
    CakeStore cakeStore1 = injector.getInstance(CakeStore.class);
    cakeStore1.process("冰激凌蛋糕", "石门路12号");
    CakeStore cakeStore2 = injector.getInstance(CakeStore.class);
    cakeStore2.process("冰激凌蛋糕", "石门路12号");
  }

  static void testAutoInjection(Injector injector) {
    StringWrapper stringWrapper = injector.getInstance(StringWrapper.class);
    System.out.println(stringWrapper.getStr());
  }

  static void testStaticInjection() {
    System.out.println(CookerUtil.getCookerInstance().cook("Test Cake"));
  }
}
