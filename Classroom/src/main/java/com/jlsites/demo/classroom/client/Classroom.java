package com.jlsites.demo.classroom.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.CssResource.NotStrict;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Classroom implements EntryPoint {

	interface GlobalResources extends ClientBundle {
		@NotStrict
		@Source("global.css")
		CssResource css();
	}

	private final ApplicationGinjector ginjector = GWT
			.create(ApplicationGinjector.class);

	public void onModuleLoad() {
		// Inject global styles.
		GWT.<GlobalResources> create(GlobalResources.class).css()
				.ensureInjected();

		RootPanel.get().add(ginjector.getAppWidget());

		// Goes to place represented on URL or default place
		ginjector.getPlaceHistoryHandler().handleCurrentHistory();
	}
}
