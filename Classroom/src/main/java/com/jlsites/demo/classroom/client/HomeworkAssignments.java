package com.jlsites.demo.classroom.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class HomeworkAssignments extends Composite {

  private static HomeworkAssignmentsUiBinder uiBinder = GWT
      .create(HomeworkAssignmentsUiBinder.class);

  interface HomeworkAssignmentsUiBinder extends UiBinder<Widget, HomeworkAssignments> {
  }

  public HomeworkAssignments() {
    initWidget(uiBinder.createAndBindUi(this));
  }

}
