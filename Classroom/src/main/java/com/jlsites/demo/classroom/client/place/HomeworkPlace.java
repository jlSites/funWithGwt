package com.jlsites.demo.classroom.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class HomeworkPlace extends Place {
	private static final String TOKEN = "HOMEWORK";
	private String token;

	public HomeworkPlace() {
		this(TOKEN);
	}

	private HomeworkPlace(String strToken) {
		token = strToken;
	}

	public String getToken() {
		return token;
	}

	public static class Tokenizer implements PlaceTokenizer<HomeworkPlace> {

		@Override
		public String getToken(HomeworkPlace place) {
			return place.getToken();
		}

		@Override
		public HomeworkPlace getPlace(String token) {
			return new HomeworkPlace(token);
		}

	}
}
