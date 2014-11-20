package com.tdedu.bu.controller.account;

import java.io.PrintWriter;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tdedu.bu.domain.Manager;
import com.tdedu.bu.domain.Password;
import com.tdedu.bu.service.ManagerService;
import com.tdedu.bu.service.PasswordService;


@Controller
public class ManagerController {
	@Autowired	
	private ManagerService managerService;
	@Autowired
	private PasswordService passwordService;
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
	@RequestMapping(value="/manager/setManager")
	public void setManager(String uid,PrintWriter printWriter){
		Manager manager=new Manager();
		manager.setManagerId(uid);
		manager.setManagerRole("普通管理员");
		manager.setManagerStatus(2);
		String result="null";
		try{
		managerService.setManager(manager);
		result="设置成功";
		}catch(Exception e){
			e.printStackTrace();
			result="系统错误，设置失败!";
		}
		printWriter.write(result);
		printWriter.flush();
		printWriter.close();
	}
}
