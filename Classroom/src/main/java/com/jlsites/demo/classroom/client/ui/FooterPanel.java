package com.jlsites.demo.classroom.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class FooterPanel extends Composite {

  private static FooterPanelUiBinder uiBinder = GWT.create(FooterPanelUiBinder.class);

  interface FooterPanelUiBinder extends UiBinder<Widget, FooterPanel> {
  }

  public FooterPanel() {
    initWidget(uiBinder.createAndBindUi(this));
  }

}
