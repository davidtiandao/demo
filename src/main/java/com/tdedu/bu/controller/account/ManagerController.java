package com.tdedu.bu.controller.account;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.tdedu.bu.domain.Manager;
import com.tdedu.bu.domain.Password;
import com.tdedu.bu.domain.UserInformation;
import com.tdedu.bu.service.ManagerService;
import com.tdedu.bu.service.PasswordService;
import com.tdedu.bu.service.UserInformationService;
import com.tdedu.bu.web.Page;
import com.tdedu.bu.web.PageUtil;

@Controller
@RequestMapping("/manager")
public class ManagerController {
	
	@Autowired
	private ManagerService managerService;
	@Autowired
	private UserInformationService userInformationService;
	@Autowired
	private PasswordService passwordService;
	@Autowired
	private ServletContext servletContext;
	/*
	 * 上传表格功能，文件格式.xslx或者.xsl
	 */
	@RequestMapping("/upload")
	private String upload(@RequestParam("file") CommonsMultipartFile mFile,
			HttpServletRequest request) {
		if (!mFile.isEmpty()) {
			//获取文件存放的路径/WEB-INF/AccountFile
			String storeDir = servletContext.getRealPath("/")
					+ "/WEB-INF/AccountFile";
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
				userInformationService.save(storeFile.toString());
			} catch (Exception e) {
				e.printStackTrace();
			}

	

		}
		return "xx.jsp"	;
	}
	@RequestMapping("/listUser")
	@ResponseBody
	public String listUser(Integer pageNo,HttpServletResponse response) throws Exception{
		response.setHeader("Content-Type", "text/plain;charset=UTF-8");
		
		Page page=PageUtil.currentPage();
		page.setPageNo(pageNo);
		if("".equals(page.getOrderBy()))
		page.setOrderBy("CREATE_DATE");
		List<UserInformation> users= userInformationService.listUser(page);
		return JSONObject.toJSON(users).toString();
		
	}

	

	



	/*
	 * 判断用户是否是管理员
	 */
	@RequestMapping(value="/account/checkIsManager" )
	public void CheckIsManager(String uid,PrintWriter printWriter){
		Manager manager=managerService.findById(uid);
		String result="null";
		if(manager==null || "".equals(manager.getManagerStatus())){
			result="Mistake";	
		}else{
			result="OK";
		}
		printWriter.write(result);
		printWriter.flush();
		printWriter.close();
	}
	/*
	 * 后台登录，管理员信息存入session
	 */
	@RequestMapping(value="/account/managerLogin")
	public String  managerLogin(Password password,HttpSession session,Model model){
		Password passwordNow= passwordService.findByPwdAndId(password);
		if(passwordNow == null){
			 model.addAttribute("error", "密码错误");
			 return "登录页面.jsp";
		 };
		 Manager manager=managerService.findById(passwordNow.getUserId());
		 if(manager.getManagerStatus()>50){
			 model.addAttribute("error", "状态异常，请联系其他管理员");
			 return "登录页面 .jsp";
		 }
		 session.setAttribute("currManager", manager);
		 return "后台主页面.jsp";
	}
	/*
	 * 设置为管理员 
	 * 状态设置为默认的正常
	 * 管理员角色默认设置为:普通管理员
	 */
	@RequestMapping(value="/manager/saveManager")
	public void saveManager(String uid,PrintWriter printWriter){
		Manager manager=new Manager();
		manager.setManagerId(uid);
		manager.setManagerRole("普通管理员");
		manager.setManagerStatus(2);
		String result="null";
		try{
		managerService.saveManager(manager);
		result="设置成功";
		}catch(Exception e){
			e.printStackTrace();
			result="系统错误，设置失败!";
		}
		printWriter.write(result);
		printWriter.flush();
		printWriter.close();
	}
	/*
	 * 取消管理
	 */
	@RequestMapping(value="/manager/deleteManager")
	public void deleteManager(@RequestParam("id")String ids,PrintWriter printWriter){
		String[] managerIds=ids.split(",");
		String result="null";
		try{
		managerService.deleteManager(managerIds);
		result="设置成功";
		}catch(Exception e){
			e.printStackTrace();
			result="系统错误，设置失败!";			
		}
		printWriter.write(result);
		printWriter.flush();
		printWriter.close();
	}
	/*
	 * 暂停开通管理
	 */
	@RequestMapping("/manager/setManager")
	public void setManager(@RequestParam("id")String ids,Integer managerStatus,PrintWriter printWriter){
		String[] managerIds=ids.split(",");
		String result="null";
		try{
		managerService.setManagerStatus(managerIds,managerStatus);
		result="OK";
		}catch(Exception e){
			result= "Mistake";
		}
		printWriter.write(result);
		printWriter.flush();
		printWriter.close();
		
	}
}
