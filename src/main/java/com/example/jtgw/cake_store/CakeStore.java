package com.example.jtgw.cake_store;

import com.example.jtgw.entity.Order;

public interface CakeStore {

  Order process(String cakeName, String deliverAddress);

}
