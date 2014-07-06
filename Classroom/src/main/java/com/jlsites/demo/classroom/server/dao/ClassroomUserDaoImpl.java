package com.jlsites.demo.classroom.server.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.jlsites.demo.classroom.shared.domain.ClassroomUser;

@Repository(value = "classroomUserDao")
public class ClassroomUserDaoImpl implements ClassroomUserDao {

  private static final Logger LOG = LoggerFactory.getLogger(ClassroomUserDaoImpl.class);

  @PersistenceContext(unitName = "classroomUnit")
  private EntityManager entityMgr;

  @Override
  public ClassroomUser createUser(ClassroomUser user) {
    LOG.debug("saving " + user);
    return entityMgr.merge(user);
  }

  @Override
  public void delete(Long userId) {
    ClassroomUser found = entityMgr.find(ClassroomUser.class, userId);
    entityMgr.remove(found);
  }

  @Override
  public ClassroomUser updateUser(ClassroomUser user) {
    LOG.debug("updating " + user);
    return entityMgr.merge(user);
  }

  @Override
  public ClassroomUser get(Long userId) {
    return entityMgr.find(ClassroomUser.class, userId);
  }

  @Override
  public List<ClassroomUser> getAll() {
    Query query = entityMgr.createQuery("FROM ClassroomUser");
    return query.getResultList();
  }

}
