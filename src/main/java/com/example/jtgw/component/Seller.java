package com.example.jtgw.component;

import com.example.jtgw.entity.Order;

public interface Seller {

   Order sell(String sellTarget, String address);

}
