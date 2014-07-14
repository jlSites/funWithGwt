package com.jlsites.demo.classroom.client.activity;

import net.customware.gwt.dispatch.client.DispatchAsync;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.jlsites.demo.classroom.client.place.AssessmentsPlace;
import com.jlsites.demo.classroom.client.place.HomePlace;
import com.jlsites.demo.classroom.client.place.HomeworkPlace;
import com.jlsites.demo.classroom.client.place.MoreAboutTeacherPlace;
import com.jlsites.demo.classroom.client.place.UploadFilesPlace;
import com.jlsites.demo.classroom.client.ui.HasMenus;

public abstract class BasicActivity extends AbstractActivity {
	protected PlaceController placeController;
	private HasMenus hasMenus;
	protected DispatchAsync dispatchAsync;

	public BasicActivity(HasMenus hasMenus, PlaceController placeController,
			DispatchAsync dispatchAsync) {
		this.hasMenus = hasMenus;
		this.placeController = placeController;
		this.dispatchAsync = dispatchAsync;

		bindMenus();
	}

	public void bindMenus() {
		MenuClickHandler menuHandler = new MenuClickHandler();
		hasMenus.getHome().addClickHandler(menuHandler);
		hasMenus.getHomework().addClickHandler(menuHandler);
		hasMenus.getAssessments().addClickHandler(menuHandler);
		hasMenus.getMoreAboutTeacher().addClickHandler(menuHandler);
		hasMenus.getUploadFiles().addClickHandler(menuHandler);
	}

	/**
	 * Navigate to a new Place in the browser
	 */
	public void goTo(Place place) {
		placeController.goTo(place);
	}

	class MenuClickHandler implements ClickHandler {
		@Override
		public void onClick(ClickEvent event) {
			Object eSource = event.getSource();
			if (eSource == hasMenus.getHome()) {
				placeController.goTo(new HomePlace());
			} else if (eSource == hasMenus.getHomework()) {
				placeController.goTo(new HomeworkPlace());
			} else if (eSource == hasMenus.getAssessments()) {
				placeController.goTo(new AssessmentsPlace());
			} else if (eSource == hasMenus.getMoreAboutTeacher()) {
				placeController.goTo(new MoreAboutTeacherPlace());
			} else if (eSource == hasMenus.getUploadFiles()) {
				placeController.goTo(new UploadFilesPlace());
			}
		}
	}
}
