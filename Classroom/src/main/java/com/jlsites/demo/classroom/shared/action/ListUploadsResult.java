package com.jlsites.demo.classroom.shared.action;

import java.util.ArrayList;
import java.util.List;

import net.customware.gwt.dispatch.shared.Result;

import com.jlsites.demo.classroom.shared.uploads.UploadItem;

public class ListUploadsResult implements Result {

	private List<UploadItem> allItems;

	public ListUploadsResult() {
	}

	public List<UploadItem> getAllItems() {
		if (allItems == null) {
			allItems = new ArrayList<UploadItem>();
		}
		return allItems;
	}
}
