package com.jlsites.demo.classroom.client.activity;

import net.customware.gwt.dispatch.client.DispatchAsync;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;
import com.jlsites.demo.classroom.client.ui.HomeView;

public class HomeActivity extends BasicActivity implements HomeView.Presenter {

	private HomeView view;

	@Inject
	public HomeActivity(HomeView view, PlaceController placeController,
			DispatchAsync dispatchAsync) {
		super(view.getHasMenus(), placeController, dispatchAsync);
		this.view = view;
	}

	/**
	 * Invoked by the ActivityManager to start a new Activity
	 */
	@Override
	public void start(AcceptsOneWidget containerWidget, EventBus eventBus) {
		view.setPresenter(this);
		containerWidget.setWidget(view.asWidget());
	}
}
