package com.jlsites.demo.classroom.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class AssessmentsPlace extends Place {
  private String token;

  public AssessmentsPlace(String strToken) {
    token = strToken;
  }

  public String getToken() {
    return token;
  }

  public static class Tokenizer implements PlaceTokenizer<AssessmentsPlace> {

    @Override
    public String getToken(AssessmentsPlace place) {
      return place.getToken();
    }

    @Override
    public AssessmentsPlace getPlace(String token) {
      return new AssessmentsPlace(token);
    }

  }
}
