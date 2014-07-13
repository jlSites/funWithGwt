package com.jlsites.demo.classroom.server.handler;

import net.customware.gwt.dispatch.server.ExecutionContext;
import net.customware.gwt.dispatch.server.SimpleActionHandler;
import net.customware.gwt.dispatch.shared.DispatchException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jlsites.demo.classroom.server.services.ClassroomUserService;
import com.jlsites.demo.classroom.shared.action.AddUserAction;
import com.jlsites.demo.classroom.shared.action.AddUserResult;
import com.jlsites.demo.classroom.shared.action.GetAllUsersAction;
import com.jlsites.demo.classroom.shared.action.GetAllUsersResult;
import com.jlsites.demo.classroom.shared.domain.ClassroomUser;

public class AddUserActionHandler extends
		SimpleActionHandler<AddUserAction, AddUserResult> {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(AddUserActionHandler.class);
	private ClassroomUserService userService;

	public AddUserActionHandler(ClassroomUserService userService) {
		this.userService = userService;
	}

	@Override
	public AddUserResult execute(AddUserAction action, ExecutionContext context)
			throws DispatchException {
		LOGGER.debug(">>AddUserActionHandler.execute");

		// add an user
		ClassroomUser user = new ClassroomUser();
		user.setUserName(action.getUserName());
		user.setPic(action.getPic());
		userService.createUser(user);

		// get all users by executing another action or by the user service
		GetAllUsersResult allUsersRlt = context
				.execute(new GetAllUsersAction());
		AddUserResult rlt = new AddUserResult();
		rlt.getAllUsers().addAll(allUsersRlt.getAllUsers());

		return rlt;
	}

}
