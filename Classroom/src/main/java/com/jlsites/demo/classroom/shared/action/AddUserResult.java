package com.jlsites.demo.classroom.shared.action;

import java.util.ArrayList;
import java.util.List;

import com.jlsites.demo.classroom.shared.domain.ClassroomUser;

import net.customware.gwt.dispatch.shared.Result;

public class AddUserResult implements Result {

	private List<ClassroomUser> allUsers;

	public AddUserResult() {
	}

	public List<ClassroomUser> getAllUsers() {
		if (allUsers == null) {
			allUsers = new ArrayList<ClassroomUser>();
		}
		return allUsers;
	}

}
