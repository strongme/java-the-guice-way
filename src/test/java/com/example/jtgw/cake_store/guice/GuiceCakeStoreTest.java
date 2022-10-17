package com.example.jtgw.cake_store.guice;

import com.example.jtgw.cake_store.CakeStore;
import com.example.jtgw.component.Cooker;
import com.example.jtgw.component.Deliver;
import com.example.jtgw.component.Notifier;
import com.example.jtgw.component.Packager;
import com.example.jtgw.component.Pay;
import com.example.jtgw.component.Seller;
import com.example.jtgw.entity.Order;
import com.google.common.collect.Sets;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GuiceCakeStoreTest {

  @Mock
  private Cooker cooker;
  @Mock
  private Seller seller;
  @Mock
  private Packager packager;
  @Mock
  private Deliver deliver;
  @Mock
  private Pay pay;
  @Mock
  private Notifier notifier;
  private CakeStore cakeStore;

  @Before
  public void setup() {
    cakeStore = new GuiceCakeStore(() -> cooker, seller, packager, deliver, pay,
        Sets.newHashSet(notifier));
  }

  @Test
  public void test_cake_store_process_success() {

    String cakeName = "test cake";
    String cookedCake = "cooked test cake";
    String address = "test address";
    Order order = new Order(cookedCake, address, 200d);

    when(cooker.cook(cakeName)).thenReturn(cookedCake);
    when(seller.sell(cookedCake, address)).thenReturn(order);

    Order actual = cakeStore.process("test cake", "test address");
    Assert.assertEquals(order, actual);
  }
}
