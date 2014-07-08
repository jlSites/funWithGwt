package com.jlsites.demo.classroom.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class UploadFilesViewImpl extends Composite implements UploadFilesView {

  private static UploadFilesViewImplUiBinder uiBinder = GWT
      .create(UploadFilesViewImplUiBinder.class);

  interface UploadFilesViewImplUiBinder extends UiBinder<Widget, UploadFilesViewImpl> {
  }

  private Presenter presenter;

  @UiField
  TopPanel topPanel;

  @UiField
  MenuPanel menuPanel;

  @UiField
  FooterPanel footerPanel;

  public UploadFilesViewImpl() {
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
