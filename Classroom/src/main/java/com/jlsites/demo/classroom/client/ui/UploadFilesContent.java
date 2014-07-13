package com.jlsites.demo.classroom.client.ui;

import gwtupload.client.SingleUploader;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class UploadFilesContent extends Composite {

	private static UploadFilesContentUiBinder uiBinder = GWT
			.create(UploadFilesContentUiBinder.class);

	interface UploadFilesContentUiBinder extends
			UiBinder<Widget, UploadFilesContent> {
	}

	@UiField
	SingleUploader uploader;

	public UploadFilesContent() {
		initWidget(uiBinder.createAndBindUi(this));
	}

}
