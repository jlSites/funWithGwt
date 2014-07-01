package com.jlsites.how2gwt.gwtwithdb.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class GwtWithDb implements EntryPoint {

  private final ClientGinjector injector = GWT.create(ClientGinjector.class);

  /**
   * This is the entry point method.
   */
  public void onModuleLoad() {
    MainView mainPanel = injector.getMainPanel();
    RootPanel.get("gwtPlaceHolder").add(mainPanel);
  }

}
