package com.example.jtgw.cake_store.guice;

import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

import javax.inject.Provider;

import com.example.jtgw.cake_store.CakeStore;
import com.example.jtgw.component.Cooker;
import com.example.jtgw.component.Deliver;
import com.example.jtgw.component.Notifier;
import com.example.jtgw.component.Packager;
import com.example.jtgw.component.Pay;
import com.example.jtgw.component.Seller;
import com.example.jtgw.entity.Order;

public class GuiceCakeStore implements CakeStore {

  private static final AtomicInteger counter = new AtomicInteger(0);

  private final Provider<Cooker> cookerProvider;
  private final Seller seller;

  private final Packager packager;
  private final Deliver deliver;
  private final Pay pay;

  private final Set<Notifier> notifiers;

  private final int id;

  public GuiceCakeStore(Provider<Cooker> cookerProvider, Seller seller, Packager packager,
      Deliver deliver, Pay pay, Set<Notifier> notifiers) {
    this.id = counter.getAndIncrement();
    this.cookerProvider = cookerProvider;
    this.seller = seller;
    this.packager = packager;
    this.deliver = deliver;
    this.pay = pay;
    this.notifiers = notifiers;
  }

  @Override
  public Order process(String cakeName, String deliverAddress) {
    System.out.printf("🍰 start cake store business id: %s 🍰 \n", id);
    String cake = cookerProvider.get().cook(cakeName);
    Order order = seller.sell(cake, deliverAddress);
    packager.pack(order.getCake());
    deliver.deliver(order);
    pay.pay(order);
    notifiers.forEach(notifier -> {
      notifier.notify(
          String.format("end business of %s to %s ", order.getCake(), order.getAddress()));
    });
    System.out.printf("👋 end cake store business id: %s 👋\n\n", id);
    return order;
  }
}
