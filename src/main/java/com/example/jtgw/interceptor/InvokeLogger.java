package com.example.jtgw.interceptor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class InvokeLogger implements MethodInterceptor {
  @Override
  public Object invoke(MethodInvocation methodInvocation) throws Throwable {
    long start = System.currentTimeMillis();
    Object result = methodInvocation.proceed();
    long end = System.currentTimeMillis();
    System.out.printf("log:-----------method [%s] get invoked in %s ms-----------\n",methodInvocation.getMethod().getName(), end-start);
    return result;
  }
}
