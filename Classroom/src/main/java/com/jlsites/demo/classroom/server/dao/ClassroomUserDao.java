package com.jlsites.demo.classroom.server.dao;

import java.util.List;

import com.jlsites.demo.classroom.shared.domain.ClassroomUser;

public interface ClassroomUserDao {

	ClassroomUser createUser(ClassroomUser user);

	void delete(Long userId);

	ClassroomUser updateUser(ClassroomUser user);

	ClassroomUser get(Long userId);

	List<ClassroomUser> getAll();

}
