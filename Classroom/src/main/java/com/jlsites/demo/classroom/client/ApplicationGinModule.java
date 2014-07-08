package com.jlsites.demo.classroom.client;

import com.google.gwt.inject.client.AbstractGinModule;
import com.jlsites.demo.classroom.client.activity.ActivityModule;
import com.jlsites.demo.classroom.client.mvp.MvpModule;
import com.jlsites.demo.classroom.client.ui.MainView;
import com.jlsites.demo.classroom.client.ui.ViewModule;

public class ApplicationGinModule extends AbstractGinModule {

  protected void configure() {
    // declare a binding for the display area. You may need to use annotations
    // to identify the various display areas to match them to the right activity
    // manager.
    bind(MainView.class);

    // install the Gin module used to setup the GWT MVP framework classes.
    install(new ActivityModule());
    install(new MvpModule());
    install(new ViewModule());
  }

}