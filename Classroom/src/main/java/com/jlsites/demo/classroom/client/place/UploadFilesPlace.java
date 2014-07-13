package com.jlsites.demo.classroom.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class UploadFilesPlace extends Place {
	private static final String TOKEN = "UPLOADFILES";
	private String token;

	public UploadFilesPlace() {
		this(TOKEN);
	}

	private UploadFilesPlace(String strToken) {
		token = strToken;
	}

	public String getToken() {
		return token;
	}

	public static class Tokenizer implements PlaceTokenizer<UploadFilesPlace> {

		@Override
		public String getToken(UploadFilesPlace place) {
			return place.getToken();
		}

		@Override
		public UploadFilesPlace getPlace(String token) {
			return new UploadFilesPlace(token);
		}

	}
}
