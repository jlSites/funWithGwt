package com.jlsites.demo.classroom.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class MoreAboutTeacherPlace extends Place {
	private static final String TOKEN = "MOREABOUTTEACHER";
	private String token;

	public MoreAboutTeacherPlace() {
		this(TOKEN);
	}

	private MoreAboutTeacherPlace(String strToken) {
		token = strToken;
	}

	public String getToken() {
		return token;
	}

	public static class Tokenizer implements
			PlaceTokenizer<MoreAboutTeacherPlace> {

		@Override
		public String getToken(MoreAboutTeacherPlace place) {
			return place.getToken();
		}

		@Override
		public MoreAboutTeacherPlace getPlace(String token) {
			return new MoreAboutTeacherPlace(token);
		}

	}
}
