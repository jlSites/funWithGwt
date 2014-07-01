package com.jlsites.demo.classroom.shared.action;

import java.util.ArrayList;
import java.util.List;

import com.jlsites.demo.classroom.shared.domain.HappyUser;

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
