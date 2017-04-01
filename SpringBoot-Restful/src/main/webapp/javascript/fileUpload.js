/**
 * Uploading the File
 */

$(document).ready(function(){
	
	$("#uploadFileButton").click(function(){
		$.ajax({
			url:"/uploadFile",
			type:"POST",
			data: new FormData($("#upload-file-form")[0]),
	        enctype: 'multipart/form-data',
	        processData: false,
	        contentType: false,
	        cache: false,
	        success:function(){
	        	//Handling Success
	        	$("#upload-file-message").text("File has been Uploaded and Meta-data is written");
	        },
	        error:function(){
	        	//Handling Error
	        	$("#upload-file-message").text("File is not Uploaded. Please check once!!!");
	        }
		});
	});

});

