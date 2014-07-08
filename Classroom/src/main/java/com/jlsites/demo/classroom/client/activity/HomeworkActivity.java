package com.jlsites.demo.classroom.client.activity;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;
import com.jlsites.demo.classroom.client.ui.HomeworkView;

public class HomeworkActivity extends BasicActivity implements HomeworkView.Presenter {

  private HomeworkView view;

  @Inject
  public HomeworkActivity(HomeworkView view, PlaceController placeController) {
    super(view.getHasMenus(), placeController);
    this.view = view;
  }

  /**
   * Invoked by the ActivityManager to start a new Activity
   */
  @Override
  public void start(AcceptsOneWidget containerWidget, EventBus eventBus) {
    view.setPresenter(this);
    containerWidget.setWidget(view.asWidget());
  }
}
