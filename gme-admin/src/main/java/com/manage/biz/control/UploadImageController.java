package com.manage.biz.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping(value="${adminPath}/biz/uploadImage")
public class UploadImageController {

	
	@RequestMapping(value = "test",method = RequestMethod.POST)
	public String test (MultipartFile iconImgUpload){
		if (iconImgUpload != null)
		System.out.println(iconImgUpload.getName());
		return "a";
	}
}
