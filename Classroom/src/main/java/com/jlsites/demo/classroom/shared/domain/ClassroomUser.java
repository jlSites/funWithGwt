package com.jlsites.demo.classroom.shared.domain;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "CLASSROOM_USER")
public class ClassroomUser implements Serializable {
  private static final long serialVersionUID = 105591614076568595L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "USER_ID")
  private long userId;

  @Column(name = "USER_NAME", nullable = false, length = 30, unique = true)
  private String userName;

  @Column(name = "FAMILY_NAME", nullable = true, length = 30)
  private String familyName;

  @Column(name = "GIVEN_NAMES", nullable = true, length = 30)
  private String givenNames;

  @Column(name = "ROLE", nullable = false)
  @Enumerated(EnumType.STRING)
  private ClassroomRole role;

  @Lob
  @Basic(fetch = FetchType.LAZY)
  @Column(name = "PIC", columnDefinition = "BLOB NULL")
  protected byte[] pic;

  public ClassroomUser() {
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
