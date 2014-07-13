package com.jlsites.demo.classroom.client.activity;

import com.google.gwt.inject.client.AbstractGinModule;

public class ActivityModule extends AbstractGinModule {

	@Override
	protected void configure() {
		bind(HomeActivity.class);
		bind(HomeworkActivity.class);
		bind(UploadFilesActivity.class);

	}

}