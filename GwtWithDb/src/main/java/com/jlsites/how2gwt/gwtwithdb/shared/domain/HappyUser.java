package com.jlsites.how2gwt.gwtwithdb.shared.domain;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "HAPPY_USER")
public class HappyUser implements Serializable {

  private static final long serialVersionUID = -6194506054212510220L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "USER_ID")
  private long userId;

  @Column(name = "USER_NAME", nullable = false, length = 30, unique = true)
  private String userName;

  @Lob
  @Basic(fetch = FetchType.LAZY)
  @Column(name = "USER_PIC", columnDefinition = "BLOB NOT NULL")
  protected byte[] pic;

  public HappyUser() {
  }

  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public void setPic(byte[] pic) {
    this.pic = pic;
  }

  public byte[] getPic() {
    return pic;
  }
}
