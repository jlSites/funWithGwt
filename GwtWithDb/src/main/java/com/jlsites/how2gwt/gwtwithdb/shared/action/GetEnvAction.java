package com.jlsites.how2gwt.gwtwithdb.shared.action;

import net.customware.gwt.dispatch.shared.Action;

public class GetEnvAction implements Action<GetEnvResult> {

  public static final String CATALINA_BASE = "CATALINA_BASE";
  public static final String CLASSPATH = "CLASSPATH";
  public static final String JRE_HOME = "JRE_HOME";

  public GetEnvAction() {
  }
}
