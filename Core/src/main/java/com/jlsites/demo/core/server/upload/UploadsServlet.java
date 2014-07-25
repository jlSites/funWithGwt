package com.jlsites.demo.core.server.upload;

import gwtupload.server.UploadAction;
import gwtupload.server.exceptions.UploadActionException;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jlsites.demo.core.shared.IConstants;

public class UploadsServlet extends UploadAction {
	private static final long serialVersionUID = 4848523543067264403L;
	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public String executeAction(HttpServletRequest request,
			List<FileItem> sessionFiles) throws UploadActionException {
		// save the files into the "/uploads"

		String catalinaBase = System.getenv(IConstants.ENV_CATALINA_BASE);
		if (catalinaBase == null || catalinaBase.trim().length() == 0) {
			logger.error("{} is not set properly", IConstants.ENV_CATALINA_BASE);
			throw new UploadActionException("CATALINA_BASE is not set properly");
		}

		String response = "";
		for (FileItem item : sessionFiles) {
			if (!item.isFormField()) {
				try {
					File f = new File(catalinaBase + IConstants.UPLOADS_FOLDER
							+ item.getName());
					logger.info("save an uploaded file into="
							+ f.getAbsolutePath());
					item.write(f);

					// Send a customized message to the client.
					response += "File saved as " + f.getAbsolutePath();
				} catch (Exception e) {
					throw new UploadActionException(e);
				}
			}
		}

		// / Remove files from session because we have a copy of them
		removeSessionFileItems(request);

		// / Send your customized message to the client.
		return response;
	}
}
