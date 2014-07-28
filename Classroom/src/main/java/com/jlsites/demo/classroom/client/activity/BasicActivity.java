package com.jlsites.demo.classroom.client.activity;

import gwtupload.client.IUploader;
import gwtupload.client.IUploadStatus.Status;
import gwtupload.client.IUploader.OnFinishUploaderHandler;
import gwtupload.client.IUploader.UploadedInfo;

import java.util.logging.Level;
import java.util.logging.Logger;

import net.customware.gwt.dispatch.client.DispatchAsync;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.Random;
import com.jlsites.demo.classroom.client.activity.UploadFilesActivity.UploaderHandler;
import com.jlsites.demo.classroom.client.place.AssessmentsPlace;
import com.jlsites.demo.classroom.client.place.HomePlace;
import com.jlsites.demo.classroom.client.place.HomeworkPlace;
import com.jlsites.demo.classroom.client.place.MoreAboutTeacherPlace;
import com.jlsites.demo.classroom.client.place.UploadFilesPlace;
import com.jlsites.demo.classroom.client.ui.HasMenus;

public abstract class BasicActivity extends AbstractActivity {
	private Logger logger = Logger.getLogger(getClass().getName());

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

		UploadTeacherHandler uploadTeacherHandler = new UploadTeacherHandler();
		hasMenus.getUpdateTeacherPhoto().addOnFinishUploadHandler(
				uploadTeacherHandler);
	}

	/**
	 * Navigate to a new Place in the browser
	 */
	public void goTo(Place place) {
		placeController.goTo(place);
	}

	class UploadTeacherHandler implements OnFinishUploaderHandler {
		@Override
		public void onFinish(IUploader uploader) {
			if (uploader.getStatus() == Status.SUCCESS) {
				UploadedInfo serverInfo = uploader.getServerInfo();
				logger.log(Level.INFO, "fileUrl=" + serverInfo.getFileUrl());
				logger.log(Level.INFO, "fileName=" + serverInfo.getFileName());
				hasMenus.updateTeacher(serverInfo.getFileName() + "?v"
						+ Random.nextInt());
			}
		}

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
