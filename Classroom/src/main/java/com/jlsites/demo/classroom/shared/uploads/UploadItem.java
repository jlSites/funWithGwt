package com.jlsites.demo.classroom.shared.uploads;

import java.io.Serializable;

public class UploadItem implements Serializable {
	private static final long serialVersionUID = 4158741570270843971L;

	private String filename;
	private String ctype;
	private int size;

	public UploadItem() {
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getCtype() {
		return ctype;
	}

	public void setCtype(String ctype) {
		this.ctype = ctype;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

}
