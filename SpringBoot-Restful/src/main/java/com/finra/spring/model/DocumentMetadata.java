package com.finra.spring.model;

import java.io.Serializable;

public class DocumentMetadata implements Serializable{

	private static final long serialVersionUID = -5203348114991324254L;

	private String fileName;
	private String contentType;
	private byte[] content;
	private long size;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "DocumentMetadata [fileName=" + fileName + ", contentType=" + contentType + ", size=" + size + "]";
	}
	
	
}
