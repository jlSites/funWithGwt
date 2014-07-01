package com.jlsites.demo.classroom.client;

import com.google.gwt.inject.client.AbstractGinModule;
import com.google.inject.Singleton;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;

public class ClientGinModule extends AbstractGinModule {

  protected void configure() {
    bind(EventBus.class).to(SimpleEventBus.class).in(Singleton.class);

    // bind(PlaceController.class).in(Singleton.class);

    bindViews();

    bindPresenters();

  }

  private void bindViews() {
    bind(MainView.class).in(Singleton.class);

    bind(InforDialog.class).in(Singleton.class);
  }

  private void bindPresenters() {

  }

}
