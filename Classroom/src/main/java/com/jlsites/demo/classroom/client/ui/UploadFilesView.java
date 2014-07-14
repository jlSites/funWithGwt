package com.jlsites.demo.classroom.client.ui;

import gwtupload.client.IUploader;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;

public interface UploadFilesView extends IsWidget {

	interface Presenter {
		void goTo(Place place);
	}

	void setPresenter(Presenter p);

	HasMenus getHasMenus();

	IUploader getUploader();

	HasClickHandlers getBtnListFiles();
}
