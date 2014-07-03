package com.jlsites.demo.classroom.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class HomeworkViewImpl extends Composite implements HomeworkView {

  private static HomeworkViewImplUiBinder uiBinder = GWT.create(HomeworkViewImplUiBinder.class);

  interface HomeworkViewImplUiBinder extends UiBinder<Widget, HomeworkViewImpl> {
  }

  private Presenter presenter;

  @UiField
  TopPanel topPanel;

  @UiField
  MenuPanel menuPanel;

  @UiField
  FooterPanel footerPanel;

  public HomeworkViewImpl() {
    initWidget(uiBinder.createAndBindUi(this));
  }

  @Override
  public void setPresenter(Presenter p) {
    this.presenter = p;
  }

  @Override
  public HasMenus getHasMenus() {
    return menuPanel;
  }

}
