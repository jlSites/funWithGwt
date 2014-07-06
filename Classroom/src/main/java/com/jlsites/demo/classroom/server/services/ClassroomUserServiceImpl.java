package com.jlsites.demo.classroom.server.services;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jlsites.demo.classroom.server.dao.ClassroomUserDao;
import com.jlsites.demo.classroom.shared.domain.ClassroomUser;

@Service(value = "ClassroomUserServiceImpl")
@Transactional
public class ClassroomUserServiceImpl implements ClassroomUserService {
  private static final Logger LOG = LoggerFactory.getLogger(ClassroomUserServiceImpl.class);

  private ClassroomUserDao userDao;

  @Autowired
  public ClassroomUserServiceImpl(ClassroomUserDao userDao) {
    this.userDao = userDao;
  }

  @Override
  public ClassroomUser createUser(ClassroomUser user) {
    LOG.debug("createUser=" + user);
    return userDao.createUser(user);
  }

  @Override
  public void delete(Long userId) {
    userDao.delete(userId);
  }

  @Override
  public ClassroomUser updateUser(ClassroomUser user) {
    return userDao.updateUser(user);
  }

  @Override
  public ClassroomUser get(Long userId) {
    return userDao.get(userId);
  }

  @Override
  public List<ClassroomUser> getAll() {
    return userDao.getAll();
  }

}
