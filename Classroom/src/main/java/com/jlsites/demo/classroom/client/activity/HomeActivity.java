package com.jlsites.demo.classroom.client.activity;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;
import com.jlsites.demo.classroom.client.place.AssessmentsPlace;
import com.jlsites.demo.classroom.client.place.HomePlace;
import com.jlsites.demo.classroom.client.place.HomeworkPlace;
import com.jlsites.demo.classroom.client.place.MoreAboutTeacherPlace;
import com.jlsites.demo.classroom.client.ui.HasMenus;
import com.jlsites.demo.classroom.client.ui.HomeView;

public class HomeActivity extends AbstractActivity implements HomeView.Presenter {

  private HomeView view;
  private PlaceController placeController;

  @Inject
  public HomeActivity(HomeView view, PlaceController placeController) {
    this.view = view;
    this.placeController = placeController;

    bindMenus();
  }

  /**
   * Invoked by the ActivityManager to start a new Activity
   */
  @Override
  public void start(AcceptsOneWidget containerWidget, EventBus eventBus) {
    view.setPresenter(this);
    containerWidget.setWidget(view.asWidget());
  }

  /**
   * Navigate to a new Place in the browser
   */
  @Override
  public void goTo(Place place) {
    placeController.goTo(place);
  }

  public void bindMenus() {
    MenuClickHandler menuHandler = new MenuClickHandler();
    view.getHasMenus().getHome().addClickHandler(menuHandler);
    view.getHasMenus().getHomework().addClickHandler(menuHandler);
    view.getHasMenus().getAssessments().addClickHandler(menuHandler);
    view.getHasMenus().getMoreAboutTeacher().addClickHandler(menuHandler);
  }

  class MenuClickHandler implements ClickHandler {
    @Override
    public void onClick(ClickEvent event) {
      HasMenus hasMenus = view.getHasMenus();
      Object eSource = event.getSource();
      if (eSource == hasMenus.getHome()) {
        goTo(new HomePlace());
      } else if (eSource == hasMenus.getHomework()) {
        goTo(new HomeworkPlace());
      } else if (eSource == hasMenus.getAssessments()) {
        goTo(new AssessmentsPlace());
      } else if (eSource == hasMenus.getMoreAboutTeacher()) {
        goTo(new MoreAboutTeacherPlace());
      }
    }
  }
}
