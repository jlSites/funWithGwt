package com.jlsites.demo.classroom.server.services;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jlsites.demo.classroom.server.dao.HappyUserDao;
import com.jlsites.demo.classroom.shared.domain.HappyUser;

@Service(value = "HappyUserServiceImpl")
@Transactional
public class HappyUserServiceImpl implements HappyUserService {
  private static final Logger LOG = LoggerFactory.getLogger(HappyUserServiceImpl.class);

  private HappyUserDao userDao;

  @Autowired
  public HappyUserServiceImpl(HappyUserDao userDao) {
    this.userDao = userDao;
  }

  @Override
  public HappyUser createUser(HappyUser user) {
    LOG.debug("createUser=" + user);
    return userDao.createUser(user);
  }

  @Override
  public void delete(Long userId) {
    userDao.delete(userId);
  }

  @Override
  public HappyUser updateUser(HappyUser user) {
    return userDao.updateUser(user);
  }

  @Override
  public HappyUser get(Long userId) {
    return userDao.get(userId);
  }

  @Override
  public List<HappyUser> getAll() {
    return userDao.getAll();
  }

}
