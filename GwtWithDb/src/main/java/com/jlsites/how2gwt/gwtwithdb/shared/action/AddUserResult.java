package com.jlsites.how2gwt.gwtwithdb.shared.action;

import java.util.ArrayList;
import java.util.List;

import com.jlsites.how2gwt.gwtwithdb.shared.domain.HappyUser;

import net.customware.gwt.dispatch.shared.Result;

public class AddUserResult implements Result {

  private List<HappyUser> allUsers;

  public AddUserResult() {
  }

  public List<HappyUser> getAllUsers() {
    if (allUsers == null) {
      allUsers = new ArrayList<HappyUser>();
    }
    return allUsers;
  }

}
