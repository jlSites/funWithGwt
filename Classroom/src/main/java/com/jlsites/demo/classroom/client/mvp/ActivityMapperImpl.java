package com.jlsites.demo.classroom.client.mvp;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.google.inject.Inject;
import com.jlsites.demo.classroom.client.activity.HomeActivity;
import com.jlsites.demo.classroom.client.activity.HomeworkActivity;
import com.jlsites.demo.classroom.client.place.HomePlace;
import com.jlsites.demo.classroom.client.place.HomeworkPlace;

public class ActivityMapperImpl implements ActivityMapper {

  @Inject
  private HomeActivity homeActivity;

  @Inject
  private HomeworkActivity homeworkActivity;

  public ActivityMapperImpl() {
    super();
  }

  @Override
  public Activity getActivity(Place place) {
    if (place instanceof HomePlace) {
      return homeActivity;
    } else if (place instanceof HomeworkPlace) {
      return homeworkActivity;
    }

    return null;
  }

}
