package com.jlsites.demo.classroom.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class HomeworkAssignmentsContent extends Composite {

  private static HomeworkAssignmentsUiBinder uiBinder = GWT
      .create(HomeworkAssignmentsUiBinder.class);

  interface HomeworkAssignmentsUiBinder extends UiBinder<Widget, HomeworkAssignmentsContent> {
  }

  public HomeworkAssignmentsContent() {
    initWidget(uiBinder.createAndBindUi(this));
  }

}
