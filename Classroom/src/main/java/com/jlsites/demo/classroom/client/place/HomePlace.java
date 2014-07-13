package com.jlsites.demo.classroom.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class HomePlace extends Place {
	private static final String TOKEN = "HOME";
	private String token;

	public HomePlace() {
		this(TOKEN);
	}

	private HomePlace(String strToken) {
		token = strToken;
	}

	public String getToken() {
		return token;
	}

	public static class Tokenizer implements PlaceTokenizer<HomePlace> {

		@Override
		public String getToken(HomePlace place) {
			return place.getToken();
		}

		@Override
		public HomePlace getPlace(String token) {
			return new HomePlace(token);
		}

	}
}
