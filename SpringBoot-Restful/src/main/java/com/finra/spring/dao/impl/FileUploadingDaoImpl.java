package com.finra.spring.dao.impl;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.finra.spring.dao.FileUploadingDao;
import com.finra.spring.model.DocumentMetadata;

@Repository("fileUploadingDao")
public class FileUploadingDaoImpl implements FileUploadingDao{
	
	private static final Logger logger = Logger.getLogger(FileUploadingDaoImpl.class);

	/**
	 * This method is used to write the Meta Data to a text file.
	 */
	@Override
	public boolean saveDocumentMetaData(DocumentMetadata docMetaData) {
		logger.info("FileUploading Dao Impl class..");
		boolean status = false;
		try(FileOutputStream fos = new FileOutputStream("metadata.txt");
				ObjectOutputStream oos = new ObjectOutputStream(fos);){
			oos.writeObject(docMetaData.toString());
			status = true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return status;
	}

}
