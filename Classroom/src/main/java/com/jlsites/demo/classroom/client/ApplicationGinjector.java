package com.jlsites.demo.classroom.client;

import net.customware.gwt.dispatch.client.gin.StandardDispatchModule;

import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.jlsites.demo.classroom.client.ui.MainView;

@GinModules({ StandardDispatchModule.class, ApplicationGinModule.class })
public interface ApplicationGinjector extends Ginjector {
	MainView getAppWidget();

	PlaceHistoryHandler getPlaceHistoryHandler();
}
