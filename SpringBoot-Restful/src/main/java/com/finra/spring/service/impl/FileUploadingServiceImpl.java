package com.finra.spring.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.finra.spring.dao.FileUploadingDao;
import com.finra.spring.model.DocumentMetadata;
import com.finra.spring.service.FileUploadingService;

@Service("fileUploadService")
public class FileUploadingServiceImpl implements FileUploadingService {

	private static final Logger logger = Logger.getLogger(FileUploadingServiceImpl.class);

	@Autowired
	FileUploadingDao fileUploadingDao;

	/* (non-Javadoc)
	 * @see com.finra.spring.service.FileUploadingService#saveUploadedFile(org.springframework.web.multipart.MultipartFile)
	 * 
	 * This method gets the Uploaded file from the controller and generates DocumentMetadata Object
	 * and passes the documentMetadata object to the dao layer.
	 */
	@Override
	public boolean saveUploadedFile(MultipartFile uploadFile) {
		logger.info("Service Class...");
		DocumentMetadata docMetaData = getMetaData(uploadFile);
		boolean status = fileUploadingDao.saveDocumentMetaData(docMetaData);
		return status;
	}

	/**
	 * This method gets  the details of the UploadedFile and generates DocumentMetadata Object
	 * @param uploadFile
	 * @return DocumentMetaData
	 */
	private DocumentMetadata getMetaData(MultipartFile uploadFile) {
		DocumentMetadata docMetaData = new DocumentMetadata();
		docMetaData.setFileName(uploadFile.getOriginalFilename());
		// docMetaData.setContent(uploadFile.getBytes());
		docMetaData.setContentType(uploadFile.getContentType());
		docMetaData.setSize(uploadFile.getSize());
		return docMetaData;
	}

}
