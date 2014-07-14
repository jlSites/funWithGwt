package com.jlsites.demo.classroom.client.activity;

import gwtupload.client.IUploadStatus.Status;
import gwtupload.client.IUploader;
import gwtupload.client.IUploader.OnFinishUploaderHandler;
import gwtupload.client.IUploader.UploadedInfo;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;
import com.jlsites.demo.classroom.client.ui.UploadFilesView;

public class UploadFilesActivity extends BasicActivity implements
		UploadFilesView.Presenter {

	private Logger logger = Logger.getLogger(getClass().getName());

	private UploadFilesView view;

	@Inject
	public UploadFilesActivity(UploadFilesView view,
			PlaceController placeController) {
		super(view.getHasMenus(), placeController);
		this.view = view;

		bindUploader();
	}

	private void bindUploader() {
		UploaderHandler handler = new UploaderHandler();
		view.getUploader().addOnFinishUploadHandler(handler);
	}

	/**
	 * Invoked by the ActivityManager to start a new Activity
	 */
	@Override
	public void start(AcceptsOneWidget containerWidget, EventBus eventBus) {
		view.setPresenter(this);
		containerWidget.setWidget(view.asWidget());
	}

	class UploaderHandler implements OnFinishUploaderHandler {
		@Override
		public void onFinish(IUploader uploader) {
			if (uploader.getStatus() == Status.SUCCESS) {
				UploadedInfo serverInfo = uploader.getServerInfo();
				logger.log(Level.INFO, "fileUrl=" + serverInfo.getFileUrl());
				logger.log(Level.INFO, "fileName=" + serverInfo.getFileName());
				logger.log(Level.INFO, "size=" + serverInfo.getSize());
				logger.log(Level.INFO, "ctype=" + serverInfo.getCtype());
			}
		}

	}
}
