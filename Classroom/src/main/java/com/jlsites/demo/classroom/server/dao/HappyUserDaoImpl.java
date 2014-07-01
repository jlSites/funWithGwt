package com.jlsites.demo.classroom.server.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.jlsites.demo.classroom.shared.domain.HappyUser;

@Repository(value = "happyUserDao")
public class HappyUserDaoImpl implements HappyUserDao {

  private static final Logger LOG = LoggerFactory.getLogger(HappyUserDaoImpl.class);

  @PersistenceContext(unitName = "classroomUnit")
  private EntityManager entityMgr;

  @Override
  public HappyUser createUser(HappyUser user) {
    LOG.debug("saving " + user);
    return entityMgr.merge(user);
  }

  @Override
  public void delete(Long userId) {
    HappyUser found = entityMgr.find(HappyUser.class, userId);
    entityMgr.remove(found);
  }

  @Override
  public HappyUser updateUser(HappyUser user) {
    LOG.debug("updating " + user);
    return entityMgr.merge(user);
  }

  @Override
  public HappyUser get(Long userId) {
    return entityMgr.find(HappyUser.class, userId);
  }

  @Override
  public List<HappyUser> getAll() {
    Query query = entityMgr.createQuery("FROM HappyUser");
    return query.getResultList();
  }

}
