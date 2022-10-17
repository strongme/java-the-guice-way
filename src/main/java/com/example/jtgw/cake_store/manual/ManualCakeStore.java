package com.example.jtgw.cake_store.manual;

import java.util.Optional;

import com.example.jtgw.cake_store.CakeStore;
import com.example.jtgw.component.Advertiser;
import com.example.jtgw.component.Cooker;
import com.example.jtgw.component.Packager;
import com.example.jtgw.component.Pay;
import com.example.jtgw.component.Seller;
import com.example.jtgw.component.impl.DefaultAdvertiser;
import com.example.jtgw.component.impl.DefaultCooker;
import com.example.jtgw.component.impl.DefaultDeliver;
import com.example.jtgw.component.impl.DefaultPackager;
import com.example.jtgw.component.impl.DefaultPay;
import com.example.jtgw.component.impl.DefaultSeller;
import com.example.jtgw.entity.Order;

public class ManualCakeStore implements CakeStore {

  @Override
  public Order process(String cakeName, String deliverAddress) {
    System.out.println("🍰 start cake store business 🍰 ");
    Cooker cooker = new DefaultCooker();
    String cake = cooker.cook(cakeName);
    Seller seller = new DefaultSeller(Optional.empty());
    Order order = seller.sell(cake, deliverAddress);
    Packager packager = new DefaultPackager("plastic");
    packager.pack(order.getCake());
    Advertiser advertiser = new DefaultAdvertiser("🔊🔊🔊🔊 Cake 🍰🍰🍰 of the year, come and enjoy! 🔊🔊🔊🔊");
    DefaultDeliver deliver = new DefaultDeliver(() -> advertiser);
    deliver.deliver(order);
    Pay pay = new DefaultPay();
    pay.pay(order);
    System.out.println("👋 end cake store business 👋\n");
    return order;
  }
}
