package com.example.jtgw.servlet;

import java.time.Instant;

public class ScopeTester {

  private final long id;

  public ScopeTester() {
    this.id = Instant.now().toEpochMilli();
  }

  public long getId() {
    return id;
  }
}
