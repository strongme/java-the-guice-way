package com.example.jtgw.cake_store.factory;

import com.example.jtgw.cake_store.CakeStore;
import com.example.jtgw.component.Cooker;
import com.example.jtgw.component.Deliver;
import com.example.jtgw.component.Packager;
import com.example.jtgw.component.Pay;
import com.example.jtgw.component.Seller;
import com.example.jtgw.entity.Order;

public class FactoryCakeStore implements CakeStore {
  @Override
  public Order process(String cakeName, String deliverAddress) {
    System.out.println("🍰 start cake store business 🍰 ");
    Cooker cooker = CookerFactory.getInstance();
    String cake = cooker.cook(cakeName);
    Seller seller = SellerFactory.getInstance();
    Order order = seller.sell(cake, deliverAddress);
    Packager packager = PackagerFactory.getInstance();
    packager.pack(order.getCake());
    Deliver deliver = DeliverFactory.getInstance();
    deliver.deliver(order);
    Pay pay = PayFactory.getInstance();
    pay.pay(order);
    System.out.println("👋 end cake store business 👋\n");
    return order;
  }
}
