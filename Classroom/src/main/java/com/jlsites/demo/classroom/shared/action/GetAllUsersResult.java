package com.jlsites.demo.classroom.shared.action;

import java.util.ArrayList;
import java.util.List;

import net.customware.gwt.dispatch.shared.Result;

import com.jlsites.demo.classroom.shared.domain.ClassroomUser;

public class GetAllUsersResult implements Result {

	private List<ClassroomUser> allUsers;

	public GetAllUsersResult() {
	}

	public List<ClassroomUser> getAllUsers() {
		if (allUsers == null) {
			allUsers = new ArrayList<ClassroomUser>();
		}
		return allUsers;
	}
}
