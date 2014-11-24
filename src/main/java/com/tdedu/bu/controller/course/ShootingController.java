package com.tdedu.bu.controller.course;

import java.io.File;
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.tdedu.bu.domain.Shooting;
import com.tdedu.bu.service.ShootingService;

@Controller
@RequestMapping("/shooting")
public class ShootingController {
	@Autowired
	private ShootingService shootingService; 
	@Autowired
	private ServletContext servletContext;
	
	@RequestMapping("/addShooting")
	public String addShooting(@RequestParam("file") CommonsMultipartFile mFile,Shooting shooting){
		if (!mFile.isEmpty()) {
			//获取文件存放的路径/WEB-INF/AccountFile
			String storeDir = servletContext.getRealPath("/")
					+ "/WEB-INF/ShootingFile";
			File file = new File(storeDir);
			if (!file.exists())
				file.mkdirs();
			// 新建一个文件
			try {
				String repositoryFile=storeDir + "/" + new Date().toLocaleString().split(" ")[0]
						+"_"+new Date().getTime()+"_"+mFile.getOriginalFilename();
			
				File storeFile = new File(StringUtils.deleteSpaces(repositoryFile));
				// 将上传的文件写入新建的文件中
				mFile.getFileItem().write(storeFile);
				System.out.println(repositoryFile);
				shooting.setId(UUID.randomUUID().toString());
				shooting.setPhotoUrl(repositoryFile);
				shooting.setOnlineDate(new Date());
				shootingService.saveShooting(shooting);
				return "main.jsp";
			} catch (Exception e) {
				e.printStackTrace();				
			}
		
		}
		return "XX.jsp";
	}
	
}
