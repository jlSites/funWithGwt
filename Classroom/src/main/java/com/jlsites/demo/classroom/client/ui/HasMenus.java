package com.jlsites.demo.classroom.client.ui;

import gwtupload.client.IUploader;

import com.google.gwt.event.dom.client.HasClickHandlers;

public interface HasMenus {
	HasClickHandlers getHome();

	HasClickHandlers getHomework();

	HasClickHandlers getAssessments();

	HasClickHandlers getMoreAboutTeacher();

	HasClickHandlers getUploadFiles();

	IUploader getUpdateTeacherPhoto();

	void updateTeacher(String updatedImageName);
}
