package com.jlsites.how2gwt.gwtwithdb.server.handler;

import net.customware.gwt.dispatch.server.ExecutionContext;
import net.customware.gwt.dispatch.server.SimpleActionHandler;
import net.customware.gwt.dispatch.shared.DispatchException;

import com.jlsites.how2gwt.gwtwithdb.shared.action.GetEnvAction;
import com.jlsites.how2gwt.gwtwithdb.shared.action.GetEnvResult;

public class GetEnvActionHandler extends SimpleActionHandler<GetEnvAction, GetEnvResult> {

  @Override
  public GetEnvResult execute(GetEnvAction action, ExecutionContext context)
      throws DispatchException {
    GetEnvResult result = new GetEnvResult();
    result.putEnv(GetEnvAction.JRE_HOME, System.getenv(GetEnvAction.JRE_HOME));
    result.putEnv(GetEnvAction.CLASSPATH, System.getenv(GetEnvAction.CLASSPATH));
    result.putEnv(GetEnvAction.CATALINA_BASE, System.getenv(GetEnvAction.CATALINA_BASE));
    return result;
  }
}
