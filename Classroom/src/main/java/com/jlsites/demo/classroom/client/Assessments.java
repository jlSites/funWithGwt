package com.jlsites.demo.classroom.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class Assessments extends Composite {

  private static AssessmentsUiBinder uiBinder = GWT.create(AssessmentsUiBinder.class);

  interface AssessmentsUiBinder extends UiBinder<Widget, Assessments> {
  }

  public Assessments() {
    initWidget(uiBinder.createAndBindUi(this));
  }

}
