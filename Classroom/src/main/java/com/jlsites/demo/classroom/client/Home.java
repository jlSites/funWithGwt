package com.jlsites.demo.classroom.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class Home extends Composite {

  private static HomeUiBinder uiBinder = GWT.create(HomeUiBinder.class);

  interface HomeUiBinder extends UiBinder<Widget, Home> {
  }

  public Home() {
    initWidget(uiBinder.createAndBindUi(this));
  }

}
