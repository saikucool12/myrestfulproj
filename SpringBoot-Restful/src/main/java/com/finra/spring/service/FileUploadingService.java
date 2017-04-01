package com.finra.spring.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileUploadingService {

	public boolean saveUploadedFile(MultipartFile uploadFile);
}
