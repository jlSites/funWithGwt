package com.jlsites.how2gwt.gwtwithdb.server.handler;

import net.customware.gwt.dispatch.server.ExecutionContext;
import net.customware.gwt.dispatch.server.SimpleActionHandler;
import net.customware.gwt.dispatch.shared.DispatchException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jlsites.how2gwt.gwtwithdb.server.services.HappyUserService;
import com.jlsites.how2gwt.gwtwithdb.shared.action.GetAllUsersAction;
import com.jlsites.how2gwt.gwtwithdb.shared.action.GetAllUsersResult;

public class GetAllUsersActionHandler extends
    SimpleActionHandler<GetAllUsersAction, GetAllUsersResult> {
  private static final Logger LOGGER = LoggerFactory.getLogger(GetAllUsersActionHandler.class);
  private HappyUserService userService;

  public GetAllUsersActionHandler(HappyUserService userService) {
    this.userService = userService;
  }

  @Override
  public GetAllUsersResult execute(GetAllUsersAction action, ExecutionContext context)
      throws DispatchException {
    LOGGER.debug(">>GetAllUsersActionHandler.execute");

    // get all users
    GetAllUsersResult rlt = new GetAllUsersResult();
    rlt.getAllUsers().addAll(userService.getAll());

    return rlt;
  }

}
