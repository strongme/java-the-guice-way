package com.example.jtgw.cake_store.guice;

import java.util.Optional;
import java.util.Set;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

import com.example.jtgw.cake_store.guice.annotation.AlipayTag;
import com.example.jtgw.cake_store.guice.annotation.LogInvoke;
import com.example.jtgw.cake_store.guice.annotation.WechatPayTag;
import com.example.jtgw.cake_store.CakeStore;
import com.example.jtgw.component.Advertiser;
import com.example.jtgw.component.Cooker;
import com.example.jtgw.component.Deliver;
import com.example.jtgw.component.Discount;
import com.example.jtgw.component.Notifier;
import com.example.jtgw.component.Packager;
import com.example.jtgw.component.Pay;
import com.example.jtgw.component.Seller;
import com.example.jtgw.component.StringWrapper;
import com.example.jtgw.component.impl.AliPay;
import com.example.jtgw.component.impl.DefaultAdvertiser;
import com.example.jtgw.component.impl.DefaultCooker;
import com.example.jtgw.component.impl.DefaultDeliver;
import com.example.jtgw.component.impl.DefaultNotifier;
import com.example.jtgw.component.impl.DefaultPackager;
import com.example.jtgw.component.impl.DefaultSeller;
import com.example.jtgw.component.impl.HalfPriceDiscount;
import com.example.jtgw.component.impl.SmsNotifier;
import com.example.jtgw.component.impl.WechatNotifier;
import com.example.jtgw.component.impl.WechatPay;
import com.example.jtgw.interceptor.InvokeLogger;
import com.example.jtgw.util.CookerUtil;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.matcher.Matcher;
import com.google.inject.matcher.Matchers;
import com.google.inject.multibindings.Multibinder;
import com.google.inject.multibindings.OptionalBinder;
import com.google.inject.multibindings.ProvidesIntoSet;
import lombok.SneakyThrows;

public class CakeStoreModule extends AbstractModule {

  @SneakyThrows
  @Override
  protected void configure() {
    bind(Cooker.class).to(DefaultCooker.class)
        .in(Singleton.class); // linked binding and scope singleton and provide the direct provider binding (implicit provider binding)
    //    bind(Seller.class).to(DefaultSeller.class); // untargeted binding
    bind(String.class).toInstance("plastic package material"); // instance binding
    bind(StringWrapper.class).toInstance(new StringWrapper()); // auto inject to the instance that's being injected

    bind(Packager.class).toConstructor(
        DefaultPackager.class.getConstructor(String.class)); // constructor binding

    bind(Advertiser.class).toProvider(AdvertiserProvider.class)
        .in(Singleton.class); // provider binding (explicit provider binding)

    bind(Pay.class).annotatedWith(AlipayTag.class)
        .to(AliPay.class); // linked binding and binding annotation

    // multi binding
    Multibinder<Notifier> notifierMultiBinder = Multibinder.newSetBinder(binder(), Notifier.class);
    notifierMultiBinder.addBinding().to(DefaultNotifier.class);
    notifierMultiBinder.addBinding().to(WechatNotifier.class);

    // optional binding
    OptionalBinder<Discount> discountOptionalBinder = OptionalBinder.newOptionalBinder(binder(),
        Discount.class);
    discountOptionalBinder.setBinding().to(HalfPriceDiscount.class);

    // static inject
    requestStaticInjection(CookerUtil.class);

    // aop
    bindInterceptor(Matchers.any(), Matchers.annotatedWith(LogInvoke.class), new InvokeLogger());
  }

  @ProvidesIntoSet
  public Notifier smsNotifier() {
    return new SmsNotifier();
  }

  public static class AdvertiserProvider implements Provider<Advertiser> {
    @Override
    public Advertiser get() {
      return new DefaultAdvertiser("🔊🔊🔊🔊 Cake 🍰🍰🍰 of the year, come and enjoy! 🔊🔊🔊🔊");
    }
  }

  @Provides
  @Inject
  public Seller sellerProvide(Optional<Discount> optionalDiscount) {
    return new DefaultSeller(optionalDiscount);
  }

  @Provides
  @Inject
  public Deliver deliverProvide(Provider<Advertiser> advertiserProvider) {
    return new DefaultDeliver(advertiserProvider);
  }

  @Provides
  @WechatPayTag
  // usage like this does not participate in AOP
  public Pay wechatPayProvide() {
    return new WechatPay();
  }

  @Provides
  @Inject
  @Singleton
  public CakeStore cakeStoreProvide(Provider<Cooker> cookerProvider, Seller seller,
      Packager packager, Deliver deliver, @WechatPayTag Pay pay, Set<Notifier> notifiers) {
    return new GuiceCakeStore(cookerProvider, seller, packager, deliver, pay, notifiers);
  }
}
