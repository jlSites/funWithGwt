package com.jlsites.demo.classroom.client.activity;

import gwtupload.client.IUploadStatus.Status;
import gwtupload.client.IUploader;
import gwtupload.client.IUploader.OnFinishUploaderHandler;
import gwtupload.client.IUploader.UploadedInfo;

import java.util.logging.Level;
import java.util.logging.Logger;

import net.customware.gwt.dispatch.client.DispatchAsync;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;
import com.jlsites.demo.classroom.client.ui.UploadFilesView;
import com.jlsites.demo.classroom.shared.action.ListUploadsAction;
import com.jlsites.demo.classroom.shared.action.ListUploadsResult;
import com.jlsites.demo.core.client.InforDialog;

public class UploadFilesActivity extends BasicActivity implements
		UploadFilesView.Presenter {

	private Logger logger = Logger.getLogger(getClass().getName());

	private UploadFilesView view;

	@Inject
	public UploadFilesActivity(UploadFilesView view,
			PlaceController placeController, DispatchAsync dispatchAsync) {
		super(view.getHasMenus(), placeController, dispatchAsync);
		this.view = view;

		bind();
	}

	private void bind() {
		UploaderHandler uploaderHandler = new UploaderHandler();
		view.getUploader().addOnFinishUploadHandler(uploaderHandler);

		ClickHandlerImpl clickHandler = new ClickHandlerImpl();
		view.getBtnListFiles().addClickHandler(clickHandler);
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

	class ClickHandlerImpl implements ClickHandler {
		@Override
		public void onClick(ClickEvent event) {
			if (event.getSource() == view.getBtnListFiles()) {
				listUploads();
			}
		}

	}

	public void listUploads() {
		ListUploadsAction action = new ListUploadsAction();
		dispatchAsync.execute(action, new AsyncCallback<ListUploadsResult>() {

			@Override
			public void onFailure(Throwable caught) {
				InforDialog dlg = new InforDialog();
				dlg.setText("Error");
				dlg.setMessage("failed. details=" + caught.getMessage());
				dlg.center();
			}

			@Override
			public void onSuccess(ListUploadsResult result) {
				InforDialog dlg = new InforDialog();
				dlg.setText("Success");
				dlg.setMessage("ok=" + result.getAllItems().size());
				dlg.center();
			}
		});
	}
}
