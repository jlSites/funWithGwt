package com.jlsites.demo.classroom.shared.action;

import java.util.ArrayList;
import java.util.List;

import net.customware.gwt.dispatch.shared.Result;

import com.jlsites.demo.classroom.shared.domain.HappyUser;

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
