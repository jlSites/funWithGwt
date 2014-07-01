package com.jlsites.how2gwt.gwtwithdb.server.handler;

import net.customware.gwt.dispatch.server.ExecutionContext;
import net.customware.gwt.dispatch.server.SimpleActionHandler;
import net.customware.gwt.dispatch.shared.DispatchException;

import com.jlsites.how2gwt.gwtwithdb.shared.action.CanDispatchAction;
import com.jlsites.how2gwt.gwtwithdb.shared.action.CanDispatchResult;

public class CanDispatchActionHandler extends
    SimpleActionHandler<CanDispatchAction, CanDispatchResult> {

  @Override
  public CanDispatchResult execute(CanDispatchAction action, ExecutionContext context)
      throws DispatchException {
    return new CanDispatchResult();
  }
}
