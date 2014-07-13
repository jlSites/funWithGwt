package com.jlsites.demo.classroom.client.ui;

import com.google.gwt.inject.client.AbstractGinModule;
import com.google.inject.Singleton;

public class ViewModule extends AbstractGinModule {

	@Override
	protected void configure() {
		bind(HomeView.class).to(HomeViewImpl.class).in(Singleton.class);
		bind(HomeworkView.class).to(HomeworkViewImpl.class).in(Singleton.class);
		bind(UploadFilesView.class).to(UploadFilesViewImpl.class).in(
				Singleton.class);
	}

}