package com.jlsites.demo.classroom.server.services;

import java.util.List;

import com.jlsites.demo.classroom.shared.domain.HappyUser;

public interface HappyUserService {
  HappyUser createUser(HappyUser user);

  void delete(Long userId);

  HappyUser updateUser(HappyUser user);

  HappyUser get(Long userId);

  List<HappyUser> getAll();
}
