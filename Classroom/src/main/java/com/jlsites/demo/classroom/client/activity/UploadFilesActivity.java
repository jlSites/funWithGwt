package com.jlsites.demo.classroom.client.activity;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;
import com.jlsites.demo.classroom.client.ui.UploadFilesView;

public class UploadFilesActivity extends BasicActivity implements
		UploadFilesView.Presenter {

	private UploadFilesView view;

	@Inject
	public UploadFilesActivity(UploadFilesView view,
			PlaceController placeController) {
		super(view.getHasMenus(), placeController);
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
