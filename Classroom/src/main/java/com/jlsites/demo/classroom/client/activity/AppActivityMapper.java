package com.jlsites.demo.classroom.client.activity;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;

public class AppActivityMapper implements ActivityMapper {

  public AppActivityMapper() {
    super();
  }

  /**
   * Map each Place to its corresponding Activity. This would be a great use for GIN.
   */
  @Override
  public Activity getActivity(Place place) {
    //TODO 
    // This is begging for GIN
    // if (place instanceof HelloPlace)
    // return new HelloActivity((HelloPlace) place, clientFactory);
    // else if (place instanceof GoodbyePlace)
    // return new GoodbyeActivity((GoodbyePlace) place, clientFactory);

    return null;
  }

}
