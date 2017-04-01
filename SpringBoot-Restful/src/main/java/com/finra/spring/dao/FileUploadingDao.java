package com.finra.spring.dao;

import com.finra.spring.model.DocumentMetadata;

public interface FileUploadingDao {

	boolean saveDocumentMetaData(DocumentMetadata docMetaData);

}
