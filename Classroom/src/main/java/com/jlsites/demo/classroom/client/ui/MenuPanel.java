package com.jlsites.demo.classroom.client.ui;

import gwtupload.client.IUploader;
import gwtupload.client.SingleUploader;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Image;

public class MenuPanel extends Composite implements HasMenus {

	private static MenuPanelUiBinder uiBinder = GWT
			.create(MenuPanelUiBinder.class);

	interface MenuPanelUiBinder extends UiBinder<HTMLPanel, MenuPanel> {
	}

	@UiField
	Anchor homeAnchor;
	@UiField
	Anchor homeworkAnchor;
	@UiField
	Anchor assessmentsAnchor;
	@UiField
	Anchor clickTeacherAnchor;
	@UiField
	Anchor announcementsAnchor;
	@UiField
	Anchor calendarAnchor;
	@UiField
	Anchor readingListAnchor;
	@UiField
	Anchor usefulLinksAnchor;
	@UiField
	Anchor photosAnchor;
	@UiField
	Anchor formsAndDocsAnchor;
	@UiField
	Anchor currentPollAnchor;
	@UiField
	Anchor uploadFilesAnchor;

	@UiField
	SingleUploader updateTeacherPhoto;
	@UiField
	Image teacherImage;

	public MenuPanel() {
		initWidget(uiBinder.createAndBindUi(this));

		updateTeacherPhoto.getFileInput().setText("Change Photo...");
	}

	@Override
	public IUploader getUpdateTeacherPhoto() {
		return updateTeacherPhoto;
	}

	@Override
	public void updateTeacher(String updatedImageName) {
		// FIXME is it safe?
		teacherImage.setUrl("/uploads/" + updatedImageName);
	}

	@Override
	public HasClickHandlers getHome() {
		return homeAnchor;
	}

	@Override
	public HasClickHandlers getHomework() {
		return homeworkAnchor;
	}

	@Override
	public HasClickHandlers getAssessments() {
		return assessmentsAnchor;
	}

	@Override
	public HasClickHandlers getMoreAboutTeacher() {
		return clickTeacherAnchor;
	}

	@Override
	public HasClickHandlers getUploadFiles() {
		return uploadFilesAnchor;
	}

}
