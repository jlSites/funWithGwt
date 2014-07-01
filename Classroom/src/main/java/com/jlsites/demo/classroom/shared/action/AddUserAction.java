package com.jlsites.demo.classroom.shared.action;

import net.customware.gwt.dispatch.shared.Action;

public class AddUserAction implements Action<AddUserResult> {

  private String userName;

  private byte[] pic;

  public AddUserAction() {
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getUserName() {
    return userName;
  }

  public byte[] getPic() {
    return pic;
  }

  public void setPic(byte[] pic) {
    this.pic = pic;
  }
}
