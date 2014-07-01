package com.jlsites.how2gwt.gwtwithdb.shared.action;

import java.util.ArrayList;
import java.util.List;

import net.customware.gwt.dispatch.shared.Result;

import com.jlsites.how2gwt.gwtwithdb.shared.domain.HappyUser;

public class GetAllUsersResult implements Result {

  private List<HappyUser> allUsers;

  public GetAllUsersResult() {
  }

  public List<HappyUser> getAllUsers() {
    if (allUsers == null) {
      allUsers = new ArrayList<HappyUser>();
    }
    return allUsers;
  }
}
