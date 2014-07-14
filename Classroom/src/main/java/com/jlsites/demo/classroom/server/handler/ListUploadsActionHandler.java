package com.jlsites.demo.classroom.server.handler;

import java.io.File;

import net.customware.gwt.dispatch.server.ExecutionContext;
import net.customware.gwt.dispatch.server.SimpleActionHandler;
import net.customware.gwt.dispatch.shared.ActionException;
import net.customware.gwt.dispatch.shared.DispatchException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jlsites.demo.classroom.shared.action.ListUploadsAction;
import com.jlsites.demo.classroom.shared.action.ListUploadsResult;
import com.jlsites.demo.classroom.shared.uploads.UploadItem;

public class ListUploadsActionHandler extends
		SimpleActionHandler<ListUploadsAction, ListUploadsResult> {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(ListUploadsActionHandler.class);

	public ListUploadsActionHandler() {
	}

	@Override
	public ListUploadsResult execute(ListUploadsAction action,
			ExecutionContext context) throws DispatchException {
		LOGGER.debug(">>ListUploadsActionHandler.execute");

		// get all uploads
		ListUploadsResult rlt = new ListUploadsResult();
		String catalinaBase = System.getProperty("CATALINA_BASE");
		if (catalinaBase == null || catalinaBase.trim().length() == 0) {
			throw new ActionException("CATALINA_BASE is not set properly");
		}

		File f = new File(catalinaBase + "/uploads");
		for (String strName : f.list()) {
			UploadItem item = new UploadItem();
			item.setFilename(strName);
			rlt.getAllItems().add(item);
		}

		return rlt;
	}

}
