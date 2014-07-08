package com.jlsites.demo.classroom.client.ui;

import com.google.gwt.event.dom.client.HasClickHandlers;

public interface HasMenus {
  HasClickHandlers getHome();

  HasClickHandlers getHomework();

  HasClickHandlers getAssessments();

  HasClickHandlers getMoreAboutTeacher();

  HasClickHandlers getUploadFiles();
}
