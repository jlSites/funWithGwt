package com.jlsites.demo.classroom.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class GwtWithDb {

  private final ClientGinjector injector = GWT.create(ClientGinjector.class);

  public void onModuleLoad() {
    MainView mainPanel = injector.getMainPanel();
    RootPanel.get("gwtPlaceHolder").add(mainPanel);
  }

}
