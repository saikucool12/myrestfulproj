package com.finra.spring.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.finra.spring.service.FileUploadingService;

@Controller
public class RestFileUploadController {

	private static final Logger logger = Logger.getLogger(RestFileUploadController.class);

	@Autowired
	FileUploadingService fileUploadService;
	
	/**
	 * This method navigates to the index.html view.
	 * @return view
	 */
	@RequestMapping("/")
	public String index(){
		logger.info("Navigating to home page!!!");
		return "index.html";
	}
	
	/**
	 * This is a Rest service, which gets the File, which has been uploaded 
	 * This method calls the service layer by passing the uploadFile details
	 * @param uploadFile
	 * @return Message
	 */
	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	public ResponseEntity<?> uploadFile(@RequestParam("uploadFile") MultipartFile uploadFile) {
		logger.info("Upload File Method!!!");
		boolean status = fileUploadService.saveUploadedFile(uploadFile);
		if(status){
			return new ResponseEntity<>(HttpStatus.OK);
		}else{
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

}
