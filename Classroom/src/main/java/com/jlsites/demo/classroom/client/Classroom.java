package com.jlsites.demo.classroom.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.CssResource.NotStrict;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.RootLayoutPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Classroom implements EntryPoint {

  interface Binder extends UiBinder<LayoutPanel, Classroom> {
  }

  interface GlobalResources extends ClientBundle {
    @NotStrict
    @Source("global.css")
    CssResource css();
  }

  private static final Binder binder = GWT.create(Binder.class);

  @UiField
  TopPanel topPanel;
  @UiField
  ContentPanel contentPanel;
  @UiField
  FooterPanel footerPanel;

  public void onModuleLoad() {
    // Inject global styles.
    GWT.<GlobalResources> create(GlobalResources.class).css().ensureInjected();

    LayoutPanel outer = binder.createAndBindUi(this);

    RootLayoutPanel root = RootLayoutPanel.get();
    root.add(outer);
  }
}
