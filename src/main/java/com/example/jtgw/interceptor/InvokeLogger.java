package com.example.jtgw.interceptor;

import javax.inject.Inject;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class InvokeLogger implements MethodInterceptor {

  @Inject
  private String str;

  @Override
  public Object invoke(MethodInvocation methodInvocation) throws Throwable {
    System.out.printf("injected str: %s\n", str);
    long start = System.currentTimeMillis();
    Object result = methodInvocation.proceed();
    long end = System.currentTimeMillis();
    System.out.printf("log:-----------method [%s] get invoked in %s ms-----------\n",methodInvocation.getMethod().getName(), end-start);
    return result;
  }
}
