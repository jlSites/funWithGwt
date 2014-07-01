package com.jlsites.how2gwt.gwtwithdb.client;

import net.customware.gwt.dispatch.client.gin.StandardDispatchModule;

import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;

@GinModules({StandardDispatchModule.class, ClientGinModule.class})
public interface ClientGinjector extends Ginjector {
  MainView getMainPanel();
}
