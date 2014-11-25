package com.tdedu.bu.controller.course;

import java.io.File;
import java.io.PrintWriter;
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	
	@RequestMapping("/deleteShooting")
	public void deleteShooting(@RequestParam("id")String ids,PrintWriter printWrite){
		String[] shootingIds=ids.split(",");
		String result="null";
		try{
		shootingService.deleteShooting(shootingIds);
		result="OK";
		}catch(Exception e){
			e.printStackTrace();
			result="Mistake";
		}
		printWrite.write(result);
		printWrite.flush();
		printWrite.close();
	}
	
	@RequestMapping("/updateShooting")
	public String updateShooting(Shooting shooting,Model model){
		try {
			shootingService.updateShooting(shooting);
			model.addAttribute("success","操作成功");
			return "listShooting.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("error", "更新失败");
			return "XX.jsp";
		}
	}
	
}
